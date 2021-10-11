package com.github.ingride.kafka.firsttutorial;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class ConsumerRunnable implements Runnable {
    private CountDownLatch latch;
    private KafkaConsumer<String, String> consumer;

    public ConsumerRunnable(CountDownLatch latch, String bootstrapServers, String groupId, String topic) {
        this.latch = latch;

        // create consumer properties
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); //can be earliest/latest/none

        // create consumer
        this.consumer = new KafkaConsumer<String, String>(properties);

        // subscribe consumer to a topic;
        this.consumer.subscribe(Arrays.asList(topic));
    }

    @Override
    public void run() {
        // poll for new data
        try {
            while (true) {
                // logs the records for another_topic
                // consumes incoming messages to another_topic
                // can be subscribed to 1+ topics
                ConsumerRecords<String, String> records = this.consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, String> record: records) {
                    ConsumerDemoWithThread.logger.info("Key: " + record.key() + ", Value: "+record.value());
                    ConsumerDemoWithThread.logger.info("Partition: "+record.partition() + ", Offset: "+record.offset());
                }
            }
        } catch (WakeupException e) {
            ConsumerDemoWithThread.logger.info("Received shutdown signal");
        } finally {
            this.consumer.close();
            // tell our main code we're done with this consumer
            this.latch.countDown();
        }
    }

    public void shutdown() {
        // it interrupts the consumer.poll() process
        // it will throw a WakeUpException
        this.consumer.wakeup();
    }
}

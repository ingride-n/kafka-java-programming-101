# Java Programming with Apache Kafka

## Preliminary Setup (MacOS)

### Download It
- [ ] Go to https://kafka.apache.org/downloads to download the open-source software for Kafka. (Use the binary download link associated with Scala 2.12)
- [ ] Move the downloaded zip file: `mv Downloads/<file-name>.tgz ~/`
- [ ] Uncompress the zip file as a directory: `tar -xvf <file-name>.tgz`

### Install Java
- [ ] Check the current version of Java on your computer:
```
java -version 
```
- [ ] Install version 8 using Homebrew: 
```
brew tap caskroom/versions
brew cask install java8
```

### Install IntelliJ IDEA



Done with setup!

## Try the Kafka CLI
1. List all commands in the `bin` directory:
```
cd kafka_2.12-<version>/bin
ls 
```
2. Try using a CLI command (list topics)
```
kafka-topics.sh
```
3. Add the Kafka CLI commands to your `PATH` variable by appending the following line to the end of your `~/.bash_profile`. To get an accurate path to your kafka `bin` directory, execute `pwd` from that location.
```
export PATH="$PATH:Users/<user>/kafka_2.12-<version>/bin"
```
4. Navigate to a different directory. Try out the command interface by typing `kafka-` followed by the tab. It should list all commands. Use arrow keys to navigate and type Enter to execute. 

## Start Zookeeper and Kafka
1. Navigate to your `kafka_2.12-<version>` directory. Make sure you have a `config/` directory. 
2. Create a data directory:
```
mkdir data
mkdir data/zookeeper
mkdir data/kafka
```
3. Update your `config/zookeeper.properties` file with this edit (Use `pwd` to get the full path): 
```
dataDir=<full-path-kafka>/data/zookeeper
```
4. Edit your `config/server.properties` file:
```
log.dirs=<full-path-kafka>/data/kafka
```
6. Start the zookeeper server (once it is started, you will get a message that it is binding to port 2181):
```
zookeeper-server-start config/zookeeper.properties
```
6. In a second terminal window, start your kafka server (binds to port 9092):
```
kafka-server-start config/server.properties
```



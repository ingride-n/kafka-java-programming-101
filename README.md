# Java Programming with Apache Kafka

## Preliminary Setup (MacOS)

### Download It
- [ ] Go to https://kafka.apache.org/downloads to download the open-source software for Kafka. (Use the binary download link associated with Scala 2.12)
- [ ] Move the downloaded zip file: `mv Downloads/<file-name>.tgz ~/`
- [ ] Uncompress the zip file as a directory: `tar -xvf <file-name>.tgz`

### Try the Kafka CLI
- [ ] List all commands in the `bin` directory:
```
cd kafka_2.21-<version>/bin
ls 
```
- [ ] Try using a CLI command (list topics)
```
kafka-topics.sh
```
- [ ] Add the Kafka CLI commands in your `PATH`: 

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



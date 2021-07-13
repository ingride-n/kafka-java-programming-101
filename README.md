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

### Try the Kafka CLI
- [ ] List all commands in the `bin` directory:
```
cd kafka_2.12-<version>/bin
ls 
```
- [ ] Try using a CLI command (list topics)
```
kafka-topics.sh
```
- [ ] Add the Kafka CLI commands to your `PATH` variable. Append the following line at the end of your `~/.bash_profile`. To get accurate path to your kafka `bin` directory, execute `pwd` from that location.
```
export PATH="$PATH:Users/<user>/kafka_2.12-<version>/bin"
```
- [ ] Navigate to a different directory. Try out the command interface by typing `kafka-` followed by the tab. It should list all commands. Use arrow keys to navigate and type Enter to execute. 


# KAFKA


Generate a random UUID for Kafka log directory initialization (used in KRaft mode)
.\bin\windows\kafka-storage.bat random-uuid

 Format the Kafka log directory using the generated UUID and server properties (initializes the KRaft metadata log)
.\bin\windows\kafka-storage.bat format -t SnyplhxITWGvjAzZx_9NoQ -c .\config\kraft\server.properties

# Start the Kafka server in KRaft mode using the specified configuration
.\bin\windows\kafka-server-start.bat .\config\kraft\server.properties

# Create a new Kafka topic named "test" with 1 partition and a replication factor of 1
.\bin\windows\kafka-topics.bat --create --topic test --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
# Start a Kafka console producer to send messages to "test"
.\bin\windows\kafka-console-producer.bat --topic test --bootstrap-server localhost:9092

# Start a Kafka console consumer to read messages from "testc" from the beginning
.\bin\windows\kafka-console-consumer.bat --topic test --from-beginning --bootstrap-server localhost:9092


#List cmd :  .\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list

#Describe cmd :   .\bin\windows\kafka-topics.bat --topic user-topic  --bootstrap-server localhost:9092 --describe

#Delete :  .\bin\windows\kafka-topics.bat --delete --topic topic1  --bootstrap-server localhost:9092



# produce msg key-value pair
.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic topic-user --property "parse.key=true" --property "key.separator=:"


# Consume msg key-value pair
.\bin\windows\kafka-console-consumer.bat --topic topic-user --from-beginning --bootstrap-server localhost:9092 --property print.key=true --property print.value=true


.\bin\windows\kafka-console-consumer.bat --topic product-created-events-topic  --from-beginning --bootstrap-server localhost:9092 --property print.key=true




Mutliple Kafka Brokers: 

.\bin\windows\kafka-storage.bat random-uuid
Key: Hepc7G3SSwmIclIXkFPDow
format :
.\bin\windows\kafka-storage.bat format -t Yrtfxx92QcWz0Qa3oDF7-g -c .\config\kraft\server-1.properties
.\bin\windows\kafka-storage.bat format -t Hepc7G3SSwmIclIXkFPDow -c .\config\kraft\server-2.properties
.\bin\windows\kafka-storage.bat format -t Hepc7G3SSwmIclIXkFPDow -c .\config\kraft\server-3.properties

Start Server :
.\bin\windows\kafka-server-start.bat .\config\kraft\server-1.properties
.\bin\windows\kafka-server-start.bat .\config\kraft\server-2.properties
.\bin\windows\kafka-server-start.bat .\config\kraft\server-3.properties

Start all 3 server and then create the topic :
.\bin\windows\kafka-topics.bat --create --topic insync-topic --partitions 3 --replication-factor 3 --bootstrap-server localhost:9092 --config min.insync.replicas=2


#min.insync.replicas configuration :
.\bin\windows\kafka-configs.bat --bootstrap-server localhost:9092 --alter --entity-type topics --entity-name topic4 --add-config min.insync.replicas=2


Dead Letter Topic :

DLT Producer Cmd:

.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic product-created-events-topic --property "parse.key=true" --property "key.separator=:"


DLT Consumer Cmd: 

.\bin\windows\kafka-console-consumer.bat --topic product-created-events-topic-dlt --bootstrap-server localhost:9092 --from-beginning --property print.key=true --property print.value=true




To start zookeper : C:\kafka_2.13-3.6.0>bin\windows\zookeeper-server-start.bat config\zookeeper.properties

To start kakfka server : $env:KAFKA_HEAP_OPTS = "-Xmx1G -Xms1G"
 bin\windows\kafka-server-start.bat config\server.properties


To create topic :  .\bin\windows\kafka-topics.bat --create --topic user-topic --bootstrap-server localhost:9092
Or 
 .\bin\windows\kafka-topics.bat --create --topic user-topic --partitions 3 --replication-factor 3  --bootstrap-server localhost:9092

Produce new topic :  .\bin\windows\kafka-console-producer.bat --topic user-topic --bootstrap-server localhost:9092


Consume new topic : .\bin\windows\kafka-console-consumer.bat --topic user-topic --from-beginning --bootstrap-server localhost:9092

List cmd :  .\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list

Describe cmd :   
.\bin\windows\kafka-topics.bat --topic user-topic  --bootstrap-server localhost:9092 --describe

Delete :  .\bin\windows\kafka-topics.bat --delete --topic topic1  --bootstrap-server localhost:9092
<img width="921" height="516" alt="image" src="https://github.com/user-attachments/assets/d0e0ffb2-7913-48cb-92a7-61c87d493bdf" />



<img width="1283" height="1675" alt="image" src="https://github.com/user-attachments/assets/7996f604-1da6-4682-9a78-053ebd070cab" />

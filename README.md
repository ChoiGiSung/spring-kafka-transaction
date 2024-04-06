# spring-kafka-transaction


If producer is a transaction producer, consumer needs to modify the isolation level.  
read_committed means that it will read only committed messages, and read_uncommitted means that it will also read uncommitted messages.  

Read_committed increases lag because it does not read uncommitted messages.  
This may be considered an error.  
You can respond to this with fixTxOffets on the container.  
This setting initializes increased lag due to previous uncommitted messages when reading committed messages.  

# How to run

1. cd docker
2. docker-compose up -d
3. run [TransactionApplication.kt](producer%2Fsrc%2Fmain%2Fkotlin%2Fcom%2Fexample%2Ftransaction%2FTransactionApplication.kt)
4. visit localhost:10000 and search 'testTopic'
5. chose consumers tab. and you can see messages behind
6. run application Test Code 
* errorFirst: error first, success second -> messages behind is 0
* errorSecond: success first, error second -> messages behind is 2  
or you can publish message.
success, fail

ps.  
"Messages behind always stays at 1, but I don’t understand why."

package bigdate.insert;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC2{
   public static void main( String args[] ){
      try{   
      // 连接到 mongodb 服务
      MongoClient mongoClient = new MongoClient( "192.168.2.65" , 27017 );
         
       
      // 连接到数据库
      MongoDatabase mongoDatabase = mongoClient.getDatabase("tan");  
      System.out.println("Connect to database successfully");
      mongoDatabase.createCollection("yong");
      System.out.println("集合创建成功");
        
      }catch(Exception e){
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     }
   }
}
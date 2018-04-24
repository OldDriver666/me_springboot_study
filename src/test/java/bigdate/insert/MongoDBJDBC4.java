package bigdate.insert;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBJDBC4{
   public static void main( String args[] ){
      try{   
         // 连接到 mongodb 服务
         MongoClient mongoClient = new MongoClient( "192.168.2.65" , 27017 );
         
         // 连接到数据库
         MongoDatabase mongoDatabase = mongoClient.getDatabase("tan");  
         System.out.println("Connect to database successfully");
         
         MongoCollection<Document> collection = mongoDatabase.getCollection("yong");
         System.out.println("集合 yong 选择成功");
         
         //检索所有文档  
         /** 
         * 1. 获取迭代器FindIterable<Document> 
         * 2. 获取游标MongoCursor<Document> 
         * 3. 通过游标遍历检索出的文档集合 
         * */  
         long start = System.currentTimeMillis();
         BasicDBObject queryObject = new BasicDBObject("userId",999);
         FindIterable<Document> findIterable = collection.find(queryObject);  
         MongoCursor<Document> mongoCursor = findIterable.iterator();  
         long end = System.currentTimeMillis();
         System.out.println(end-start);
//         while(mongoCursor.hasNext()){  
//            System.out.println(mongoCursor.next());  
//         }  
      
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
   }
}
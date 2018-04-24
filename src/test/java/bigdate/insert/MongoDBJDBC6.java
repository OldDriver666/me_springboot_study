package bigdate.insert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC6 {
	public static void main(String args[]) {
		try {
			// 连接到 mongodb 服务
			MongoClient mongoClient = new MongoClient("192.168.2.65", 27017);

			// 连接到数据库
			MongoDatabase mongoDatabase = mongoClient.getDatabase("tan");
			System.out.println("Connect to database successfully");

			MongoCollection<Document> collection = mongoDatabase.getCollection("yong");
			System.out.println("集合 yong 选择成功");
			// 开始时间
			Long begin = new Date().getTime();
			// 插入文档
			/**
			 * 1. 创建文档 org.bson.Document 参数为key-value的格式 2. 创建文档集合List<Document> 3.
			 * 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用
			 * mongoCollection.insertOne(Document)
			 */
			List<Document> documents = new ArrayList<Document>();

			Calendar ca = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date curDate = df.parse("2018-06-01 00:00:00");
			Date endDate = df.parse("2018-06-31 00:00:00");
			int flag = 0;
			int c = 1000;
			int max = 1000;
			int count= 0;

			while (curDate.compareTo(endDate) <= 0) {
				count++;
				ca.setTime(curDate);
				// 业务处理...
				ca.add(ca.MINUTE, 5);
				curDate = ca.getTime();

				// 第j次提交步长
				for (int z = 1; z <= c; z++) {
					Document document = new Document("userId", z).append("createtime", df.format(curDate)).append("location_x", 22.6845380)
							.append("location_y", 113.9856481);
					documents.add(document);
				}
				flag++;
				if (flag == max) {
					collection.insertMany(documents);
					flag = 0;
					documents.clear();
				}
			}
			
			// 结束时间
			Long end = new Date().getTime();
			// 耗时
			System.out.println(count*c/10000 + "万条数据插入花费时间 : " + (end - begin) / 1000 + " s");
			System.out.println("插入完成");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}

package tobi.ye.mongodbDemo.dao.original;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.BeforeClass;
import org.junit.Test;
import tobi.ye.mongodbDemo.util.MongoFactory;

import java.util.Date;

/**
 * Created by lazyguy on 2016-3-7.
 */
public class GenTest {

    private static MongoClient mongoClient;

    @BeforeClass
    public static void  beforeClass(){
        mongoClient = MongoFactory.getMongoClient();
    }
    @Test
    public void t(){
        MongoDatabase mongoDatabase = mongoClient.getDatabase("p2nr");
        //就算没有这个Collection，默认就会创建。
        MongoCollection<Document> notExist = mongoDatabase.getCollection("notExist");
        notExist.insertOne(new Document("name","whatever"));
    }
    @Test
    public void tdt(){
        MongoDatabase mongoDatabase = mongoClient.getDatabase("p2nr");
        //就算没有这个Collection，默认就会创建。
        MongoCollection<Document> notExist = mongoDatabase.getCollection("notExist");
        FindIterable<Document> documents = notExist.find();
        for (Document document : documents) {
            System.out.println(document);
        }
    }
    @Test
    public void tt(){

    }


}

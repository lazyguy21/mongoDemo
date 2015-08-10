package tobi.ye.mongodbDemo.dao;

import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import tobi.ye.mongodbDemo.util.MongoFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ye on 15-7-23.
 */
public class ProductDAOTest {

    private MongoCollection<Document> geoCollection;

    @Before
    public void beforeClass() {
        MongoFactory.getCollection("geo", "zips");
    }
    @Test
    public void testY1(){
        MongoCollection collection = MongoFactory.getCollection("syslog", "userLog");
//        collection.insertOne();
    }

    @Test
    public void testY() {
        MongoCollection<Document> collection = MongoFactory.getDatabase("test").getCollection("people");
        ArrayList result = collection.find().into(new ArrayList());
        System.out.println(result);
    }
    @Test
    public void testZ() {
        MongoCollection<Document> collection = MongoFactory.getDatabase("test").getCollection("people");
        ArrayList<Document> into = collection.find(Filters.eq("name", "yyf")).into(new ArrayList<Document>());
        System.out.println(into);
    }
}

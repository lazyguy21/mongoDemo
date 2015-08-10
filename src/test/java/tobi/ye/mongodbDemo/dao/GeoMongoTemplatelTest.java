package tobi.ye.mongodbDemo.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import tobi.ye.mongodbDemo.dao.util.AbstractServiceTest;
import tobi.ye.mongodbDemo.model.Person;
import tobi.ye.mongodbDemo.util.MongoFactory;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by ye on 15-7-23.
 */
@Slf4j
public class GeoMongoTemplatelTest extends AbstractServiceTest {

    @Autowired
    @Qualifier(value = "geoMongoTemplate")
    private MongoOperations geoMongoTemplate;

    @Before
    public void beforeClass() {
        MongoFactory.getCollection("geo", "zips");
    }
    @Test
    public void testInsert(){
        Person p = new Person("Joe", 34);

        // Insert is used to initially store the object into the database.
        geoMongoTemplate.insert(p);

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

package tobi.ye.mongodbDemo.dao;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
public class testMongoTemplatelTest extends AbstractServiceTest {

    @Autowired
    @Qualifier(value = "testMongoTemplate")
    private MongoOperations testMongoTemplate;
    @Resource
    MongoClient mongoClient;

    @Before
    public void beforeClass() {
        MongoFactory.getCollection("geo", "zips");
    }
    @Test
    public void testInsert(){
        Person p = new Person("Joe", 34);

        // Insert is used to initially store the object into the database.
        testMongoTemplate.insert(p);


    }
    @Test
    public void testFindById(){
        // Find
       Person p = testMongoTemplate.findById("55c2f23155cb6e31d3dd06bb", Person.class);
        System.out.println(p);
    }
    @Test
    public void testPeople() {
        MongoDatabase test = mongoClient.getDatabase("test");
        MongoCollection<Document> peopleCollectionNew = test.getCollection("people");
        DBCollection peopleCollection = testMongoTemplate.getCollection("people");
//        peopleCollectionNew.find()
    }

}

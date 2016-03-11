package tobi.ye.mongodbDemo.dao;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import tobi.ye.mongodbDemo.dao.util.AbstractServiceTest;
import tobi.ye.mongodbDemo.model.Person;
import tobi.ye.mongodbDemo.util.MongoFactory;

import javax.annotation.Resource;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by ye on 15-7-23.
 */
@Slf4j
public class GenericMongoTemplatelTest extends AbstractServiceTest {

    @Autowired
    @Qualifier(value = "p2nrMongoTemplate")
    private MongoOperations p2nrMongoTemplate;
    @Resource
    MongoClient mongoClient;

    @Before
    public void beforeClass() {
        MongoFactory.getCollection("p2nr", "notExist");
    }
    @Test
    public void testInsert(){
        Person p = new Person("Joe", 34);

        // Insert is used to initially store the object into the database.
        p2nrMongoTemplate.insert(p);
        System.out.println(p);


    }
    @Test
    public void testSave(){
        Person p = new Person("Joe", null);
        p.setId("56e227fb031c0f309078378c");
        p2nrMongoTemplate.save(p);
    }
    @Test
    public void testUpsert(){
        Query query = Query.query(where("_id").is("56e22964031c0f37087f0a31"));
        Update update = Update.update("name", "JoeUpdate");
        p2nrMongoTemplate.upsert(query, update,Person.class);
    }


}

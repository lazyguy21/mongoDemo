package tobi.ye.mongodbDemo.dao.spring;

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
import tobi.ye.mongodbDemo.model.Cloth;
import tobi.ye.mongodbDemo.model.People;
import tobi.ye.mongodbDemo.model.Person;
import tobi.ye.mongodbDemo.util.MongoFactory;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;

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
//        MongoFactory.getCollection("p2nr", "notExist");
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
        //Upsert和Save的区别在于，save会将JavaBean中其他null属性置为空。
        //区别类似于mysql的replace  和 insert  xxxx on duplicate update
        Query query = Query.query(where("_id").is("56e22964031c0f37087f0a31"));
        Update update = Update.update("name", "JoeUpdate");
        p2nrMongoTemplate.upsert(query, update,Person.class);
    }
    @Test
    public void testDistinct(){
//        p2nrMongoTemplate.
    }
    @Test
    public void updateNestDocumentInArray(){

    }

    @Test
    public void updateArray(){
        //$符号代表着查询条件中关于数组的部分查询出来的对应的数组下标，如果没有就是第一个
        //这儿就是cloth数组中name字段为skirt的那个嵌套cloth的数组下标
        Query query = Query.query(where("_id").is("56e3f1a7031c0f2fcc148548")
                .and("cloth.name").is("skirt"));
        Update update = Update.update("cloth.$.name", "skir2t");
        p2nrMongoTemplate.updateFirst(query, update, People.class);
    }
//    @Test
//    public void insert(){
//        Cloth cloth = new Cloth("上衣1", "clotho1", 123.32);
//        Cloth cloth1 = new Cloth("上衣2", "clotho2", 123.32);
//        Cloth cloth2 = new Cloth("上衣3", "clotho3", 123.32);
//        People people = new People();
//        p2nrMongoTemplate.insert();
//    }
}

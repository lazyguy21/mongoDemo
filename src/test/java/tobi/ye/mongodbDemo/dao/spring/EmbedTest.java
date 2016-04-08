package tobi.ye.mongodbDemo.dao.spring;

import com.google.common.collect.Lists;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import tobi.ye.mongodbDemo.dao.util.AbstractServiceTest;
import tobi.ye.mongodbDemo.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lazyguy on 2016-4-1.
 */
public class EmbedTest extends AbstractServiceTest {
    @Autowired
    @Qualifier(value = "p2nrMongoTemplate")
    private MongoOperations p2nrMongoTemplate;
    @Test
    public void testEmbedInsert(){
        House house = new House();
        house.setName("小命的家");
        house.setAddTime(new Date());
        house.setAddress("adfasdfadsf");

        Furniture furniture = new Furniture();
        furniture.setName("chair");
        furniture.setAddTime(new Date());
        Furniture furniture2 = new Furniture();
        furniture2.setName("desk");
        furniture2.setAddTime(new Date());
        ArrayList<Furniture> furnitures = Lists.newArrayList(furniture, furniture2);
        ObjectId objectId = new ObjectId();
        System.out.println(objectId.toString());
        house.setFurnitureList(furnitures);
        p2nrMongoTemplate.insert(house);
    }

}

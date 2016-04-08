package tobi.ye.mongodbDemo.dao.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import tobi.ye.mongodbDemo.dao.util.AbstractServiceTest;
import tobi.ye.mongodbDemo.model.Book;
import tobi.ye.mongodbDemo.model.Owner;

/**
 * Created by lazyguy on 2016-4-8.
 */
public class ManualReferenceTest extends AbstractServiceTest {
    @Autowired
    @Qualifier(value = "p2nrMongoTemplate")
    private MongoOperations p2nrMongoTemplate;
    @Test
    public void testMR(){
        Owner owner = new Owner();
        owner.setName("Donald");
        p2nrMongoTemplate.save(owner);
        Book book = new Book();
        //手动Reference，而且如果这2者间异常了，是不会回滚的，考虑造成的影响.
        book.setName("love");
        book.setOwnerId(owner.getId());
        p2nrMongoTemplate.save(book);
    }
    @Test
    public void testMRQuery(){
        Book book = p2nrMongoTemplate.findById("57074737031c0f2570ed8ba1", Book.class);
        System.out.println(book);
        Owner owner = p2nrMongoTemplate.findById(book.getOwnerId(), Owner.class);
        Owner noExistOwner = p2nrMongoTemplate.findById("111", Owner.class);
        System.out.println(owner);
        System.out.println(noExistOwner);
    }
}

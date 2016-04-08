package tobi.ye.mongodbDemo.dao.spring;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import tobi.ye.mongodbDemo.dao.util.AbstractServiceTest;
import tobi.ye.mongodbDemo.model.Cloth;
import tobi.ye.mongodbDemo.model.Comment;
import tobi.ye.mongodbDemo.model.People;
import tobi.ye.mongodbDemo.model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lazyguy on 2016-4-1.
 */
public class DBRefTest extends AbstractServiceTest {
    @Autowired
    @Qualifier(value = "p2nrMongoTemplate")
    private MongoOperations p2nrMongoTemplate;
    @Test
    public void addNestDocument(){
        People people = new People();
        people.setName("Joe");
        people.setTime(new Date());//mongoDb 默认值有么
        people.setAge(10);
        Cloth cloth = new Cloth("dress1","裙子1",235.123);
        Cloth cloth1 = new Cloth("skirt1","xiao裙2",234.123);
        Cloth cloth2 = new Cloth("shirt1","衬衫1",232.123);
        Cloth cloth3 = new Cloth("trousers1","裤子2",123.123);
        ArrayList list = new ArrayList();
        list.add(cloth);
        list.add(cloth1);
        list.add(cloth2);
        list.add(cloth3);
        people.setCloth(list);
        p2nrMongoTemplate.insertAll(list);
        System.out.println(list);
        p2nrMongoTemplate.insert(people);
    }
    @Test
    public void getD(){
        People people = p2nrMongoTemplate.findById("56fe274d031c0f3f4c058001", People.class);
        System.out.println(people);
    }


    @Test
    public void addPost(){
        Post post = new Post();
        post.setTitle("title题目");
        post.setContent("asdfasdfasdf啊撒的发生地方");
        Comment comment = new Comment("asdf1", "111111111a", new Date());
        Comment comment1 = new Comment("asdf2", "111111111a", new Date());
        Comment comment2 = new Comment("asdf3", "111111111a", new Date());
        ArrayList<Comment> comments = Lists.newArrayList(comment, comment1, comment2);
        post.setCommentList(comments);
        //org.springframework.data.mapping.model.MappingException: Cannot create a reference to an object with a NULL id.
        //DBRef的必须先保存，不然会报错，其实就是要先存了拿到Ids，才能去存。但是你就不能跟hibernate一样自动么？非要我去存？不科学
        p2nrMongoTemplate.insertAll(comments);
        p2nrMongoTemplate.save(post);
//        p2nrMongoTemplate.save();
    }

    @Test
    public void getPost(){
        Post post = p2nrMongoTemplate.findById("56fe2f3f031c0f3eac8e5225", Post.class);
        System.out.println(post);
        List<Comment> commentList = post.getCommentList();
        Comment comment = commentList.get(0);
        System.out.println(commentList);
        System.out.println(comment);
    }


}

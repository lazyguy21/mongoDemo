package tobi.ye.mongodbDemo.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

//@Configuration
public class AppConfig {

//    @Bean
    public Mongo mongo() throws Exception {
      return new Mongo("localhost");
  }
//    @Bean
  public MongoTemplate mongoTemplate() throws Exception {
      return new MongoTemplate(mongo(), "mydatabase");
  }
}
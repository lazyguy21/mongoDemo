package tobi.ye.mongodbDemo.util;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


/**
 * MongoDB3.0工厂类
 */
public class MongoFactory {
    private static LoadProperties properties = new LoadProperties("mongodb.properties");
    private static String uriStr = properties.getValue("mongo.uri");
    private static final MongoClient mongoClient;
    static {
    MongoClientURI uri = new MongoClientURI(uriStr);
    mongoClient = new MongoClient(uri);
    }
    private MongoFactory() {
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }
    public static MongoDatabase getDatabase(String dbName) {
        return getMongoClient().getDatabase(dbName);
    }

    public static MongoCollection getCollection(String dbName, String collectionName) {
        return getDatabase(dbName).getCollection(collectionName);
    }




}

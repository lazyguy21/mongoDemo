package tobi.ye.mongodbDemo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by lazyguy on 2016-4-7.
 */
@Document
public class Furniture {
    private String id;
    private String name;
    private Date addTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}

package tobi.ye.mongodbDemo.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by lazyguy on 2016-4-1.
 */
public class Comment {

    private String id;
    private String name;
    private String content;
    private Date addTime;
    public Comment(String name, String content, Date addTime) {
        this.name = name;
        this.content = content;
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", addTime=" + addTime +
                '}';
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}

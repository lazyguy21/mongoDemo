package tobi.ye.mongodbDemo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by lazyguy on 2016-4-1.
 */

public class Post {
    private String id;
    private String title;
    private String content;
    @DBRef(lazy = true)
    private List<Comment> commentList;

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", commentList=" + commentList +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}

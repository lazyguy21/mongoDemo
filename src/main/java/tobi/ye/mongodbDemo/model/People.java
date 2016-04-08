package tobi.ye.mongodbDemo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

/**
 * Created by ye on 15-7-29.
 */
public class People {
    private String id;
    private String name;
    private Integer age;
    private Date time;
    @DBRef
    private List<Cloth> cloth;

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", time=" + time +
                ", cloth=" + cloth +
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<Cloth> getCloth() {
        return cloth;
    }

    public void setCloth(List<Cloth> cloth) {
        this.cloth = cloth;
    }
}

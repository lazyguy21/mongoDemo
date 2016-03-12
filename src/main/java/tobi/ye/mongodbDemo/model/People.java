package tobi.ye.mongodbDemo.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by ye on 15-7-29.
 */
public class People {
    private String name;
    private Integer age;
    private Date time;
    private List<Cloth> cloth;

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

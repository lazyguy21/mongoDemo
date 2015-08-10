package tobi.ye.mongodbDemo.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by ye on 15-7-29.
 */
@Data
public class People {
    private String name;
    private Integer age;
    private Date time;
}

package tobi.ye.mongodbDemo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by lazyguy on 2016-4-7.
 */
@Document
public class House {
    private String id;
    private String address;
    private String name;
    private Date addTime;

    private List<Furniture> furnitureList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }
}

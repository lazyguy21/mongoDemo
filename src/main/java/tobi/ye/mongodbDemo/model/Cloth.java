package tobi.ye.mongodbDemo.model;

import lombok.Data;

/**
 * Created by lazyguy on 2016-3-12.
 */
public class Cloth {
    private String id;
    private String name;
    private String label;
    private Double price;

    @Override
    public String toString() {
        return "Cloth{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", price=" + price +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cloth() {
    }

    public Cloth(String name, String label, Double price) {
        this.name = name;
        this.label = label;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

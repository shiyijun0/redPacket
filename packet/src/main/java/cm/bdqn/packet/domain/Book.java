package cm.bdqn.packet.domain;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private String id;
    private String name; // 书名
    private Integer price; // 价格
    private Date update; //

    public Book(String id, String name, Integer price, Date update) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.update = update;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }
}

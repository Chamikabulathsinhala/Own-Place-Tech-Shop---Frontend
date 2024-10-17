package dto;

import com.google.gson.annotations.Expose;
import entity.Product_Condition;
import entity.Product_Status;
import entity.User;

import java.io.Serializable;
import java.util.Date;

public class Product_DTO implements Serializable{

   @Expose
    private int id;
  
    @Expose
    private Product_Condition product_condition;

    @Expose
    private String title;
    
    @Expose
    private String description;
    
    @Expose
    private double price;
    
    @Expose
    private int qty;
   
    @Expose
    private Date date_time;
    
    @Expose(deserialize = true, serialize = false)
    private User user;
    
    @Expose
    private Product_Status product_Status;

    public Product_DTO () {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product_Condition getProduct_condition() {
        return product_condition;
    }

    public void setProduct_condition(Product_Condition product_condition) {
        this.product_condition = product_condition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product_Status getProduct_Status() {
        return product_Status;
    }

    public void setProduct_Status(Product_Status product_Status) {
        this.product_Status = product_Status;
    }
    
}

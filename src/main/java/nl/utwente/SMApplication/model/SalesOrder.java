package nl.utwente.SMApplication.model;

import java.util.Date;
import java.util.List;

public class SalesOrder {

    private int id;
    private String customer;
    private List<Product> productList;
    private Date dateCreated;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public SalesOrder(){}
    
    public SalesOrder(int id, String customer, List<Product> productList){
        this.id = id;
        this.customer = customer;
        this.productList = productList;
        this.dateCreated = new Date();
    }


    
}

package nl.utwente.SMApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private Integer productId;
    private String productName;
    private String productUnit;

    public Product(){}

    public Product(Integer productId, String productName, String productUnit) {
        this.productId = productId;
        this.productName = productName;
        this.productUnit = productUnit;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }
}

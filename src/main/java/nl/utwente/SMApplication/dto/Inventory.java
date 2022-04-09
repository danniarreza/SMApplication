package nl.utwente.SMApplication.dto;

import nl.utwente.SMApplication.model.Product;

public class Inventory {

    private Integer inventoryId;
    private int amount;
    private Product product;

    public Inventory() {
    }

    public Inventory(Integer inventoryId, int amount, Product product) {
        this.inventoryId = inventoryId;
        this.amount = amount;
        this.product = product;
    }


    public Integer getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
}

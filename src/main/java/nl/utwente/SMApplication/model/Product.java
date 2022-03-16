package nl.utwente.SMApplication.model;

public class Product {

    private int id;
    private String name;
    private int amount;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product(){}

    public Product(int id, String name, int amount){
        this.id = id;
        this.name = name;
        this.amount = amount;
    }


    
}

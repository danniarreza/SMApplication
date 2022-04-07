package nl.utwente.SMApplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goodsId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
    private int amount;

    public Goods(){}

    public Goods(int goodsId, Product product, int amount){
        this.goodsId = goodsId;
        this.product = product;
        this.amount = amount;
    }

    public int getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    
}

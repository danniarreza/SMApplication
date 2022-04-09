package nl.utwente.SMApplication.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class SalesOrder {

    @Id
    @JsonProperty("salesOrderId")
    private Integer orderId;
    private String orderStatus;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Client client;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Goods> goodsList;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date proposedDeliveryDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date confirmedDeliveryDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    public SalesOrder(){}

    public SalesOrder(Integer orderId, String orderStatus, Client client, List<Goods> goodsList, Date proposedDeliveryDate, Date creationDate) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.client = client;
        this.goodsList = goodsList;
        this.proposedDeliveryDate = proposedDeliveryDate;
        this.creationDate = creationDate;
    }

    public Date getConfirmedDeliveryDate() {
        return this.confirmedDeliveryDate;
    }

    public void setConfirmedDeliveryDate(Date confirmedDeliveryDate) {
        this.confirmedDeliveryDate = confirmedDeliveryDate;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getProposedDeliveryDate() {
        return proposedDeliveryDate;
    }

    public void setProposedDeliveryDate(Date proposedDeliveryDate) {
        this.proposedDeliveryDate = proposedDeliveryDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Goods> getGoodsList() {
        return this.goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

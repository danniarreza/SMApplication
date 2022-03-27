package nl.utwente.SMApplication.model;

import java.util.Date;
import java.util.List;

public class SalesOrder {

    private int orderId;
    private String orderStatus;
    private Client client;
    private List<Goods> goodsList;
    private Date proposedDeliveryDate;
    private Date confirmedDeliveryDate;
    private Date creationDate;

    public SalesOrder(){}

    public SalesOrder(int orderId, String orderStatus, Client client, List<Goods> goodsList, Date proposedDeliveryDate, Date creationDate) {
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


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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

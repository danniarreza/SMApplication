package nl.utwente.SMApplication.dto;

import java.util.Date;

public class TransportOrderUpdateDto {
    
    private int transportOrderId;
    private int salesOrderId;
    private Date pickupDate;
    private Date proposedDeliveryDate;
    private Date confirmedDeliveryDate;
    private String status;


    public TransportOrderUpdateDto() {
    }

    public TransportOrderUpdateDto(int transportOrderId, int salesOrderId, Date pickupDate, Date proposedDeliveryDate, Date confirmedDeliveryDate, String status) {
        this.transportOrderId = transportOrderId;
        this.salesOrderId = salesOrderId;
        this.pickupDate = pickupDate;
        this.proposedDeliveryDate = proposedDeliveryDate;
        this.confirmedDeliveryDate = confirmedDeliveryDate;
        this.status = status;
    }

    public int getTransportOrderId() {
        return this.transportOrderId;
    }

    public void setTransportOrderId(int transportOrderId) {
        this.transportOrderId = transportOrderId;
    }

    public int getSalesOrderId() {
        return this.salesOrderId;
    }

    public void setSalesOrderId(int salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Date getPickupDate() {
        return this.pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getProposedDeliveryDate() {
        return this.proposedDeliveryDate;
    }

    public void setProposedDeliveryDate(Date proposedDeliveryDate) {
        this.proposedDeliveryDate = proposedDeliveryDate;
    }

    public Date getConfirmedDeliveryDate() {
        return this.confirmedDeliveryDate;
    }

    public void setConfirmedDeliveryDate(Date confirmedDeliveryDate) {
        this.confirmedDeliveryDate = confirmedDeliveryDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}

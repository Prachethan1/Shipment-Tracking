package com.shipment.shipment.model;

public class Shipment {

    private String orderId;

    private String origin;

    private String destination;


    private ShipmentStatus status = ShipmentStatus.PENDING;


    public Shipment() {}


    public Shipment(String orderId, String origin, String destination) {
        this.orderId = orderId;
        this.origin = origin;
        this.destination = destination;
        this.status = ShipmentStatus.PENDING;
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }


    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }


    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }


    public ShipmentStatus getStatus() { return status; }
    public void setStatus(ShipmentStatus status) { this.status = status; }
}

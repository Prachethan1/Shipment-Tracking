package com.shipment.shipment.exception;

public class ShipmentNotFoundException extends RuntimeException {
    public ShipmentNotFoundException(String orderId) {
        super("Shipment not found: " + orderId);
    }
}

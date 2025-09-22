package com.shipment.shipment.model;

import java.util.EnumSet;

public enum ShipmentStatus {
    PENDING,
    DISPATCHED,
    IN_TRANSIT,
    DELIVERED;


    public boolean canTransitionTo(ShipmentStatus target) {
        if (this == target) return true; // idempotent
        switch (this) {
            case PENDING:
                return EnumSet.of(DISPATCHED, IN_TRANSIT, DELIVERED).contains(target);
            case DISPATCHED:
                return EnumSet.of(IN_TRANSIT, DELIVERED).contains(target);
            case IN_TRANSIT:
                return EnumSet.of(DELIVERED).contains(target);
            case DELIVERED:
                return false;
            default:
                return false;
        }
    }
}

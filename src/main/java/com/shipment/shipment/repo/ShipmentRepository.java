package com.shipment.shipment.repo;

import com.shipment.shipment.model.Shipment;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class ShipmentRepository {
    private final Map<String, Shipment> store = new ConcurrentHashMap<>();

    public Shipment save(Shipment shipment) {
        store.put(shipment.getOrderId(), shipment);
        return shipment;
    }

    public Optional<Shipment> findById(String orderId) {
        return Optional.ofNullable(store.get(orderId));
    }
}

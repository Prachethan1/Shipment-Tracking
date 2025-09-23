package com.shipment.shipment.repo;

import com.shipment.shipment.model.Shipment;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


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

    public List<Shipment> findByStatusAndOrigin(Optional<String> statusOpt, Optional<String> originOpt) {
        return store.values().stream()
                .filter(s -> statusOpt.map(st -> s.getStatus().name().equalsIgnoreCase(st)).orElse(true))
                .filter(s -> originOpt.map(o -> s.getOrigin().equalsIgnoreCase(o)).orElse(true))
                .collect(Collectors.toList());
    }
}

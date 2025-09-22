package com.shipment.shipment.service;

import com.shipment.shipment.model.Shipment;
import com.shipment.shipment.model.ShipmentStatus;
import com.shipment.shipment.repo.ShipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {
    private final ShipmentRepository repository;


    public ShipmentService(ShipmentRepository repository) {
        this.repository = repository;
    }


    public Shipment createShipment(Shipment shipment) {
        shipment.setStatus(ShipmentStatus.PENDING);
        return repository.save(shipment);
    }

    public Shipment getShipment(String orderId) {
        return repository.findById(orderId);
    }
}
package com.shipment.shipment.service;

import com.shipment.shipment.exception.InvalidStatusTransitionException;
import com.shipment.shipment.exception.ShipmentNotFoundException;
import com.shipment.shipment.model.Shipment;
import com.shipment.shipment.model.ShipmentStatus;
import com.shipment.shipment.repo.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        return repository.findById(orderId).orElseThrow(() -> new ShipmentNotFoundException(orderId));
    }

    public Shipment updateStatus(String orderId, ShipmentStatus newStatus) {
        Shipment existing = repository.findById(orderId).orElseThrow(() -> new ShipmentNotFoundException(orderId));
        ShipmentStatus current = existing.getStatus();
        if (!current.canTransitionTo(newStatus)) {
            throw new InvalidStatusTransitionException(current.name(), newStatus.name());
        }
        existing.setStatus(newStatus);
        repository.save(existing);
        return existing;
    }
}
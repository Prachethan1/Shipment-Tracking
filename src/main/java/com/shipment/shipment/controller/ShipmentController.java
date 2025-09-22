package com.shipment.shipment.controller;

import com.shipment.shipment.model.Shipment;
import com.shipment.shipment.service.ShipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    private final ShipmentService service;


    public ShipmentController(ShipmentService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Shipment> create(@RequestBody Shipment shipment) {
        Shipment created = service.createShipment(shipment);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Shipment> get(@PathVariable String orderId){
        return ResponseEntity.ok(service.getShipment(orderId));
    }
}

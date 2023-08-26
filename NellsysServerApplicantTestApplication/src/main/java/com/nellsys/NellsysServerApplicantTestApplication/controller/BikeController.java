package com.nellsys.NellsysServerApplicantTestApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nellsys.NellsysServerApplicantTestApplication.entity.Bike;
import com.nellsys.NellsysServerApplicantTestApplication.services.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    // Create a new bike
    @PostMapping
    public ResponseEntity<Bike> createBike(@RequestBody Bike bike) {
        Bike createdBike = bikeService.createBike(bike);
        if (createdBike != null) {
            return new ResponseEntity<>(createdBike, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
    }

    // Retrieve all bikes
    @GetMapping
    public ResponseEntity<List<Bike>> getAllBikes() {
        List<Bike> bikes = bikeService.getAllBikes();
        return new ResponseEntity<>(bikes, HttpStatus.OK);
    }

    // Retrieve a bike by id
    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBike(@PathVariable Long id) {
        Bike bike = bikeService.getBike(id);
        if (bike != null) {
            return new ResponseEntity<>(bike, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a bike
    @PutMapping("/{id}")
    public ResponseEntity<Bike> updateBike(@PathVariable Long id, @RequestBody Bike bike) {
        Bike updatedBike = bikeService.updateBike(id, bike);
        if (updatedBike != null) {
            return new ResponseEntity<>(updatedBike, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a bike
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBike(@PathVariable Long id) {
        boolean deleted = bikeService.deleteBike(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


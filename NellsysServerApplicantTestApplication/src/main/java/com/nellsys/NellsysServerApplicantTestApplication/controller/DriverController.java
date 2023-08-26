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

import com.nellsys.NellsysServerApplicantTestApplication.entity.Driver;
import com.nellsys.NellsysServerApplicantTestApplication.services.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;


    // Create a new Driver
    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        Driver createdDriver = driverService.createDriver(driver);
        if (createdDriver != null) {
            return new ResponseEntity<>(createdDriver, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    // Retrieve all Drivers
    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivrs = driverService.getAllDriver();
        return new ResponseEntity<>(drivrs, HttpStatus.OK);
    }

    // Retrieve a driver by id
    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable Long id) {
    	Driver driver = driverService.getDriver(id);
        if (driver != null) {
            return new ResponseEntity<>(driver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a driver
    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
    	Driver updatedDriver = driverService.updateDriver(id, driver);
        if (updatedDriver != null) {
            return new ResponseEntity<>(updatedDriver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a bike
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        boolean deleted = driverService.deleteDriver(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Select a bike for the driver
    @PostMapping("/driver/{driverId}/bike/{bikeId}")
    public ResponseEntity<Void> selectBike(@PathVariable Long driverId, @PathVariable Long bikeId) {
        boolean success = driverService.selectBike(driverId, bikeId);
        if (success) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deselect a bike for the driver
    @PostMapping("/deselect/{driverId}")
    public ResponseEntity<Void> deselectBike(@PathVariable Long driverId) {
        boolean success = driverService.deselectBike(driverId);
        if (success) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


package com.nellsys.NellsysServerApplicantTestApplication.services;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nellsys.NellsysServerApplicantTestApplication.entity.Bike;
import com.nellsys.NellsysServerApplicantTestApplication.entity.Driver;
import com.nellsys.NellsysServerApplicantTestApplication.repository.BikeRepository;
import com.nellsys.NellsysServerApplicantTestApplication.repository.DriverRepository;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private BikeRepository bikeRepository;

    
    public Driver createDriver(Driver driver) {
    	Driver driverSave = driverRepository.findByName(driver.getName());
    	if(driverSave ==null) {
    		driver.setTime(ZonedDateTime.now());
    		 return driverRepository.save(driver);
       }else
		return null;

    	
 }

    public List<Driver> getAllDriver() {
        return driverRepository.findAll();
    }

    public Driver getDriver(Long id) {
        return driverRepository.findById(id).orElse(null);
    }

    public Driver updateDriver(Long id, Driver dri) {
    	 Driver driver = driverRepository.findById(id).orElse(null);

        if (driver != null) {
        	driver.setName(dri.getName());
            return driverRepository.save(driver);
        }

        return null;
    }

    public boolean deleteDriver(Long id) {
        Driver driver = driverRepository.findById(id).orElse(null);

        if (driver != null) {
        	driverRepository.delete(driver);
            return true;
        }

        return false;
    } 
    
   
    public boolean selectBike(Long driverId, Long bikeId) {
        Driver driver = driverRepository.findById(driverId).orElse(null);
        Bike bike = bikeRepository.findById(bikeId).orElse(null);

        if (driver != null && bike != null) {

            driver.setSelectedBike(bike);
            driverRepository.save(driver);
            return true;
        }
        return false;
    }

    public boolean deselectBike(Long driverId) {
        Driver driver = driverRepository.findById(driverId).orElse(null);
        if (driver != null) {
            driver.setSelectedBike(null);
            driverRepository.save(driver);
            return true;
        }
        return false;
    }
    
      
    
}

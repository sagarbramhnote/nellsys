package com.nellsys.NellsysServerApplicantTestApplication.services;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nellsys.NellsysServerApplicantTestApplication.entity.Bike;
import com.nellsys.NellsysServerApplicantTestApplication.repository.BikeRepository;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;


    public Bike createBike(Bike bike) {
    	Bike bikeSave = bikeRepository.findByLicensePlate(bike.getLicensePlate());
    	if(bikeSave ==null) {
    	bike.setTime(ZonedDateTime.now());
        return bikeRepository.save(bike);
        
       }else
		return null;
    }

    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    public Bike getBike(Long id) {
        return bikeRepository.findById(id).orElse(null);
    }

    public Bike updateBike(Long id, Bike bi) {
    	 Bike bike = bikeRepository.findById(id).orElse(null);

        if (bike != null) {
        	bike.setLicensePlate(bi.getLicensePlate());
            bike.setConvertible(bi.isConvertible());
            bike.setRating(bi.getRating());
            bike.setEngineType(bi.getEngineType());
            bike.setManufacturer(bi.getManufacturer());


            return bikeRepository.save(bike);
        }

        return null;
    }

    public boolean deleteBike(Long id) {
        Bike bike = bikeRepository.findById(id).orElse(null);

        if (bike != null) {
            bikeRepository.delete(bike);
            return true;
        }

        return false;
    }
}


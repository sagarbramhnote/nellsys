package com.nellsys.NellsysServerApplicantTestApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nellsys.NellsysServerApplicantTestApplication.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{

	Bike findByLicensePlate(String licensePlate);
}

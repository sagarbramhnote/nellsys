package com.nellsys.NellsysServerApplicantTestApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nellsys.NellsysServerApplicantTestApplication.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{

	Driver findByName(String name);
	
}

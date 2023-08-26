package com.nellsys.NellsysServerApplicantTestApplication.entity;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    
    private ZonedDateTime time;


    @JsonIgnore
    @ManyToOne(targetEntity=Bike.class)
    @JoinColumn(name = "selected_bike_id")
    private Bike selectedBike;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bike getSelectedBike() {
		return selectedBike;
	}

	public void setSelectedBike(Bike selectedBike) {
		this.selectedBike = selectedBike;
	}

	public ZonedDateTime getTime() {
		return time;
	}

	public void setTime(ZonedDateTime time) {
		this.time = time;
	}  
    
}
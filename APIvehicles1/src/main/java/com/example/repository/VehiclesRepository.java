package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Vehicle;

public interface VehiclesRepository extends JpaRepository<Vehicle,Long> {

	public default <S> void save(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}

}

package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
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

import com.example.model.Vehicle;
import com.example.repository.VehiclesRepository;

@RestController
@RequestMapping("/api")
public class Vehiclescontroller {

	@Autowired
	VehiclesRepository vehiclesRepository;
	
	@PostMapping("/vehicles")
	public String createNewVehicle(@RequestBody Vehicle vehicle) {
		vehiclesRepository.save(vehicle);
		return"Vehicle Created In database";
	}
	
	@GetMapping("/vehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles(){
		
		List<Vehicle> empList = new ArrayList<>();
		vehiclesRepository.findAll().forEach(empList::add);
		return new ResponseEntity<List<Vehicle>>(empList,HttpStatus.OK);
	}
		
	@PutMapping("/vehicles/{v_id}")
	public String updateVehicleById(@PathVariable long v_id,@RequestBody Vehicle vehicles){
		Optional<Vehicle> v =vehiclesRepository.findById(v_id);
		if(v.isPresent()) {
			Vehicle existv =v.get();
			existv.setV_model(vehicles.getV_model());
			existv.setV_mileage(vehicles.getV_mileage());
			existv.setV_price(vehicles.getV_price());
			existv.setV_name(vehicles.getV_name());
		vehiclesRepository.save(existv);
		return "vehicles Details against Id "+ v_id +"updated";
		}else {
			return "vehicles Details does not exist for v_Id "+ v_id;
		}
	}
	@DeleteMapping("/vehicles/{v_id}")
	public String deleteVehicleByv_id(@PathVariable Long v_id) {
		vehiclesRepository.deleteById(v_id);
		return"Vehicles Deleted Successfully";
}
	@DeleteMapping("/vehicles/{v_id}")
	public String deleteVehicle() {
		vehiclesRepository.deleteAll();
		return"Vehicles Deleted Successfully";
}
}

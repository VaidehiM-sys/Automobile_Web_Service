package com.mitchell.automobileservice.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.mitchell.automobileservice.dto.VehicleDTO;
import com.mitchell.automobileservice.model.Vehicle;
import com.mitchell.automobileservice.service.IVehicleService;

@RestController
@RequestMapping("/automobile")
public class ServiceController {

	@Autowired
	private IVehicleService vehicleService;

	@GetMapping("/vehicles/{vehicleId}")
	public Vehicle getVehicleById(@PathVariable Integer vehicleId) {
		return vehicleService.getVehicleById(vehicleId);
	}

	//To get the list of vehicles specified with certain parameters
	@GetMapping("/vehicles")
	public List<Vehicle> getVehicleByProperty(VehicleDTO vehicle)
			throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException {
		if (null == vehicle) {
			return vehicleService.getAllVehicles();
		}
		//Used reflection to get the fields of VechicleDTO
		Field[] arrFields = VehicleDTO.class.getDeclaredFields();
		
		//BeanWrapper used to get and set property values, get property descriptors, and query the readability of properties
		BeanWrapper _wrapper = new BeanWrapperImpl(vehicle);
		Map<String, Object> filterParameters = new HashMap<>();
		//Adding the property and their values to be used to filter the Vehicle list
		for (Field field : arrFields) {
			String name = field.getName();
			Object _value = _wrapper.getPropertyValue(name);
			if (_value != null) {
				filterParameters.put(name, _value);
			}
		}
		return vehicleService.getVehiclesByProperty(filterParameters);
	}
	
	@PostMapping("/vehicles/")
	public ResponseEntity<Void> createVehicle(@RequestBody Vehicle newVehicle, UriComponentsBuilder builder) {
		Vehicle vehicle = vehicleService.createVehicle(newVehicle);
		if (vehicle == null) {
			return ResponseEntity.noContent().build();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/vehicle/{id}").buildAndExpand(vehicle.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@Valid @RequestBody Vehicle updateVehicle) {
		Vehicle vehicle = vehicleService.getVehicleById(updateVehicle.getId());
		if (null == vehicle) {
			return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
		}
		//Updating the values
		vehicle.setMake(updateVehicle.getMake());
		vehicle.setModel(updateVehicle.getModel());
		vehicle.setYear(updateVehicle.getYear());
		vehicleService.updateVehicle(vehicle);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}
	
	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> deleteVehicle(@Valid @PathVariable int id) {
		Vehicle vehicle = vehicleService.getVehicleById(id);
		if (null == vehicle) {
			return new ResponseEntity<Vehicle>(HttpStatus.FOUND);
		}
		vehicleService.deleteVehicle(id);
		return new ResponseEntity<Vehicle>(HttpStatus.NO_CONTENT);
	}
}

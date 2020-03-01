package com.mitchell.automobileservice.service;

import java.util.*;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import com.mitchell.automobileservice.model.Vehicle;

@Service
public class VehicleServiceImplementation implements IVehicleService {
	//Map to keep track of Vehicles
	private static Map<Integer, Vehicle> vehicles;

	public VehicleServiceImplementation() {
		vehicles = new HashMap<Integer, Vehicle>();
		Vehicle vehicle1 = new Vehicle(1, 2019, "Audi", "A3");
		Vehicle vehicle2 = new Vehicle(2, 2019, "Audi", "A3");
		Vehicle vehicle3 = new Vehicle(3, 2020, "Audi", "R8");
		Vehicle vehicle4 = new Vehicle(4, 2018, "Tesla", "Model S");
		Vehicle vehicle5 = new Vehicle(5, 2018, "Tesla", "Model X");
		Vehicle vehicle6 = new Vehicle(6, 1998, "Lamborghini", "Aventador SVJ");
		Vehicle vehicle7 = new Vehicle(7, 2022, "Lamborghini", "Huracan");
		Vehicle vehicle8 = new Vehicle(8, 2023, "BMW", "X5");
		Vehicle vehicle9 = new Vehicle(9, 2024, "BMW", "i8");
		Vehicle vehicle10 = new Vehicle(10, 2025, "Mercedes", "Benz");
		vehicles.put(vehicle1.getId(), vehicle1);
		vehicles.put(vehicle2.getId(), vehicle2);
		vehicles.put(vehicle3.getId(), vehicle3);
		vehicles.put(vehicle4.getId(), vehicle4);
		vehicles.put(vehicle5.getId(), vehicle5);
		vehicles.put(vehicle6.getId(), vehicle6);
		vehicles.put(vehicle7.getId(), vehicle7);
		vehicles.put(vehicle8.getId(), vehicle8);
		vehicles.put(vehicle9.getId(), vehicle9);
		vehicles.put(vehicle10.getId(), vehicle10);
	}
	
	@Override
	public List<Vehicle> getAllVehicles() {
		return new ArrayList<Vehicle>(vehicles.values());
	}

	@Override
	public Vehicle getVehicleById(int id) {
		if (vehicles.containsKey(id))
			return vehicles.get(id);
		return null;
	}

	@Override
	public List<Vehicle> getVehiclesByProperty(Map<String, Object> filterParameters) {		
		List<Vehicle> selectedVehicles = new ArrayList<Vehicle>(vehicles.values());
		//If no parameters are passed returns all the vehicles
		if (filterParameters.size() == 0) {
			return selectedVehicles;
		}
		for (Map.Entry<String, Object> entry : filterParameters.entrySet()) {
			int index = 0;
			int size = selectedVehicles.size();
			do {
				//BeanWrapper used to get and set property values, get property descriptors, and query the readability of properties
				BeanWrapper _wrapper = new BeanWrapperImpl(selectedVehicles.get(index));
				//Checks the property
				if (!entry.getValue().equals(_wrapper.getPropertyValue(entry.getKey()))) {
					selectedVehicles.remove(index);
					size--;
				} else {
					index++;
				}
			} while (index < size);
		}
		return selectedVehicles;
	}

	@Override
	public Vehicle createVehicle(Vehicle newVehicle) {
		Vehicle vehicle = new Vehicle();
		if (!vehicles.containsKey(newVehicle.getId())) {
			Random randomNumber = new Random();
			int nextId = randomNumber.nextInt(10) + 10;
			vehicle.setId(nextId);
			vehicle.setMake(newVehicle.getMake());
			vehicle.setModel(newVehicle.getModel());
			vehicle.setYear(Integer.valueOf(newVehicle.getYear()));
			vehicles.put(vehicle.getId(), vehicle);
			return vehicle;
		}
		return null;
	}
	
	@Override
	public void updateVehicle(Vehicle updateVehicle) {
		Vehicle oldVehicle = getVehicleById(updateVehicle.getId());
		if (oldVehicle != null) {
			oldVehicle.setMake(updateVehicle.getMake());
			oldVehicle.setModel(updateVehicle.getModel());
			oldVehicle.setYear(updateVehicle.getYear());
		}
	}

	@Override
	public void deleteVehicle(int id) {
		if (vehicles.containsKey(id)) {
			vehicles.remove(id);
		}
	}
}

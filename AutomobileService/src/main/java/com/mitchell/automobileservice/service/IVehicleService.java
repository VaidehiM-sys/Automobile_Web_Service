package com.mitchell.automobileservice.service;
import java.util.*;
import com.mitchell.automobileservice.model.Vehicle;

public interface IVehicleService {
	public List<Vehicle> getAllVehicles();
	public Vehicle getVehicleById(int id);
	//To get the Vehicle by different parameter filters
	public List<Vehicle> getVehiclesByProperty(Map<String, Object> filterParameters);	
	public Vehicle createVehicle(Vehicle vehicle);
	public void updateVehicle(Vehicle vehicle);
	public void deleteVehicle(int id);		
}

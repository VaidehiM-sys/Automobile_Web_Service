package com.test.restassuredautomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteVehicleTest {
	@Test
	void deleteVehicle() {
		//Specify the base URI
		RestAssured.baseURI = "http://localhost:8080/automobile/vehicles/5";
		//Request object 
		RequestSpecification httpRequest = RestAssured.given();
		//Response object
		Response response = httpRequest.delete(RestAssured.baseURI);
		
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is : " +  responseBody);
				
		//Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is : "+ statusCode);
		Assert.assertEquals(statusCode, 204);
	}	
}

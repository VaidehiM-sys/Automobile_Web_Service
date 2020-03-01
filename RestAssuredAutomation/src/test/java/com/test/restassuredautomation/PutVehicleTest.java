package com.test.restassuredautomation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutVehicleTest {
	@Test
	void updateVehicle() {
		//Specify the base URI
		RestAssured.baseURI = "http://localhost:8080/automobile/vehicles/1";
		//Request object 
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type","application/json");
		
		//Request parameters to be sent along with the put request
		JSONObject requestParams = new JSONObject();
		requestParams.put("year","2020");
		requestParams.put("make","Tesla");
		requestParams.put("model","Model Z");
		
		httpRequest.body(requestParams.toJSONString());
		
		//Response object
		Response response = httpRequest.delete(RestAssured.baseURI);
			
		//Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is : "+ statusCode);
		Assert.assertEquals(statusCode, 201);
		
		}
}

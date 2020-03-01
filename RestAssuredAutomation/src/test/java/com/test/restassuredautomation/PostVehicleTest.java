package com.test.restassuredautomation;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostVehicleTest {
	@Test
	void postVehicle() {
		//Specify the base URI
		RestAssured.baseURI = "http://localhost:8080/automobile/vehicles/";
		
		//Request object 
		RequestSpecification httpRequest = RestAssured.given();
				
		//Request parameters to be sent along with the post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("year","2024");
		requestParams.put("make","Tesla");
		requestParams.put("model","Model Z");
		
		httpRequest.body(requestParams.toJSONString());
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		//Response Object
		Response response = httpRequest.request(Method.POST);
		
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is : " +  responseBody);
		
		//Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is : "+ statusCode);
		Assert.assertEquals(statusCode, 201);
	}
}

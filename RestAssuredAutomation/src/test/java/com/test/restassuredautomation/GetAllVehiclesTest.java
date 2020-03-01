package com.test.restassuredautomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllVehiclesTest{
	@Test
	void getVehicles() {
		//Specify the base URI
		RestAssured.baseURI = "http://localhost:8080/automobile/vehicles/";
		//Request object 
		RequestSpecification httpRequest = RestAssured.given();
		//Response object
		Response response = httpRequest.request(Method.GET);
		
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is : " +  responseBody);
		
		//Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is : "+ statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status Line Verification
		String statusLine = response.getStatusLine();
		System.out.println("Status Line is : "+ statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 ");
	}
}

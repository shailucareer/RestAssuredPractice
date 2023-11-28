package org.api;

import static io.restassured.RestAssured.when;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetDemo_ReqRes {

	@Test
	private void getRequestTest_Minimal() {
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured		
		.get("/api/users?page=2")
		.then()
		.log().body();
	}
	
	@Test
	private void getRequestTest_FullFledged() {
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured
		.given()
		.when()
		.get("/api/users?page=2")
		.then()
		.statusCode(200).log().body();
	}	
	
	@Test
	private void getRequestTest_FetchingIndividualJsonElement() {
		
		ArrayList<Integer> ids = 
				when()
				.get("https://reqres.in/api/users?page=2")
				.then()
				.extract()
				.path("data.id") ;
		
		int sumOfAll=0;
		for(Integer id:ids){

		    System.out.println("The amount value fetched is "+id);
		    sumOfAll=sumOfAll+id;
		}
		System.out.println("The total amount is "+sumOfAll);
		
	}
	
	
}

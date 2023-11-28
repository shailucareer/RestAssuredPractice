package org.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostDemo {

	@Test
	private void getRequestTest() {
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured
		.given()
		.when()
		.get("/api/users?page=2")
		.then()
		.statusCode(200);
	}
	
}

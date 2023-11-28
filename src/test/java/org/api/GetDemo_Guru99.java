package org.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.xml.XmlPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class GetDemo_Guru99 {

	@Test
	private void getRequestTest_QueryParamCombined() {
		 given()
		 .when()
		 .get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
		 .then()
		 .log().body();
	}

	@Test
	private void getRequestTest_QueryParamSeparate() {
		RestAssured.baseURI = "http://demo.guru99.com";
		 given()
		 .queryParam("CUSTOMER_ID","68195")
         .queryParam("PASSWORD","1234!")
         .queryParam("Account_No","1")
         .when()
         .get("V4/sinkministatement.php")
         .then().log().body(true);
	}
	
	@Test
	private void getRequestTest_ResponseCode() {
		RestAssured.baseURI = "http://demo.guru99.com";
		int statusCode= 
				given()
				.queryParam("CUSTOMER_ID","68195")
				.queryParam("PASSWORD","1234!")
				.queryParam("Account_No","1") 
				.when()
				.get("V4/sinkministatement.php")
				.getStatusCode();
		
		   System.out.println("The response status is "+statusCode);

		   given()
			.queryParam("CUSTOMER_ID","68195")
			.queryParam("PASSWORD","1234!")
			.queryParam("Account_No","1") 
			.when()
			.get("V4/sinkministatement.php")
			.then()
			.assertThat()
			.statusCode(200);
	}
	
	@Test
	private void getRequestTest_ResponseCode_InvalidPathURI() {
		RestAssured.baseURI = "http://demo.guru99.com";
		int statusCode= 
				given()
				.queryParam("CUSTOMER_ID","68195")
				.queryParam("PASSWORD","1234!")
				.queryParam("Account_No","1") 
				.when()
				.get("V4/sinkministatement1.php")
				.getStatusCode();
		
		   System.out.println("The response status is "+statusCode);
	}	
	
	@Test
	private void getRequestTest_FetchingHeaders() {
		RestAssured.baseURI = "http://demo.guru99.com";
		Headers headers = given()
		.queryParam("CUSTOMER_ID","68195")
		.queryParam("PASSWORD","1234!")
		.queryParam("Account_No","1") 
		.when()
		.get("V4/sinkministatement1.php")
		.headers();

		System.out.println();
		System.out.println();
		System.out.println("The response headers are "+headers);
		

		System.out.println();
		System.out.println();
		System.out.println("The response header verification");
		
		given()
		.queryParam("CUSTOMER_ID","68195")
		.queryParam("PASSWORD","1234!")
		.queryParam("Account_No","1") 
		.when()
		.get("V4/sinkministatement1.php")
		.then()
		.assertThat()
		.header("Content-Type", "text/html; charset=iso-8859-1");
		
	}
	
	@Test
	private void getRequestTest_FetchingIndividualJsonElement() {
		
		ArrayList<String> amounts = when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").then().extract().path("result.statements.AMOUNT") ;
		int sumOfAll=0;
		for(String a:amounts){

		    System.out.println("The amount value fetched is "+a);
		    sumOfAll=sumOfAll+Integer.valueOf(a);
		}
		System.out.println("The total amount is "+sumOfAll);
		System.out.println("Just making some changes to push in git");
		System.out.println("Just making some changes to push in git");

	}
	
	
	
}

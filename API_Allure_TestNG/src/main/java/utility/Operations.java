package utility;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;

import environmentConstant.EndPoint;
import environmentConstant.HeadersPros;
import environmentConstant.Props;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pageObject.GamesRequest;
import pojoClasses.GamesValues;
import static org.hamcrest.Matchers.*;

public class Operations {
	private Response myResponse = null;
	private RequestSpecification requestSpecification = null;
	private HeadersPros headersPros = new HeadersPros();

	public Response get(String endpoint) {

		try {
			RestAssured.baseURI = EndPoint.BaseURL;
			myResponse = RestAssured.given().headers(headersPros.headers).get(endpoint);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myResponse;
	}

	public Response post(String endpoint, Object json) {

		try {
			RestAssured.baseURI = EndPoint.BaseURL;
			myResponse = RestAssured.given().headers(headersPros.headers).body(json).post(endpoint);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return myResponse;
	}

	public Response put(String endpoint, GamesValues updatingGames) {

		try {
			System.out.println("endpoint is :- " + endpoint);
			RestAssured.baseURI = EndPoint.BaseURL;

			myResponse = RestAssured.given().headers(headersPros.headers).body(updatingGames).put(endpoint);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return myResponse;
	}

	public Response delete(String endpoint) {

		try {
			RestAssured.baseURI = EndPoint.BaseURL;
			requestSpecification = RestAssured.given();
			myResponse = requestSpecification.request(Method.DELETE, endpoint);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return myResponse;
	}

}

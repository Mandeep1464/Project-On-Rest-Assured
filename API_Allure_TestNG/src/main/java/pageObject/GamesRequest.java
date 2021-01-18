package pageObject;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;

import com.google.gson.Gson;

import RestResponse.RestResponse;
import environmentConstant.EndPoint;
import environmentConstant.Props;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojoClasses.PojoToJsonFormate;
import pojoClasses.GamesValues;
import utility.GetRecords;
import utility.Operations;

public class GamesRequest {

	public void postData(int TCID) {
		PojoToJsonFormate jsonFormate = new PojoToJsonFormate();
		Operations allRequest = new Operations();

		// Post pojo object
		GamesValues updateGamesPojo = jsonFormate.dataInPojo(TCID);

		// Posting data to server
		Response postResponse = allRequest.post(EndPoint.addGame, updateGamesPojo);
		int gameid = updateGamesPojo.getId();

		// Getting data from server
		Response getResponse = allRequest.get(EndPoint.gameFindByID(gameid));
		RestResponse<GamesValues> restResponse = new RestResponse<GamesValues>(GamesValues.class, getResponse);
		// Get pojo object
		GamesValues getGamePojo = restResponse.getBody();

		System.out.println("PostRes : " + updateGamesPojo);
		System.out.println("Get : " + getGamePojo);
		System.out.println("Get_actuall : " + getResponse.body().asPrettyString());

		String ExpectedPojo = new Gson().toJson(updateGamesPojo);
		Allure.addAttachment("Expected Result :- ", ExpectedPojo);
		Allure.addAttachment("Actual Result :- ", getGamePojo.toString());

		// Matching data using Pojo classes
		Assert.assertTrue(getGamePojo.equals(updateGamesPojo), "Data not Uploaded into server");
	}

	public void putData(String gameID, int TCID) {
		System.out.println(gameID + "\t" + TCID);
		PojoToJsonFormate jsonFormate = new PojoToJsonFormate();
		Operations allRequest = new Operations();

		// Post pojo object
		GamesValues updateGamesPojo = jsonFormate.dataInPojo(TCID);
		allRequest.put(EndPoint.uploadGame(gameID), jsonFormate.dataInPojo(TCID));

		// Posting data to server
		Response postResponse = allRequest.put(EndPoint.uploadGame(gameID), updateGamesPojo);
		int gameid = updateGamesPojo.getId();
		System.out.println(postResponse);
		System.out.println(postResponse.getStatusCode());
		// Getting data from server
		Response getResponse = allRequest.get(EndPoint.gameFindByID(gameid));
		RestResponse<GamesValues> restResponse = new RestResponse<GamesValues>(GamesValues.class, getResponse);
		// Get pojo object
		GamesValues getGamePojo = restResponse.getBody();

		System.out.println("PutResponse : " + updateGamesPojo);
		System.out.println("GetResponse : " + getGamePojo);

		System.out.println("Get_actual : " + getResponse.body().asPrettyString());

		String ExpectedPojo = new Gson().toJson(updateGamesPojo);
		Allure.addAttachment("Expected Result :- ", ExpectedPojo);
		Allure.addAttachment("Actual Result :- ", getGamePojo.toString());

		// Matching data using Pojo classes
		// Assert.assertTrue(getGamePojo.equals(updateGamesPojo), "Data not Uploaded
		// into server");

	}

	public void getData(int i) {

		Operations allRequest = new Operations();
		Response response = allRequest.get(EndPoint.gameFindByID(i));
		response.getBody().prettyPrint();
	}

	public void deleteData(int GameID) {

		Operations allRequest = new Operations();
		allRequest.delete(EndPoint.gameDelete(GameID));
	}

	public String gettingGameID(int TCID) {
		GetRecords getRecords = new GetRecords();
		ArrayList<HashMap<String, String>> data = getRecords.read(Props.TestData);

		HashMap<String, String> testdata = data.get(TCID);
		return testdata.get("id");

	}

}

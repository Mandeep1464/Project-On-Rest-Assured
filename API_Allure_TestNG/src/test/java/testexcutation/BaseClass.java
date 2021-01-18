package testexcutation;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import environmentConstant.EndPoint;
import environmentConstant.Props;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.GamesRequest;
import utility.GetRecords;
import utility.Operations;

public class BaseClass {

	GamesRequest games = new GamesRequest();

	@Epic("EP001")
	@Feature("Feature: PostData")
	@Severity(SeverityLevel.BLOCKER)
	@Description("The priority of the test annotation is Four")
	@Test(priority = 0, description = "the Game is added")
	public void the_game_is_added() {
		games.postData(0);
	}

	@Epic("EP002")
	@Feature("Feature: GetData")
	@Severity(SeverityLevel.NORMAL)
	@Description("The priority of the test annotation is One")
	@Test(priority = 1, description = "Finding the Game using GameID")
	public void finding_the_game_using_game_id() {
		System.out.println("The priority of the test annotation is One");
		games.getData((int) Float.parseFloat(games.gettingGameID(0))); // Enter the GameId to find the respective Game
	}

	@Epic("EP003")
	@Feature("Feature: PutData")
	@Description("The priority of the test annotation is Two")
	@Test(priority = 2, description = "Update the Game")
	public void update_the_game() {
		games.putData(games.gettingGameID(0), 1);
	}

	@Epic("EP004")
	@Feature("Feature: GetData")
	@Severity(SeverityLevel.NORMAL)
	@Description("The priority of the test annotation is Three")
	@Test(priority = 3, description = "Finding the Game using GameID")
	public void finding_the_game_using_gameId_After_Update() {
		System.out.println("The priority of the test annotation is Three");
		games.getData((int) Float.parseFloat(games.gettingGameID(0))); // Enter the GameId to find the respective Game
																		// After Update
	}

	@Epic("EP005")
	@Feature("Feature: DeleteData")
	@Description("The priority of the test annotation is Three")
	@Test(priority = 4, description = "the book is removed")
	public void the_book_is_removed() {
		games.deleteData((int) Float.parseFloat(games.gettingGameID(0))); // Enter the GameId to Remove the respective
																			// Game
	}
}

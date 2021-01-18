package environmentConstant;


public class EndPoint {
	// BaseURL
	public final static String BaseURL = "http://localhost:8080";
	
	public static String addGame = "/app/videogames";
	public static String allGames = "/app/videogames";
	
	public static String allGames() {
		return "/app/videogames";
	}

	public static String uploadGame(String gameID) {
		return "/app/videogames/" + gameID;
	}
	
	public static String gameFindByID(int gameID) {
		return "/app/videogames/" + gameID;
	}

	public static String gameDelete(int gameID) {
		return "/app/videogames/" + gameID;
	}

}

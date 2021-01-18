package pojoClasses;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import environmentConstant.Props;
import utility.GetRecords;

public class PojoToJsonFormate {

	public GamesValues dataInPojo(int TCID) {

		GetRecords getRecords = new GetRecords();
		ArrayList<HashMap<String, String>> data = getRecords.read(Props.TestData);

		HashMap<String, String> testdata = data.get(TCID);
		GamesValues params = new GamesValues((int) Float.parseFloat(testdata.get("id")), testdata.get("name"),
				testdata.get("releaseDate"), (int) Float.parseFloat(testdata.get("reviewScore")),
				testdata.get("category"), testdata.get("rating"));
		
		
		
		return params;

	}

}

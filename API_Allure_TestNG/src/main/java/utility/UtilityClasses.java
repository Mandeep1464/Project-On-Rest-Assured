package utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import environmentConstant.Props;

public class UtilityClasses {
	private Props props = new Props();

	public void setProps(Properties prop, String filepath) {
		try {
			FileInputStream stream = readProps(filepath);
			prop.load(stream);
		} catch (Exception e) {
			System.out.println("Exception in : setProperties()");
			e.printStackTrace();
		}
	}

	public FileInputStream readProps(String filepath) {
		try {
			return new FileInputStream(filepath);
		} catch (Exception e) {
			System.out.println("Exception in : readProperties()");
			e.printStackTrace();
		}
		return null;
	}

	public HashMap<String, String> getTestData(int rownumber) {
		GetRecords getRecords = new GetRecords();
		ArrayList<HashMap<String, String>> data = getRecords.read(props.TestData); // ReadLogin excel data
		HashMap<String, String> firstRow = data.get(rownumber); // get first Row from ArrayList as HashMap
		return firstRow;// return first Row
	}

}

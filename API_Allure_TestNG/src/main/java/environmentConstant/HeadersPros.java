package environmentConstant;

import java.util.HashMap;

public class HeadersPros {

	public static HashMap<String, String> headers = new HashMap<String, String>();
	static {
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		headers.put("Accept-Encoding", "gzip, deflate, br");
		headers.put("Accept-Language", "en-US,en;q=0.9");
	}

}

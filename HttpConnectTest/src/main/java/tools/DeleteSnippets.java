package tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteSnippets {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void deleteSnippets() throws Exception {

		DeleteSnippets http = new DeleteSnippets();

		int i;

		for (i = 0; i < Constants.snippetsNr; i++) {
			http.delete(0);
		}

	}

	// HTTP GET request
	private void delete(int index) throws Exception {

		String url = "http://google-gruyere.appspot.com/974152596312/deletesnippet?index=" + index;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

}

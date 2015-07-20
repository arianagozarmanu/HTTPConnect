package tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class CreateSnippets {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void createSnippets() throws Exception {

		CreateSnippets http = new CreateSnippets();
		
		int i,nr;
		Random rnd=new Random();
		for(i=0;i<Constants.snippetsNr;i++){
			nr=rnd.nextInt(1000);
			http.create(Integer.toString(nr));
		}

	}

	// HTTP GET request
	private void create(String name) throws Exception {

		String url = "http://google-gruyere.appspot.com/974152596312/newsnippet2?snippet=" + name;

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

	/*
	 * // HTTP POST request private void sendPost() throws Exception {
	 * 
	 * String urlParameters = "uid=cheddar"; URL url = new
	 * URL("http://google-gruyere.appspot.com/216846574386/"); URLConnection
	 * conn = url.openConnection();
	 * 
	 * conn.setDoOutput(true);
	 * 
	 * OutputStreamWriter writer = new
	 * OutputStreamWriter(conn.getOutputStream());
	 * 
	 * writer.write(urlParameters); writer.flush();
	 * 
	 * String line; BufferedReader reader = new BufferedReader(new
	 * InputStreamReader(conn.getInputStream()));
	 * 
	 * while ((line = reader.readLine()) != null) { System.out.println(line); }
	 * writer.close(); reader.close();
	 * 
	 * }
	 */

}

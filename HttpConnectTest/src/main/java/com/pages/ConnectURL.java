package com.pages;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ConnectURL {
	/*
	 * public static void main(String[] args) throws Exception { URL yahoo = new
	 * URL("http://www.oracle.com/"); URLConnection yc = yahoo.openConnection();
	 * BufferedReader in = new BufferedReader(new
	 * InputStreamReader(yc.getInputStream())); String inputLine;
	 * 
	 * while ((inputLine = in.readLine()) != null)
	 * System.out.println(inputLine); in.close(); }
	 */
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		ConnectURL http = new ConnectURL();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendLogGet();
		http.create("ana");
		http.create("mkaria");
		http.create("ioana");

		//System.out.println("\nTesting 2 - Send Http POST request");
		//http.sendPost();

	}

	// HTTP GET request
	private void sendLogGet() throws Exception {

		String url = "http://google-gruyere.appspot.com/974152596312/login?uid=aaa&pw=aaa";

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
	// HTTP POST request
	private void sendPost() throws Exception {

		String urlParameters = "uid=cheddar";
		URL url = new URL("http://google-gruyere.appspot.com/216846574386/");
		URLConnection conn = url.openConnection();

		conn.setDoOutput(true);

		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

		writer.write(urlParameters);
		writer.flush();

		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		writer.close();
		reader.close();

	}
	*/
	
	// HTTP GET request
		private void create(String name) throws Exception {

			String url = "http://google-gruyere.appspot.com/974152596312/newsnippet2?snippet=ana";
			

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

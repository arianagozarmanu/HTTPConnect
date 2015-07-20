package tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login {

	public static void cookie(String urlString) {
		try {
			CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream in = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			int status = conn.getResponseCode();
			System.out.println("Status = " + status);
			String key;
			System.out.println("Headers-------start-----");
			for (int i = 1; (key = conn.getHeaderFieldKey(i)) != null; i++) {
				System.out.println(key + ":" + conn.getHeaderField(i));
			}
			System.out.println("Headers-------end-----");
			System.out.println("Content-------start-----");
			String inputLine;
			while ((inputLine = reader.readLine()) != null) {
				System.out.println(inputLine);
			}
			System.out.println("Content-------end-----");
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void login(String url) {
		cookie(url);
	}

}

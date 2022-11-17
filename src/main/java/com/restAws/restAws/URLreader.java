package com.restAws.restAws;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//Reads simple data from a given URL
public abstract class URLreader {

	public static String readStringFromURL(String requestURL) throws IOException {
		try (Scanner scanner = new Scanner(new URL(requestURL).openStream(), StandardCharsets.UTF_8.toString())) {
			scanner.useDelimiter("\\A");
			return scanner.hasNext() ? scanner.next() : "";
		}
	}

	public static JSONObject readJSonFromURL(String requestURL) throws IOException {
		String urlString = readStringFromURL(requestURL);
		JSONObject object = new JSONObject();
		JSONParser parser = new JSONParser();
		try {
			object = (JSONObject) parser.parse(urlString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return object;
	}
}

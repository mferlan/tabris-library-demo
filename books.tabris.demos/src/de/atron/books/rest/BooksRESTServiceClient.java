package de.atron.books.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class BooksRESTServiceClient {
	public static void main(String[] args) {
		try {

			try {
				final URL url = new URL("http://localhost:8080/BooksRestService/api/books");
				final URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				// final OutputStreamWriter out = new
				// OutputStreamWriter(connection.getOutputStream());
				// out.write(jsonObject.toString());
				// out.close();

				final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				final StringBuffer buffer = new StringBuffer();
				String readLine = in.readLine();
				while (readLine != null) {
					buffer.append(readLine);
					readLine = in.readLine();
				}
				System.out.println(buffer);
				final JSONObject jsonObject = new JSONObject(buffer.toString());
				final JSONArray jsonArray = jsonObject.getJSONArray("book");
				for (int i = 0; i < jsonArray.length(); i++) {
					final JSONObject js = jsonArray.getJSONObject(i);
//					final Book book = new Book();
//					book.setAuthor(js.getString("author"));
//					book.setName(js.getString("name"));
//					book.setISBN(js.getString("ISBN"));
//					System.out.println(book);
				}

				System.out.println("\nCrunchify REST Service Invoked Successfully..");
				in.close();
			} catch (final Exception e) {
				System.out.println("\nError while calling Crunchify REST Service");
				System.out.println(e);
			}

			// br.close();
		} catch (

		final Exception e) {
			e.printStackTrace();
		}
	}
}
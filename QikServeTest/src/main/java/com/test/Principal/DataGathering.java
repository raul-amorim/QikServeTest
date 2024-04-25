package com.test.Principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.*;

public class DataGathering {

	
	public static List<JsonBody> getProducts() {
		String urlString = "http://localhost:8080/products/";
		List<JsonBody> products = null;
		List<JsonBody> completeProducts = new ArrayList<JsonBody>();
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlString)).build();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			ObjectMapper objectMapper = new ObjectMapper();
			products = objectMapper.readValue(response.body(), objectMapper.getTypeFactory()
				      .constructCollectionType(List.class, JsonBody.class));
			
			for (JsonBody product : products) {
				request = HttpRequest.newBuilder().GET().uri(URI.create(urlString + product.getId())).build();
				response = client.send(request, HttpResponse.BodyHandlers.ofString());
				
				JsonBody completeProduct = objectMapper.readValue(response.body(), JsonBody.class);
				completeProducts.add(completeProduct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return completeProducts;
	}

	private static Product readFile(String path){
		StringBuilder builder = new StringBuilder();
		Product product = null;
		
		try {
			File file = new File(path);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				builder.append(line + "\n");
			}

			ObjectMapper objectMapper = new ObjectMapper();
			product = objectMapper.readValue(builder.toString(), Product.class);

		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return product;
	}
}

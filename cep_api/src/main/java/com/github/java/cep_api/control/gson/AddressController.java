package com.github.java.cep_api.control.gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.github.java.cep_api.control.AddressControllerGeneric;
import com.github.java.cep_api.model.Address;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class AddressController extends AddressControllerGeneric {


	@Override
	@SuppressWarnings("unchecked")
	protected InputStreamReader searchAddressOnWebServer(String cep) {

		String cepURL = webServiceURL.replace("?", cep);

		try {
			URL url = new URL(cepURL);
			InputStreamReader reader = new InputStreamReader(url.openStream());

			return reader;

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}

		return null;
	}

	@Override
	public Address getAddressFromCep(String cep) {

		InputStreamReader reader = this.searchAddressOnWebServer(cep);
		
		return (new Gson()).fromJson(reader, Address.class);

	}
	
	
	@Override
	public String getJsonStringFromCep(String cep) {

		InputStreamReader reader = this.searchAddressOnWebServer(cep);

		JsonElement el = JsonParser.parseReader(reader);

		return el.toString();
	}
}

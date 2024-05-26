package com.github.java.cep_api.control.jackson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.java.cep_api.control.AddressControllerGeneric;
import com.github.java.cep_api.model.Address;

public class AddressController extends AddressControllerGeneric{

	//web service address with ? in place of desired cep
	private String webServiceURL = "https://viacep.com.br/ws/?/json/";
		//"https://h-apigateway.conectagov.estaleiro.serpro.gov.br/api-cep/v1/consulta/cep/?";
	
	private ObjectMapper objMapper;
	
	public AddressController() {

		this.objMapper = new ObjectMapper();
	}

	@Override
	@SuppressWarnings("unchecked")
	protected JsonNode searchAddressOnWebServer(String cep) {
		
		//limpar cep antes de passar adiante
		String cepURL = webServiceURL.replace("?", cep);

		try {
			URL url = new URL(cepURL);
		
			JsonNode json = this.objMapper.readTree(url);
			
			return json;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}

		throw new NullPointerException("No data found for given cep");
	}
	
	/**
	 * Searchs a given CEP within Brazilian government database
	 * 
	 * @param cep the given cep
	 * 
	 * @return the JSON String for the cep's address or null if not found
	 * @throws MalformedURLException 
	 * */
	@Override
	public String getJsonStringFromCep(String cep) throws NullPointerException {
		
		return this.searchAddressOnWebServer(cep).toString();
		
	}
	
	/**
	 * Searchs a given CEP within Brazilian government database
	 * 
	 * @param cep the given cep
	 * 
	 * @return the Adress object for the cep's address or null if not found
	 * */
	@Override
	public Address getAddressFromCep(String cep) throws NullPointerException{
		
		String jsonString = this.getJsonStringFromCep(cep);
		
		Address address = null;
		
		try {
			address = this.objMapper.readValue(jsonString, Address.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		
		return address;
	}
	
	//public boolean validCep()
}

package com.github.java.cep_api.control;

import com.github.java.cep_api.model.Address;

public abstract class AddressControllerGeneric {

	// web service address with ? in place of desired cep
	public final String webServiceURL = "https://viacep.com.br/ws/?/json/";
	// "https://h-apigateway.conectagov.estaleiro.serpro.gov.br/api-cep/v1/consulta/cep/?";

	protected abstract <T extends Object> T searchAddressOnWebServer(String cep);
	
	public abstract Address getAddressFromCep(String cep);

	public abstract String getJsonStringFromCep(String cep);
	
}

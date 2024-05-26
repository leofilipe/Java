package com.github.java.cep_api.control.gson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.github.java.cep_api.model.Address;


public class AddressControllerTest {

	
	AddressController addressController;
	String cep = "91509900";
	
	@BeforeEach
	public final void setUp() {
		addressController = new AddressController();
	}
	
	@Disabled("Usable on server down only")
	@Test
	public final void testSearchNullCep() {

		assertThrows(NullPointerException.class, () -> {
			this.addressController.getJsonStringFromCep(cep);
		});
		
		assertThrows(NullPointerException.class, () -> {
			this.addressController.getJsonStringFromCep(cep);
		});
	}
	
	@Test
	public final void testSearchJSonCepSucess() {

		String json = this.addressController.getJsonStringFromCep(cep);
		assertNotNull(json);
		assertTrue(json.contains("91509-900"));

	}
	
	@Test
	public final void testSearchCepFail() {

		assertThrows(NullPointerException.class, () -> {
			this.addressController.getJsonStringFromCep("99");
		});
		
		assertThrows(NullPointerException.class, () -> {
			this.addressController.getJsonStringFromCep(" ");
		});
		
		assertThrows(NullPointerException.class, () -> {
			this.addressController.getAddressFromCep("99");
		});
		
		assertThrows(NullPointerException.class, () -> {
			this.addressController.getAddressFromCep(" ");
		});
		
	}
	
	@Test
	public final void testSearchAddressSuccess() {
		
		Address add = this.addressController.getAddressFromCep(cep);
		
		assertNotNull(add);
		assertEquals("51", add.getDdd());
		assertEquals("RS", add.getUf());
	}

}


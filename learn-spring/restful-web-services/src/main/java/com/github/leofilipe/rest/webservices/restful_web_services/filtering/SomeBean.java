package com.github.leofilipe.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties("field1") // alternative de @JsonIgnore on each ignored field> Two or more fields:
// {"field1", "field2"}

@JsonFilter("SomeBeanFilter") //used for dynamic filtering
public class SomeBean {

	private String field1;

	// @JsonIgnore // useful for hidding password field data in static filtering.
	// Dynamic filtering is done at the controller
	private String field2;
	private String field3;

	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}

}

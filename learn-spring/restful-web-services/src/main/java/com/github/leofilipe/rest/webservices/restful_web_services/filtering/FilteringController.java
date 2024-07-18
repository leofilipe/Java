package com.github.leofilipe.rest.webservices.restful_web_services.filtering;

import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {

		SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");

		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		
		this.setFilters(mapping, "field1", "field3");
		
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
//		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//
//		mapping.setFilters(filters);

		return mapping;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
		List<SomeBean> list = Arrays.asList(new SomeBean("Value1", "Value2", "Value3"),
				new SomeBean("Value4", "Value5", "Value6"), new SomeBean("Value7", "Value8", "Value9"));

		MappingJacksonValue mapping = new MappingJacksonValue(list);

		this.setFilters(mapping, "field2", "field3");
		
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
//		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//		mapping.setFilters(filters);

		return mapping;
	}
	
	public void setFilters(MappingJacksonValue mapping, String... fields) {
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping.setFilters(filters);
		
	}
}

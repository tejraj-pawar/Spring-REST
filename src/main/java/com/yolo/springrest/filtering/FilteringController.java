package com.yolo.springrest.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	// static filtering using @JsonIgnore
	@GetMapping("/static-filtering")
	public SomeBean returnSomeBean()
	{
		SomeBean someBean = new SomeBean("value1", "value2", "password");
		return someBean;
	}
	
	@GetMapping("/static-filtering-list")
	public List<SomeBean> returnSomeBeanList()
	{
		return Arrays.asList(new SomeBean("11", "22", "password33"),
				new SomeBean("111", "222", "password333"));
	}
	
	//here we are filtering all value except "field1" for this request only
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue returnSomeBean1()
	{
		SomeBean someBean = new SomeBean("value1", "value2", "password");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		
		return mapping;
	}
	
	//here we are filtering all value except "field1","field2" for this request only
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue returnSomeBeanList1()
	{
		List<SomeBean> list = Arrays.asList(new SomeBean("11", "22", "password33"),
				new SomeBean("111", "222", "password333"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}

}

package com.yolo.springrest.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
 
	//versioning using diff. resource URI for diff versions 
	@GetMapping("/v1/person")
	public Person_V1 personV1()
	{
		return new Person_V1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public Person_V2 personV2()
	{
		return new Person_V2(new Name("Bob", "Charlie"));
	}
	//end
	
	//versioning using diff. param(query parameter) 
	@GetMapping(value = "/person/param", params = "version=1")
	public Person_V1 paramV1()
	{
		return new Person_V1("Bob Charlie");
	}
	
	@GetMapping(value = "/person/param", params = "version=2")
	public Person_V2 paramV2()
	{
		return new Person_V2(new Name("Bob", "Charlie"));
	}
	//end
	
	//versioning using diff. header 
	@GetMapping(value = "/person/header", headers = "version=1")
	public Person_V1 headerV1()
	{
		return new Person_V1("Bob Charlie");
	}
	
	@GetMapping(value = "/person/header", headers = "version=2")
	public Person_V2 headerV2()
	{
		return new Person_V2(new Name("Bob", "Charlie"));
	}
	//end
	
	//versioning using produces parameter(Accept header versioning).
	//to use this in add header Accept=application/vnd.company.app-v1+json
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public Person_V1 producesV1()
	{
		return new Person_V1("Bob Charlie");
	}
	
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public Person_V2 producesV2()
	{
		return new Person_V2(new Name("Bob", "Charlie"));
	}
	//end	
}

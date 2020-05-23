package com.yolo.springrest.HelloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

@RestController //controller i.e. this will handle rest request
public class HelloWorldController {
	
	// INTERNATIONLIZATION
	@Autowired
	public MessageSource messageSource;
	
	// this is for INTERNATIONALIZATION and observe message_XX.properties file
	@GetMapping(path = "/hello-world-internationalized")
	public String internationalization(@RequestHeader(name="Accept-Language", required = false) Locale locale)
	{
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	@GetMapping(path = "/hello-world-internationalized1")
	public String internationalization1()
	{
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	//above both methods give same output
	// INTERNATIONLIZATION END
	
	
	// Get method with URI = /hello-world
	@GetMapping(path = "/hello-world")
	public String helloWorld()
	{
		return "Hello YOLO";
	}
	
	// return a bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean returnBean()
	{
		return new HelloWorldBean("Hello YOLO");
	}
	
	// return bean using ResponseEntity
	@GetMapping(path = "/hello-world-bean1")
	public ResponseEntity<HelloWorldBean> returnBean1()
	{
		return new ResponseEntity<HelloWorldBean>(new HelloWorldBean("Hello YOLO"), HttpStatus.ACCEPTED);
	}
	
	// Using path variable
	@GetMapping(path = "/hello-world-bean2/{name}")
	public ResponseEntity<HelloWorldBean> returnBean2(@PathVariable String name)
	{
		//return new ResponseEntity<HelloWorldBean>(new HelloWorldBean("Hello " + name), HttpStatus.ACCEPTED);
		return new ResponseEntity<HelloWorldBean>(new HelloWorldBean(String.format("Hello %s", name)), HttpStatus.ACCEPTED);
	}
	

}

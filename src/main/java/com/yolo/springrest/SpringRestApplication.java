/*
 * HelloWorldController.java: INTERNATIONALIZATION and other rest services
 * UserResourceController.java: Validation of RequestBody using @Valid.
 * ResponseExceptionHandler.java: generic response exception handling using @ResponseHandler and @ControllerAdvice
 * ResponseExceptionHandler.java: if validation failed then call goes to handleMethodArgumentNotValid().
 * SwaggerConfig.java: configuring swagger for rest documentation.
 * FilteringController.java: here we are done static and dynamic filtering of rest responses.
 * PersonVersioningController.java: how to manage versioning in different ways.
 * BasicAuthSecurityConfig.java : configuring basic auth manually.
 * UserResourceControllerJPA.java : here we are using jpa-hibernate.
 */

package com.yolo.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
		System.out.println("yoloishere");
	}
	
	// setting defaut locale as US using LocaleResolver in INTERNATIONALIZATION
	/*
	 * @Bean  
	 * public LocaleResolver localResolver() { 
	 * SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	 * localeResolver.setDefaultLocale(Locale.US); 
	 * return localResolver(); }
	 */
}

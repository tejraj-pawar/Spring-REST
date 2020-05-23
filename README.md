# Spring-REST
In this i have created rest services with following features: Exception Handling, Versioning, Static/Dynamic Filtering, Basic Authentication and Swagger Documentation. 

### In above project we have created REST services with having following features:
- Exception Handling: Using @ControllerAdvice along with @ExceptionHandler provides global (and more specific) error handling across all controllers.

-Versioning: For versioning there is no perfect solution. here i have done four types of versioning:
  -URI Versioning: Different URI for different versions of REST apis.
  -Request Param Versioning: Pass specific version query parameter in REST api.
  -Header Versioning: Pass specific version header in REST api.
  -Media Type Versioning: Pass header named "Accept" in REST api.
  
-Filtering: Here i have performed Static and Dyanmic Filtering.
 - Static Filtering: Using @JsonIgnore/@JsonIgnoreProperties annotations.
 - Dynamic Filtering: Using SimpleBeanPropertyFilter and MappingJacksonValue classes.
 
-Baisc Authentication: When we add SpringBoot-starter-security dependency, by default spring boot configures Basic Authentication as a part of Auto-Configuration. but here we have disabled Spring Security AutoConfiguration class and we have configured Basic Authentication by our own.

-Swagger Documentaion: REST support two types of Documentation WADL and Swagger Documentation. here we have created swagger documentation which is a specification of our REST services with interactive UI console.

For more information, download this repo, unzip it and import it as a Maven project.

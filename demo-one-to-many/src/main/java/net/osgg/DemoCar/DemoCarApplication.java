																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. Gómez (2020)
| File Date: Tue Jul 21 10:46:46 COT 2020
| 
 -------------------------------------------------------------------
																*/
package net.osgg.DemoCar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone;
import javax.annotation.PostConstruct;					

@SpringBootApplication
public class DemoCarApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoCarApplication.class, args);
		System.out.println("Active resources for Person entity");
		System.out.println("GET");
		System.out.println("/api/v1/person");
		System.out.println("/api/v1/person/{id}");
		System.out.println("/api/v1/person/findbyaddress/{address}");
		System.out.println("POST");
		System.out.println("/api/v1/person");
		System.out.println("PUT");
		System.out.println("/api/v1/person");
		System.out.println("DELETE");
		System.out.println("/api/v1/person/{id}");
		System.out.println("Active resources for Car entity");
		System.out.println("GET");
		System.out.println("/api/v1/car");
		System.out.println("/api/v1/car/{id}");
		System.out.println("/api/v1/car/findbymodel/{model}");
		System.out.println("POST");
		System.out.println("/api/v1/car");
		System.out.println("PUT");
		System.out.println("/api/v1/car");
		System.out.println("DELETE");
		System.out.println("/api/v1/car/{id}");
	}
	
	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
	}						
}

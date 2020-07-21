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

import net.osgg.DemoCar.Person;
import net.osgg.DemoCar.RecordNotFoundException;
import net.osgg.DemoCar.PersonService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@RequestMapping("/api/v1")
public class PersonController {
	@Autowired
	PersonService service;
	
	@GetMapping("/person")
	public ResponseEntity<List<Person>> getAll() {
		List<Person> list = service.getAll();
		return new ResponseEntity<List<Person>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPersonByIdPerson(@PathVariable("id") Long idPerson) throws RecordNotFoundException {
		Person entity = service.findByIdPerson(idPerson);
		return new ResponseEntity<Person>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/person/findbyaddress/{address}")
	public ResponseEntity<List<Person>> getByAddress(@PathVariable("address") String address){
		List<Person> list = service.findByAddressContaining(address);
		return new ResponseEntity<List<Person>>(list, new HttpHeaders(), HttpStatus.OK);
	}				


	@PostMapping("/person")
	public ResponseEntity<Person> createPerson(@RequestBody Person person){
		service.createPerson(person);
		return new ResponseEntity<Person>(person, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/person")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) throws RecordNotFoundException{
		service.updatePerson(person);
		return new ResponseEntity<Person>(person, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/person/{id}")
	public HttpStatus deletePersonByIdPerson(@PathVariable("id") Long idPerson) throws RecordNotFoundException {
		service.deletePersonByIdPerson(idPerson);
		return HttpStatus.OK;
	}
}				

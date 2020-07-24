																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. G�mez (2020)
| File Date: Tue Jul 21 10:46:46 COT 2020
| 
 -------------------------------------------------------------------
																*/
package net.osgg.DemoCar;

import net.osgg.DemoCar.Person;
import net.osgg.DemoCar.RecordNotFoundException;
import net.osgg.DemoCar.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

	@Autowired
	PersonRepository repo;

	@Autowired
	CarRepository repoCar;
	
	public List<Person> getAll(){
		List<Person> personList = repo.findAll();
		if(personList.size() > 0) {
			return personList;
		} else {
			return new ArrayList<Person>();
		}
	}
     		
	public Person findByIdPerson(Long idPerson) throws RecordNotFoundException{
		Optional<Person> person = repo.findByIdPerson(idPerson);
		if(person.isPresent()) {
			return person.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public List<Person> findByAddressContaining(String address){
		List<Person> personList = repo.findByAddressContaining(address);
		if(personList.size() > 0) {
			return personList;
		} else {
			return new ArrayList<Person>();
		}
	}
	
	public Person createPerson(Person person){
		repo.save(person);

		Iterator<Car> itr = person.getCars().iterator(); 
		while(itr.hasNext()){ 
			Car c = (Car)itr.next();
			repoCar.save( new Car(c.getModel(), c.getYear(), person));
		}		
		return person;
	}

	public Person updatePerson(Person person) throws RecordNotFoundException {
		Optional<Person> personTemp = repo.findByIdPerson(person.getIdPerson());
	
		if(personTemp.isPresent()){
			return repo.save(person);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletePersonByIdPerson(Long idPerson) throws RecordNotFoundException{
		Optional<Person> person = repo.findByIdPerson(idPerson);
		if(person.isPresent()) {
		repo.deleteByIdPerson(idPerson);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}

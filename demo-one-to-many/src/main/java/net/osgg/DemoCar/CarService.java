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

import net.osgg.DemoCar.Car;
import net.osgg.DemoCar.RecordNotFoundException;
import net.osgg.DemoCar.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

	@Autowired
	CarRepository repo;

	public List<Car> getAll(){
		List<Car> carList = repo.findAll();
		if(carList.size() > 0) {
			return carList;
		} else {
			return new ArrayList<Car>();
		}
	}
     		
	public Car findByIdCar(Long idCar) throws RecordNotFoundException{
		Optional<Car> car = repo.findByIdCar(idCar);
		if(car.isPresent()) {
			return car.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public List<Car> findByModelContaining(String model){
		List<Car> carList = repo.findByModelContaining(model);
		if(carList.size() > 0) {
			return carList;
		} else {
			return new ArrayList<Car>();
		}
	}
	
	public Car createCar(Car car){
		return repo.save(car);
	}

	public Car updateCar(Car car) throws RecordNotFoundException {
		Optional<Car> carTemp = repo.findByIdCar(car.getIdCar());
	
		if(carTemp.isPresent()){
			return repo.save(car);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteCarByIdCar(Long idCar) throws RecordNotFoundException{
		Optional<Car> car = repo.findByIdCar(idCar);
		if(car.isPresent()) {
		repo.deleteByIdCar(idCar);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}

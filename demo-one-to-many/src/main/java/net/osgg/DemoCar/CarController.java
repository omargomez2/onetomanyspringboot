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
import net.osgg.DemoCar.CarService;
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
public class CarController {
	@Autowired
	CarService service;
	
	@GetMapping("/car")
	public ResponseEntity<List<Car>> getAll() {
		List<Car> list = service.getAll();
		return new ResponseEntity<List<Car>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/car/{id}")
	public ResponseEntity<Car> getCarByIdCar(@PathVariable("id") Long idCar) throws RecordNotFoundException {
		Car entity = service.findByIdCar(idCar);
		return new ResponseEntity<Car>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/car/findbymodel/{model}")
	public ResponseEntity<List<Car>> getByModel(@PathVariable("model") String model){
		List<Car> list = service.findByModelContaining(model);
		return new ResponseEntity<List<Car>>(list, new HttpHeaders(), HttpStatus.OK);
	}				


	@PostMapping("/car")
	public ResponseEntity<Car> createCar(@RequestBody Car car){
		service.createCar(car);
		return new ResponseEntity<Car>(car, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/car")
	public ResponseEntity<Car> updateCar(@RequestBody Car car) throws RecordNotFoundException{
		service.updateCar(car);
		return new ResponseEntity<Car>(car, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/car/{id}")
	public HttpStatus deleteCarByIdCar(@PathVariable("id") Long idCar) throws RecordNotFoundException {
		service.deleteCarByIdCar(idCar);
		return HttpStatus.OK;
	}
}				

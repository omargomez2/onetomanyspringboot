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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
@Entity
@Table(name = "car_table")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCar;
	

	private String model;
	private Integer year;
	
	@ManyToOne
	@JoinColumn(name="id_person", nullable=false)
	private Person person;
	
	public Car() {}
	
	public Car(Person p) {
		this.person = p;
	}
	
	public Long getIdCar() {
		return idCar;
	}
	
	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}
	
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
}

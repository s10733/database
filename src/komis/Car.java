package komis;

import java.util.List;

import komis.db.EntityBase;

public class Car extends EntityBase{

	

	private Offer offers;
	private String brand;
	private String model;
	private String power;
	private String year;
	private String engine;
	private String mileage;
	private String car_number;
	
	//relacja Auto- Oferta;
	private List<Car> Cars;
	
	public List<Car> getCars() {
		return Cars;
	}
	public void setCars(List<Car> cars) {
		this.Cars = cars;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getCar_number() {
		return car_number;
	}
	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	
}

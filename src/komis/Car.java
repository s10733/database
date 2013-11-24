package komis;

import komis.db.EntityBase;

public class Car extends EntityBase{

	
	//relacja Auto- Oferta;
	private Offer offers;
	private String brand;
	private String model;
	private String power;
	private String year;
	private String engine;
	private String mileage;
	private String car_number;
	
	
	public Offer getOffers() {
		return offers;
	}
	public void setOffers(Offer offers) {
		this.offers = offers;
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

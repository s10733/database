package komis.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import komis.Car;

import komis.db.MysqlDaoBase;
import komis.db.MysqlUnitOfWork;

public class MysqlCarDao extends MysqlDaoBase<Car> implements CarDao {
	OfferDao offerDao;
	
	
	public MysqlCarDao(MysqlUnitOfWork ca){
		
		super(ca);
	}

	

	@Override
	protected void setUpdateQuery(Car ent) throws SQLException {
		update.setInt(1, ent.getId());
		update.setString(2, ent.getBrand());
		update.setString(3, ent.getModel());
		update.setString(4, ent.getYear());
		update.setString(5, ent.getCar_number());
		update.setString(6, ent.getEngine());
		update.setString(7, ent.getPower());
		update.setString(8, ent.getMileage());
		
	}

	@Override
	protected Car build(ResultSet rs) throws SQLException {
		Car car = new Car();
		car.setId(rs.getInt("id"));
		car.setBrand(rs.getString("brand"));
		car.setModel(rs.getString("model"));
		car.setYear(rs.getString("year"));
		car.setCar_number(rs.getString("car_number"));
		car.setEngine(rs.getString("engine"));
		car.setPower(rs.getString("power"));
		car.setMileage(rs.getString("mileage"));
		
		return car;
	}

	@Override
	protected void setInsertQuery(Car ent) throws SQLException {
		insert.setString(1, ent.getBrand());
		insert.setString(2, ent.getModel());
		insert.setString(3, ent.getYear());
		insert.setString(4, ent.getCar_number());
		insert.setString(5, ent.getEngine());
		insert.setString(6, ent.getPower());
		insert.setString(7, ent.getMileage());
		
	}

	@Override
	protected String getTableName() {
		return "car";
	}

	@Override
	protected String getCreateQuery() {
		return "CREATE TABLE car("
				+ "id integer PRIMARY KEY AUTO_INCREMENT NOT NULL,"
				+ "brand VARCHAR(16) NOT NULL,"
				+ "model VARCHAR(50) NOT NULL,"
				+ "year VARCHAR(11) NOT NULL,"
				+ "car_number VARCHAR(40) NOT NULL,"
				+ "engine VARCHAR(40) ,"
				+ "power VARCHAR(10),"
				+ "mileage VARCHAR(12))";
		
	}

	@Override
	protected String getInsertQuery() {
		return "insert into car(brand,model,year,car_number,engine,power,mileage) values (?,?,?,?,?,?,?)";
	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE car SET "
				+ "brand = ? ,model = ?,year = ?,car_number = ?,engine = ?,power = ?, mileage = ?"
				+ "where id =?";

	}
	
	@Override
	public void setOffer(Car ca) {
		ca.setCars(offerDao.getTransactionByCarId(ca.getId()));	
	}

}

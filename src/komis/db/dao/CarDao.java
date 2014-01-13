package komis.db.dao;

import komis.Car;
import komis.db.Dao;

public interface CarDao extends Dao<Car> {

	public void setOffer (Car ca);
	
}

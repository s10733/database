package komis.db.dao;

import java.util.List;

import komis.Car;
import komis.Offer;
import komis.Transaction;
import komis.db.Dao;

public interface OfferDao extends Dao<Offer>{

	 public void setTransaction(Offer o);
	 public List<Car> getTransactionByCarId(int id);
}

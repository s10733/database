package komis.db.dao;

import java.util.List;

import komis.Client;
import komis.Offer;
import komis.Transaction;
import komis.db.Dao;

public interface TransactionDao extends Dao<Transaction>{

	public void setClient(Client c);
	
	 public void setOffer (Offer o);
}

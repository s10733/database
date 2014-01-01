package komis.db.dao;

import java.util.List;
import komis.Offer;
import komis.Transaction;
import komis.db.Dao;

public interface TransactionDao extends Dao<Transaction>{

	public List<Transaction> getTransactionByClientId(int id);
	
	 public void setOffer (Offer o);
}

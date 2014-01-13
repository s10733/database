package komis.db.dao;

import java.util.List;

import komis.Client;
import komis.Offer;
import komis.Seller;
import komis.Transaction;
import komis.db.Dao;

public interface TransactionDao extends Dao<Transaction>{

	 public List<Transaction> getTransactionByClientId(int id);
	 public List<Transaction> getTransactionBySellerId(int id);
	 public List<Transaction> getTransactionByOffertId(int id);
}

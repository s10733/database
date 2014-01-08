package komis.db.dao;


import java.util.List;

import komis.db.Dao;
import komis.Client;
import komis.Transaction;



 public interface ClientDao extends Dao<Client> {
	 public List<Transaction> getTransactionByClientId(int id);
	
	
}

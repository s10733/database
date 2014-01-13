package komis.db.dao;


import java.util.List;

import komis.db.Dao;
import komis.Client;
import komis.Offer;
import komis.Seller;
import komis.Transaction;



 public interface ClientDao extends Dao<Client> {
		public void setTransaction(Client c);
		
	
	
}

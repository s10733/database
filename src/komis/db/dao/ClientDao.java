package komis.db.dao;

import komis.db.Dao;
import komis.Client;



public interface ClientDao extends Dao<Client> {
	public void setTransaction(Client c);
	
	
	
}

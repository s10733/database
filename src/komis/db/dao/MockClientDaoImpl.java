package komis.db.dao;

import java.util.ArrayList;
import java.util.List;

import komis.db.EntityBase;
import komis.Client;
import komis.db.Dao;
import komis.db.MockDb;

public class MockClientDaoImpl implements Dao<Client> {

	private MockDb db;

	public MockDb getDb() {
		return db;
	}

	public void setDb(MockDb db) {
		this.db = db;
	}

	@Override
	public void save(Client object) {
		db.addToList(object);
		
	}

	@Override
	public void delete(Client object) {
		db.getItems().remove(object);
		
	}

	@Override
	public void update(Client object) {
		// TODO Auto-generated method stub
	
		
	
	}

	@Override
	public List<Client> getAll() {
		List<Client> result = new ArrayList<Client>();
		for(EntityBase ent: db.getItems())
		{
		     if(ent instanceof Client)
				result.add((Client) ent);
		}
		return result;
	}

	@Override
	public Client get(int id) {
		for(Client c : getAll())
		{
			if(c.getId()==id)
				return c;
		}
		return null;
	}
	
	public void setTransaction(Client c){
	
	}
	public void setSaw(Client C){

	}

}
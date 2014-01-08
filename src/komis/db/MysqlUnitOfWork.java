package komis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



public class MysqlUnitOfWork implements UnitOfWork {
	
	private Map<EntityBase, UnitOfWorkDao> added;
	private Map<EntityBase, UnitOfWorkDao> deleted;
	private Map<EntityBase, UnitOfWorkDao> updated;
	
	Connection connection;
	
	
	public MysqlUnitOfWork()
	{
		added = new HashMap<EntityBase, UnitOfWorkDao>();
		deleted = new HashMap<EntityBase, UnitOfWorkDao>();
		updated = new HashMap<EntityBase, UnitOfWorkDao>();
		connection = getConnection();
		
	}
	
	public Connection getConnection(){
	
	try {
		if(connection==null || connection.isClosed())
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/java?user=root&password=");
	
	connection.setAutoCommit(false);
	
	}catch(SQLException ex)
	
	{
		ex.printStackTrace();
	
	}
	return connection;
}

	@Override
	public void markNew(EntityBase ent, UnitOfWorkDao dao) {
		added.put(ent, dao);
		
	}

	@Override
	public void markDelete(EntityBase ent, UnitOfWorkDao dao) {
		deleted.put (ent, dao);
		
	}

	@Override
	public void markUpdate(EntityBase ent, UnitOfWorkDao dao) {
		updated.put(ent, dao);
		
	}

	@Override
	public void commit() {

		Connection conn = getConnection();
		
		try {
			conn.setAutoCommit(false);
			for(EntityBase ent: added.keySet())
				added.get(ent).persistAdd(ent);
			for(EntityBase ent: deleted.keySet())
				deleted.get(ent).persistDelete(ent);
			for(EntityBase ent: updated.keySet())
				updated.get(ent).persistUpdate(ent);
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void close() {
		try {
			if(connection!=null && !connection.isClosed()){
				
				connection.close();
				connection = null;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

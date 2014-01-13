package komis.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import komis.Client;



public abstract class MysqlDaoBase<E extends EntityBase> extends DaoBase<E> {

	protected Statement stmt;
	
	protected PreparedStatement insert;
	protected PreparedStatement delete;
	protected PreparedStatement update;
	protected PreparedStatement select;
	protected PreparedStatement selectId;
	protected MysqlDaoBase(MysqlUnitOfWork uow) {
		super(uow);
		try {
			Connection connection = uow.getConnection();
			ResultSet rs = connection.getMetaData().getTables(null,null,null,null);
		
			
			boolean exist = false;
			
			stmt = connection.createStatement();
			
			while (rs.next())
			{
					if(rs.getString("TABLE_NAME").equalsIgnoreCase(getTableName()))
					{
						exist=true;
						break;
			
					}
			}
			
			if(!exist)
			{
			stmt.executeUpdate(getCreateQuery());
			}
			insert = connection.prepareStatement(getInsertQuery());
			
			update = connection.prepareStatement(getUpdateQuery());
			
			delete = connection.prepareStatement(""
					+ "delete from " +getTableName()+" where id =?");
			selectId = connection.prepareStatement(" select * from "+getTableName()+" where id= ?");
			
			select = connection.prepareStatement("select * from "+ getTableName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


public void persistAdd(EntityBase entity) {

	E ent = (E) entity;
	
	try 
	{	
		setInsertQuery(ent);
		insert.executeUpdate();
		
		
	} 
	
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public void persistDelete(EntityBase entity) {
	
	E ent = (E) entity;
	try 
	{
		delete.setInt(1,  ent.getId());
		delete.executeUpdate();
	} 
	
	catch (SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


public void persistUpdate(EntityBase entity) {
E ent = (E) entity;
	try {
		setUpdateQuery(ent);
		update.executeUpdate();
		
		} 
	catch (SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

@Override

public List<E> getAll() {
	List<E> clients = new ArrayList<E>();

	try 
	{
		ResultSet rs = select.executeQuery();
		while(rs.next()){
    	
			
    		clients.add(build(rs));
    		}
	        
	}
	
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return clients;
}

@Override
public E get(int id ) {

	try {
		selectId.setInt(1, id);
	
	ResultSet rs = selectId.executeQuery();
	while(rs.next()){
		
	
		return build(rs);
		}	
	
	} 
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
return null;

}

protected abstract void setUpdateQuery(E ent) throws SQLException;
protected abstract E build(ResultSet rs) throws SQLException ;
protected abstract void setInsertQuery(E ent) throws SQLException ;
protected abstract String getTableName();
protected abstract String getCreateQuery();
protected abstract String getInsertQuery();
protected abstract String getUpdateQuery();
}
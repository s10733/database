package komis.db.dao;


import java.util.ArrayList;
import java.util.List;



import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import komis.Client;
import komis.db.DaoBase;
import komis.db.EntityBase;
import komis.db.MysqlUnitOfWork;

public class MysqlClientDao extends DaoBase<Client> implements ClientDao {
	
	 private Statement stmt;
     private PreparedStatement insert;
     private PreparedStatement delete;
     private PreparedStatement update;
     private PreparedStatement select;
     private PreparedStatement selectId;
     TransactionDao transactionDao;
	
	public MysqlClientDao(MysqlUnitOfWork uow){
			
		super(uow);
			try
			{
			    Connection connection = uow.getConnection();
				ResultSet rs = connection.getMetaData().getTables(null,null,null,null);
             
				
				boolean exist = false;
				
				stmt = connection.createStatement();
				
				while (rs.next())
				{
						if(rs.getString("TABLE_NAME").equalsIgnoreCase("Client"))
						{
							exist=true;
							break;
				
						}
				}
				
				if(!exist)
				{
					
				stmt.executeUpdate("CREATE TABLE Client ("
					                 + "id int NOT NULL AUTO_INCREMENT,"
					                 + "name VARCHAR(50),"
					                 + "surname VARCHAR(50),"
					                 + "pesel VARCHAR(11),"
                                     + "city VARCHAR(50),"
					                 + "street VARCHAR(40),"
                                     + "number integer,"
                                     + "PRIMARY KEY (`id`),"
                                     + "UNIQUE KEY `id` (`id`)"
                                     + ")");
							
					
				};
						insert = connection.prepareStatement("insert into client (name,surname,pesel,city,street,number) values (?,?,?,?,?,?)");
						
						update = connection.prepareStatement(""
								+" update client set"
								+"(name,surname,pesel,city,street,number)=(?,?,?,?,?,?)"
								+ "where id =?");
						
						delete = connection.prepareStatement(""
								+ "delete from client where id =?");
						selectId = connection.prepareStatement(" select * from client where id= ?");
						
						select = connection.prepareStatement("select * from client");
			}
			
			
					catch (Exception e)
					{
						e.printStackTrace();
					}
		}

	public void persistAdd(EntityBase entity) {

		Client ent = (Client) entity;
		
		try 
		{	
			insert.setString(1, ent.getName());
			insert.setString(2, ent.getSurname());
			insert.setString(3, ent.getPesel());
			insert.setString(4, ent.getCity());
			insert.setString(5, ent.getStreet());
			insert.setString(6, ent.getNumber());
			insert.executeUpdate();
			
			System.out.println("dodano do tabeli Klient");	
		} 
		
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void persistDelete(EntityBase entity) {
		
		Client ent = (Client) entity;
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
	Client ent = (Client) entity;
		try {
			update.setString(1, ent.getName());
			update.setString(2, ent.getSurname());
			update.setString(3, ent.getNumber());
			update.setString(4, ent.getCity());
			update.setString(5, ent.getStreet());
			update.setString(6, ent.getPesel());
			update.setInt(7, ent.getId());
			update.executeUpdate();
			
			} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	
	public List<Client> getAll() {
		List<Client> clients = new ArrayList<Client>();

		try 
		{
			ResultSet rs = select.executeQuery();
			while(rs.next()){
        	
				Client c = new Client();
        		c.setName(rs.getString("name"));
        		c.setSurname(rs.getString("surname"));
        		c.setPesel(rs.getString("pesel"));
        		c.setCity(rs.getString("city"));
        		c.setStreet(rs.getString("street"));
        		c.setNumber(rs.getString("number"));
        		c.setId(rs.getInt("id"));
        		clients.add(c);
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
	public Client get(int id) {

		try {
			selectId.setInt(1, id);
		
		ResultSet rs = selectId.executeQuery();
		while(rs.next()){
			
			Client c = new Client();
    		c.setName(rs.getString("name"));
    		c.setSurname(rs.getString("surname"));
    		c.setPesel(rs.getString("pesel"));
    		c.setCity(rs.getString("city"));
    		c.setStreet(rs.getString("street"));
    		c.setNumber(rs.getString("number"));
    		c.setId(rs.getInt("id"));
    		return c;
    		}	
		
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return null;
		
	}

	@Override
	public void setTransaction(Client c) {
		c.setTransactions(transactionDao.getTransactionByClientId(c.getId()));
		
	}

		
	
	

}

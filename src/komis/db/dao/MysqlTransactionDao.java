package komis.db.dao;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import komis.Offer;
import komis.Transaction;
import komis.db.DaoBase;
import komis.db.EntityBase;
import komis.db.MysqlUnitOfWork;




	public class MysqlTransactionDao extends DaoBase<Transaction> implements TransactionDao {
		
		 private Statement stmt;
	     private PreparedStatement insert;
	     private PreparedStatement delete;
	     private PreparedStatement update;
	     private PreparedStatement select;
	     ClientDao clientDao;
		
		public MysqlTransactionDao(MysqlUnitOfWork ooo){
				
			super(ooo);
				try
				{
				    Connection connection = ooo.getConnection();
					ResultSet rs = connection.getMetaData().getTables(null,null,null,null);
	             
					
					boolean exist = false;
					
					stmt =(Statement) connection.createStatement();
					
					while (rs.next())
					{
							if(rs.getString("TABLE_NAME").equalsIgnoreCase("Transaction"))
							{
								exist=true;
								break;
					
							}
					}
					if(!exist)
					{
						stmt.executeUpdate("CREATE TABLE Transaction ("
						                 + "id int NOT NULL AUTO_INCREMENT ,"
						                 + "date VARCHAR(10),"
	                                     + "price double,"
	                                     + "PRIMARY KEY (`id`),"
	                                     + "UNIQUE KEY `id` (`id`)"
						                 + ")");
								
						
					}
							insert = connection.prepareStatement("insert into Transaction(date,price) values (?,?)");
							
							update = connection.prepareStatement(""
									+" update Transaction set"
									+"(date,price)=(?,?)"
									+ "where id =?");
							
							delete = connection.prepareStatement(""
									+ "delete from Transaction where id =?");
							
							
							select = connection.prepareStatement("select * from Transaction");
				}
				
				
						catch (Exception e)
						{
							e.printStackTrace();
						}
			}

		public void persistAdd(EntityBase entity) {

			Transaction ent = (Transaction) entity;
			
			try 
			{	
				insert.setString(1, ent.getDate());
				insert.setDouble(2, ent.getPrice());
				insert.executeUpdate();
				
				System.out.println("dodano do tabeli Produkt");	
			} 
			
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		public void persistDelete(EntityBase entity) {
			
			Transaction ent = (Transaction) entity;
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
		Transaction ent = (Transaction) entity;
			try {
				update.setString(1, ent.getDate());
				update.setDouble(2, ent.getPrice());
				update.setInt(3, ent.getId());
				update.executeUpdate();
				
				} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		@Override
		
		public List<Transaction> getAll() {
			List<Transaction> transaction = new ArrayList<Transaction>();

			try 
			{
				ResultSet rs = select.executeQuery();
				while(rs.next()){
	        	
					Transaction t = new Transaction();
	        		t.setDate(rs.getString("date"));
	        		t.setPrice(rs.getDouble("price"));
	        		t.setId(rs.getInt("id"));
	        		transaction.add(t);
	        		}
			        
			}
			
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return transaction;
		}

		@Override
		public Transaction get(int id) {

			try {
				select.setInt(1, id);
			
			ResultSet rs = select.executeQuery();
			while(rs.next()){
				
				Transaction t = new Transaction();
				t.setDate(rs.getString("date"));
        		t.setPrice(rs.getDouble("price"));
        		t.setId(rs.getInt("id"));
	    		
	    		return t;
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
		public List<Transaction> getTransactionByClientId(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setOffer(Offer o) {
			// TODO Auto-generated method stub
			
		}

		
	
	

			
		
		

	}


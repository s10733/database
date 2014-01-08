package komis.db.dao;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import komis.Client;
import komis.Transaction;
import komis.db.DaoBase;
import komis.db.EntityBase;
import komis.db.MysqlDaoBase;
import komis.db.MysqlUnitOfWork;

public  class MysqlClientDao extends MysqlDaoBase<Client> implements ClientDao {
	TransactionDao transactionDao;
	
	public MysqlClientDao(MysqlUnitOfWork uow){
			
		super(uow);
	}
	
	

	@Override
	protected void setUpdateQuery(Client ent) throws SQLException {
		update.setInt(1, ent.getId());
		update.setString(2, ent.getName());
		update.setString(3, ent.getSurname());
		update.setString(4, ent.getPesel());
		update.setString(5, ent.getCity());
		update.setString(6, ent.getStreet());
		update.setInt(7, ent.getNumber());
	}

	@Override
	protected Client build(ResultSet rs) throws SQLException {
		Client c = new Client();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setSurname(rs.getString("surname"));
		c.setPesel(rs.getString("pesel"));
		c.setCity(rs.getString("city"));
		c.setStreet(rs.getString("street"));
		c.setNumber(rs.getInt("number"));
		
		return c;
	}

	@Override
	protected void setInsertQuery(Client ent) throws SQLException {
		insert.setString(1, ent.getName());
		insert.setString(2, ent.getSurname());
		insert.setString(3, ent.getPesel());
		insert.setString(4, ent.getCity());
		insert.setString(5, ent.getStreet());
		insert.setInt(6, ent.getNumber());
	}

	@Override
	protected String getTableName() {
		return "client";
	}

	@Override
	protected String getCreateQuery() {
		return "CREATE TABLE client("
				+ "id integer PRIMARY KEY AUTO_INCREMENT NOT NULL,"
				+ "name VARCHAR(16) NOT NULL,"
				+ "surname VARCHAR(50) NOT NULL,"
				+ "pesel VARCHAR(11) NOT NULL,"
				+ "city VARCHAR(40) NOT NULL,"
				+ "street VARCHAR(40) ,"
				+ "number integer,)";
	}

	@Override
	protected String getInsertQuery() {
		return "insert into client(name,surname,pesel,city,street,number) values (?,?,?,?,?,?)";
		

	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE client SET "
				+ "name = ? ,surname = ?,pesel = ?,city = ?,street = ?,number = ?"
				+ "where id =?";
	}



	@Override
	public List<Transaction> getTransactionByClientId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

		
	
	

}

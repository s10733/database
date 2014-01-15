package komis.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import komis.Client;
import komis.Seller;
import komis.Transaction;
import komis.db.MysqlDaoBase;
import komis.db.MysqlUnitOfWork;

public class MysqlSellerDao extends MysqlDaoBase<Seller> implements SellerDao {

	TransactionDao transactionDao;
	
	public MysqlSellerDao(MysqlUnitOfWork sel) {
		super(sel);
	}



	@Override
	protected void setUpdateQuery(Seller ent) throws SQLException {
		update.setInt(1, ent.getId());
		update.setString(2, ent.getName());
		update.setString(3, ent.getSurname());
		update.setString(4, ent.getPesel());
		update.setString(5, ent.getCity());
		update.setString(6, ent.getStreet());
		update.setInt(7, ent.getNumber());
		
	}

	@Override
	protected Seller build(ResultSet rs) throws SQLException {
		Seller s = new Seller();
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setSurname(rs.getString("surname"));
		s.setPesel(rs.getString("pesel"));
		s.setCity(rs.getString("city"));
		s.setStreet(rs.getString("street"));
		s.setNumber(rs.getInt("number"));
		
		return s;		
	}

	@Override
	protected void setInsertQuery(Seller ent) throws SQLException {
		insert.setString(1, ent.getName());
		insert.setString(2, ent.getSurname());
		insert.setString(3, ent.getPesel());
		insert.setString(4, ent.getCity());
		insert.setString(5, ent.getStreet());
		insert.setInt(6, ent.getNumber());
		System.out.println("DODANO SPRZEDAWCÊ");
		
	}

	@Override
	protected String getTableName() {
		return "seller";
	}

	@Override
	protected String getCreateQuery() {
		System.out.println("STWORZONO TABELE SELLER");
		return "CREATE TABLE seller("
				+ "id integer PRIMARY KEY AUTO_INCREMENT NOT NULL,"
				+ "name VARCHAR(16) NOT NULL,"
				+ "surname VARCHAR(50) NOT NULL,"
				+ "pesel VARCHAR(11) NOT NULL,"
				+ "city VARCHAR(40) NOT NULL,"
				+ "street VARCHAR(40) ,"
				+ "number integer)";
	}

	@Override
	protected String getInsertQuery() {
		return "insert into seller(name,surname,pesel,city,street,number) values (?,?,?,?,?,?)";	
	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE seller SET "
				+ "name = ? ,surname = ?,pesel = ?,city = ?,street = ?,number = ?"
				+ "where id =?";
	}



	@Override
	public void setTransaction(Seller s) {
		s.setTransactions(transactionDao.getTransactionBySellerId(s.getId()));
	}

}

package komis.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import komis.Car;
import komis.Offer;
import komis.db.MysqlDaoBase;
import komis.db.MysqlUnitOfWork;

public class MysqlOfferDao extends MysqlDaoBase<Offer> implements OfferDao {

		TransactionDao transactionDao;
	public MysqlOfferDao(MysqlUnitOfWork ofe) {
		super(ofe);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	protected void setUpdateQuery(Offer ent) throws SQLException {
		update.setInt(1, ent.getId());
		update.setDouble(2, ent.getPrice());
	}

	@Override
	protected Offer build(ResultSet rs) throws SQLException {
		Offer o = new Offer();
		o.setId(rs.getInt("id"));
		o.setPrice(rs.getInt("price"));
		return o;
	}

	@Override
	protected void setInsertQuery(Offer ent) throws SQLException {
		insert.setInt(1, ent.getPrice());
		System.out.println("DODANO OFERTE");
		
	}

	@Override
	protected String getTableName() {
		
		return "offer";
	}

	@Override
	protected String getCreateQuery() {
		System.out.println("STWORZONO TABELE OFFER");
		return "CREATE TABLE offer("
				+ "id integer PRIMARY KEY AUTO_INCREMENT NOT NULL,"
				+ "price integer NOT NULL)";
	}

	@Override
	protected String getInsertQuery() {
		return "insert into offer(price) values (?)";

	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE offer SET "
				+ "price = ?"
				+ "where id =?";
	}



	@Override
	public void setTransaction(Offer o) {
		o.setTransactions(transactionDao.getTransactionByOffertId(o.getId()));
	}



	@Override
	public List<Car> getTransactionByCarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

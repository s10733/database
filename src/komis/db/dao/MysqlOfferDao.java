package komis.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import komis.Car;
import komis.Offer;
import komis.db.MysqlDaoBase;
import komis.db.MysqlUnitOfWork;

public class MysqlOfferDao extends MysqlDaoBase<Offer> implements OfferDao {

	protected MysqlOfferDao(MysqlUnitOfWork uow) {
		super(uow);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Car> getCarById(int id) {
		// TODO Auto-generated method stub
		return null;
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
		o.setPrice(rs.getDouble("price"));
		return o;
	}

	@Override
	protected void setInsertQuery(Offer ent) throws SQLException {
		insert.setInt(1, ent.getId());
		insert.setDouble(2, ent.getPrice());
		
	}

	@Override
	protected String getTableName() {
		
		return "offer";
	}

	@Override
	protected String getCreateQuery() {
		return "CREATE TABLE client("
				+ "id integer PRIMARY KEY AUTO_INCREMENT NOT NULL,"
				+ "price dobule NOT NULL ,)";
	}

	@Override
	protected String getInsertQuery() {
		return "insert into offer(price) values (?)";

	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE client SET "
				+ "price = ?"
				+ "where id =?";
	}

}

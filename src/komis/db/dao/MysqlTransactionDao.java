package komis.db.dao;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import komis.Client;
import komis.Offer;
import komis.Transaction;
import komis.db.DaoBase;
import komis.db.EntityBase;
import komis.db.MysqlDaoBase;
import komis.db.MysqlUnitOfWork;




	public class MysqlTransactionDao extends MysqlDaoBase<Transaction> implements TransactionDao {
		
		 
		
		public MysqlTransactionDao(MysqlUnitOfWork tra){
				
			super(tra);
		 }
		 @Override
			protected void setUpdateQuery(Transaction ent) throws SQLException {
				update.setInt(1, ent.getId());
				update.setString(2, ent.getDate());
				update.setDouble(3, ent.getPrice());
				
			}

			@Override
			protected Transaction build(ResultSet rs) throws SQLException {
				Transaction t = new Transaction();
				t.setId(rs.getInt("id"));
				t.setDate(rs.getString("date"));
				t.setPrice(rs.getDouble("price"));
				;
				
				return t;
			}

			@Override
			protected void setInsertQuery(Transaction ent) throws SQLException {
				insert.setString(1, ent.getDate());
				insert.setDouble(2, ent.getPrice());
				
			}

			@Override
			protected String getTableName() {
				return "transaction";
			}

			@Override
			protected String getCreateQuery() {
				return "CREATE TABLE transaction("
						+ "id integer PRIMARY KEY AUTO_INCREMENT NOT NULL,"
						+ "date date NOT NULL,"
						+ "pirce double NOT NULL,)";
			}

			@Override
			protected String getInsertQuery() {
				return "insert into transaction(date,price) values (?,?)";
				

			}

			@Override
			protected String getUpdateQuery() {
				return "UPDATE transaction SET "
						+ "(date,price)="
						+ "(?,?)"
						+ "where id =?";
	
			}
				

@Override
public void setClient(Client c) {
	// TODO Auto-generated method stub
	
}
@Override
public void setOffer(Offer o) {
	// TODO Auto-generated method stub
	
}
}
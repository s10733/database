package komis.db.dao;

import java.util.List;

import komis.Seller;
import komis.Transaction;
import komis.db.Dao;

public interface SellerDao extends Dao<Seller> {
	public void setTransaction(Seller s);
}

package komis.db.dao;
import komis.db.Dao;

import komis.Offer;


public interface OfferDao extends Dao<Offer> {

	public void setClient(Offer c);
	public void setCar(Offer C);
	
	
}


import java.io.ObjectInputStream.GetField;

import komis.Car;
import komis.Client;
import komis.Offer;
import komis.Seller;
import komis.Transaction;
import komis.db.MysqlUnitOfWork;
import komis.db.dao.CarDao;
import komis.db.dao.ClientDao;
import komis.db.dao.MysqlCarDao;
import komis.db.dao.MysqlClientDao;
import komis.db.dao.MysqlOfferDao;
import komis.db.dao.MysqlSellerDao;
import komis.db.dao.MysqlTransactionDao;
import komis.db.dao.OfferDao;
import komis.db.dao.SellerDao;
import komis.db.dao.TransactionDao;


public class Main {

	
	
	public static void main(String[] args) {
		
		
		
		MysqlUnitOfWork cli = new MysqlUnitOfWork();
		ClientDao dao = new MysqlClientDao(cli);
		Client c = new Client();
		
		
		c.setName("Pawe³");
		c.setSurname("Kowalski");
		c.setPesel("82120314592");
		c.setCity("Warszawa");
		c.setStreet("Kochanowskiego");
		c.setNumber(500100200);
		dao.save(c);
		
		
		/*delete client
		Client c1 = new Client();
		c1.setId(6);
		dao.delete(c1);
		*/

		cli.commit();
		cli.close();
	
		MysqlUnitOfWork tra = new MysqlUnitOfWork();
		TransactionDao tdao = new MysqlTransactionDao(tra);
		Transaction t = new Transaction();
		
		t.setDate("2013-11-30");
		t.setPrice(1900);
		
		tdao.save(t);
		tra.commit();
		tra.close();
		
		MysqlUnitOfWork ca = new MysqlUnitOfWork();
		CarDao carDao = new MysqlCarDao(ca);
		Car car = new Car();
		
		car.setBrand("Opel");
		car.setModel("Vectra");
		car.setCar_number("WLA32103203");
		car.setYear("2000");
		car.setEngine("2.0");
		car.setPower("101km");
		car.setMileage("251000");
		carDao.save(car);
		ca.commit();
		ca.close();
		
		
		MysqlUnitOfWork ofe = new MysqlUnitOfWork();
		OfferDao offerDao = new MysqlOfferDao(ofe);
		Offer offer = new Offer();
		
		offer.setPrice(5000);
		
		offerDao.save(offer);
		ofe.commit();
		ofe.close();
		
		
		MysqlUnitOfWork  sel = new MysqlUnitOfWork();
		SellerDao sellerDao = new MysqlSellerDao(sel);
		Seller seller = new Seller();
		
		seller.setName("Krzysztof");
		seller.setSurname("Lis");
		seller.setPesel("83489554256");
		seller.setCity("Poznañ");
		seller.setStreet("wybickiego 5");
		seller.setNumber(500100200);
		
		sellerDao.save(seller);
		sel.commit();
		sel.close();
		
	}

}

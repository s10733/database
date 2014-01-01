
import komis.Client;
import komis.Transaction;
import komis.db.MysqlUnitOfWork;
import komis.db.dao.ClientDao;
import komis.db.dao.MysqlClientDao;
import komis.db.dao.MysqlTransactionDao;
import komis.db.dao.TransactionDao;


public class Main {

	
	
	public static void main(String[] args) {
		
		
		
		MysqlUnitOfWork uow = new MysqlUnitOfWork();
		ClientDao dao = new MysqlClientDao(uow);
		Client c = new Client();
		
		
		c.setName("Pawe�");
		c.setSurname("Kowalski");
		c.setPesel("82120314592");
		c.setCity("Warszawa");
		c.setStreet("Kochanowskiego");
		c.setNumber("500100200");
	
		dao.save(c);
		uow.commit();
		uow.close();
		System.out.println("koniec");
	
		MysqlUnitOfWork ooo = new MysqlUnitOfWork();
		TransactionDao tdao = new MysqlTransactionDao(ooo);
		Transaction t = new Transaction();
		
		t.setDate("2013-11-11");
		t.setPrice(1900);
		tdao.save(t);
		ooo.commit();
		ooo.close();
	}

}

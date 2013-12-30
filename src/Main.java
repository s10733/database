import java.sql.DriverManager;
import java.sql.SQLException;




import com.mysql.jdbc.Connection;

import komis.Client;
import komis.db.MysqlUnitOfWork;
import komis.db.dao.ClientDao;
import komis.db.dao.MysqlClientDao;


public class Main {

	
	
	public static void main(String[] args) {
		
		
		
		MysqlUnitOfWork uow = new MysqlUnitOfWork();
		ClientDao dao = new MysqlClientDao(uow);
		Client c = new Client();
		
		
		c.setName("Pawe³");
		c.setSurname("Kowalski");
		c.setPesel("82120314598");
		c.setCity("Warszawa");
		c.setStreet("Kochanowskiego");
		c.setNumber("500100200");
		c.setId(0);
		
		dao.save(c);
		uow.commit();
		uow.close();
	System.out.println("koniec");
		
	}

}

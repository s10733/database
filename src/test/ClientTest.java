package test;

import static org.junit.Assert.*;
import komis.Client;
import komis.db.MysqlUnitOfWork;
import komis.db.dao.ClientDao;
import komis.db.dao.MysqlClientDao;

import org.junit.Before;
import org.junit.Test;



public class ClientTest {

	
	ClientDao dao;
	@Before
	public void dodaj(){
		Client c = new Client();
		c.setName("Adam");
		c.setSurname("Koza");
		c.setPesel("82120314592");
		c.setCity("Kraków");
		c.setStreet("Kochanowskiego");
		c.setNumber(500100200);
		
		MysqlUnitOfWork cli = new MysqlUnitOfWork();
		dao = new MysqlClientDao(cli);
		
		dao.save(c);
		cli.commit();
		
		
	}
	@Test
	public void test() {
		Client c1 = dao.get(2);
		Client c2 = dao.get(0);
		assertEquals(c1.getName(),"Adam");
		assertNotSame(c1, c2);
	}

}

package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import komis.Client;
import komis.db.MysqlUnitOfWork;
import komis.db.dao.ClientDao;
import komis.db.dao.MysqlClientDao;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ClientDaoTest {

	ClientDao dao;

	Connection connection = null;
	private Statement drop;
	
	@BeforeClass
	public static void initialize()
	{}
	
	@Before
	public void setUp()
	{

		Client c = new Client();
		c.setName("Pawe³");
		c.setSurname("Kowalski");
		c.setPesel("82120314598");
		c.setCity("Warszawa");
		c.setStreet("Kochanowskiego");
		c.setNumber("500100200");
		c.setId(0);
		try {

			MysqlUnitOfWork uow = new MysqlUnitOfWork();
			dao = new MysqlClientDao(uow);
			dao.save(c);
			uow.commit();
			drop = uow.getConnection().createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@After
	public void teardown()
	{
		try{
			if(connection!=null && !connection.isClosed())
			{	
				drop.executeUpdate("Drop table Client");
				connection.close();
				connection = null;
			}}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}
	
	@Test
	public void testGet() {
		
		Client c1 = dao.get(0);
		Client c2 = dao.get(2);
		Client c3 = dao.get(0);
		
		assertNotNull("Zwrócono null mimo ze obiekt jest w bazie",c1);
		assertNull("zwrócono wartosc mimo, ¿e nie ma takiego obiektu w bazie",c2);
		assertTrue(c1.getPesel().equals("82120314598"));
		
		assertEquals(c1.getName(),"Pawe³");
		assertEquals(c1.getSurname(), "Kowalski");
		assertEquals(c1.getNumber(),"500100200");
		
		assertNotSame(c1,c3);
		
	}

}

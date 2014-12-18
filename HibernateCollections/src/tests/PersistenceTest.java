package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.Address;
import persistence.Person;
import persistence.dao.PersonDAO;
import persistence.dao.PersonDAOImpl;
public class PersistenceTest {
	
	static PersonDAO personDao;
	static List<Person> persons;
	
	@BeforeClass
	static public void init()
	{
		personDao = new PersonDAOImpl();
		persons = new ArrayList<Person>();
		initDB();
	}
	
	static public void initDB()
	{
		for(int i = 0; i < 10; i++)
		{
			Person p = new Person(i, "name " + i, "surname " + i);
			p.addMobileNumber("3"+i);
			p.addMobileNumber("4"+i);
						
			p.addAddress(new Address("street"+i));
			persons.add(p);
			personDao.create(p);
		}
		
		Person p = persons.get(9);
		p.getAddresses().clear();
		personDao.update(p);
	}
	
	@Test
	public void testMobileNumbers()
	{
		assertEquals(new Integer(2), personDao.numberOfMobileNumbers(1));
	}
	
	@Test
	public void testAddresses()
	{
		assertEquals(new Integer(1), personDao.numberOfAddresses(1));
	}
	
	@Test
	public void testAddresses9()
	{
		assertEquals(new Integer(0), personDao.numberOfAddresses(10));
	}
}

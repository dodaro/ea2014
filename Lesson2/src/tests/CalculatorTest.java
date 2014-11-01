package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import calculator.Calculator;


public class CalculatorTest {
	
	static Calculator calculator;
	static int testNumber;
	
	
	@BeforeClass
	static public void  beforeAllTheOthers()
	{
		System.out.println("This method is invoked before all the others");
		calculator = new Calculator();
		testNumber = 0;
	}
	
	@After
	public void addResult()
	{
		testNumber++;
		System.out.println("This method is invoked after the execution of test number: "+testNumber);
	}
	
	@Before
	public void resetResult()
	{
		System.out.println("This method is invoked before the execution of test number: "+ (testNumber+1));
	}
	
	@AfterClass
	static public void printAllResults()
	{
		System.out.println("This method is invoked after the execution of ALL the tests");
	}
	
	@Test
	public void testSum()
	{
		assertEquals("",calculator.execute(1, 2, '+'), 3.0, 0.001);
	}
	
	@Test
	public void testSubtraction()
	{
		assertEquals("",calculator.execute(1, 2, '-'), -1.0, 0.001);
	}
	
	@Test
	public void testMultiplication()
	{
		assertEquals("",calculator.execute(1, 2, '*'), 2.0, 0.001);
	}
	
	@Test
	public void testDivision()
	{
		assertEquals(calculator.execute(1, 2, '/'), 0.5, 0.001);
	}
	
	@Test
	public void testDivisionByZero()
	{
		assertEquals(calculator.execute(1, 0, '/'), null);
	}

	@Test(timeout = 100)
	public void testTimer()
	{
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Ignore("Testing @Ignore annotation")
	public void testIgnorato()
	{
	}
	
	@Test(expected = RuntimeException.class)
	public void testException()
	{
		throw new RuntimeException();
	}
	

}

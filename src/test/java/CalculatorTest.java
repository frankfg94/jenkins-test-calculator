package test.java;

import org.junit.Test;


import junit.framework.TestCase;
import main.java.com.efrei.Calculator;

public class CalculatorTest extends TestCase {
	
	// Unit tests
	
	@Test
	public void testMultiply(){
		double a = 5;
		double b = 5;
		double c = 2;
		double d = 15.5f;
		Calculator calc = new Calculator();
		double resultA = calc.multiply(a, b);
		assertTrue(a*b == resultA);
		double resultB = calc.multiply(c, d);
		assertTrue(c*d == resultB);
	}
	
	@Test
	public void testSumString(){
		Calculator c = new Calculator();
		double resultA = c.sum("230", "25.5");
		assertTrue(230+25.5f == resultA);
	}
}

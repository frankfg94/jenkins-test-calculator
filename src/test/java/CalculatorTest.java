package test.java;

import org.junit.Test;


import junit.framework.TestCase;
import main.java.com.efrei.Calculator;

public class CalculatorTest extends TestCase {
	
	// Unit tests
	
	@Test
	public void testMultiply(){
		float a = 5;
		float b = 5;
		float c = 2;
		float d = 15.5f;
		Calculator calc = new Calculator();
		float resultA = calc.multiply(a, b);
		assertTrue(a*b == resultA);
		float resultB = calc.multiply(c, d);
		assertTrue(c*d == resultB);
	}
	
	@Test
	public void testSumString(){
		Calculator c = new Calculator();
		float resultA = c.sum("230", "25.5");
		assertTrue(230+25.5f == resultA);
	}
}

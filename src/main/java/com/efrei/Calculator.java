package main.java.com.efrei;

public class Calculator {
	public double sum(double a, double b){
		return a+b;
	}
	
	public double sum(String a, String b) throws NullPointerException{
		return sum(Double.parseDouble(a),Double.parseDouble(b));
	}
	
	public double multiply(double a,double b){
		return a * b;
	}
	
	public double multiply(String a, String b) throws NullPointerException{
		return multiply(Double.parseDouble(a),Double.parseDouble(b));
		}
	}

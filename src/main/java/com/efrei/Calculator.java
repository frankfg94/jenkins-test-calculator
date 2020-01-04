package main.java.com.efrei;

public class Calculator {
	public double sum(double a, double b){
		return a+b;
	}
	
	public double sum(String a, String b){
		return sum(Double.parseDouble(a),Double.parseDouble(b));
	}
	
	public double multiply(double a,double b){
		return a * b;
	}
}

package main.java.com.efrei;

public class Calculator {
	public float sum(float a, float b){
		return a+b;
	}
	
	public float sum(String a, String b){
		return sum(Float.parseFloat(a),Float.parseFloat(b));
	}
	
	public float multiply(float a, float b){
		return a * b;
	}
}

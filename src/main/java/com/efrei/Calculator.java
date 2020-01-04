package com.efrei;

public class Calculator {
	public float Sum(float a, float b){
		return a+b;
	}
	
	public float Sum(String a, String b){
		return Sum(Float.parseFloat(a),Float.parseFloat(b));
	}
	
	public float multiply(float a, float b){
		return a * b;
	}
}

package br.com.kelly.math;

public class SimpleMath {

	public Double sum(Double firstNumber, Double secondNumber) {
		return firstNumber + secondNumber;
	}
	
	public Double subtraction(Double firstNumber, Double secondNumber) {
		return firstNumber - secondNumber;
	}

	public Double multiplication(Double firstNumber, Double secondNumber) {
		return firstNumber * secondNumber;
	}

	public Double division(Double firstNumber, Double secondNumber) {
		return firstNumber / secondNumber;
	}
	
	public Double mean(Double firstNumber, Double secondNumber) {
		return (firstNumber + secondNumber)/2;
	}
	
	public Double squareroot(Double number) {
		return Math.sqrt(number);
	}

}

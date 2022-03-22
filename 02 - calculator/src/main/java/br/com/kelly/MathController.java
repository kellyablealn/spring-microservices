	package br.com.kelly;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.kelly.exception.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) 
					throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		Double sum= convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) 
					throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		Double subtraction = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return subtraction;
	}
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(
			@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) 
					throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		Double multiplication = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return multiplication;
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(
			@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) 
					throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		if (convertToDouble(numberTwo) == 0) {
			throw new UnsupportedMathOperationException("Division by zero not allowed.");
		}
		
		Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return division;
	}
	
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(
			@PathVariable("numberOne") String numberOne, 
			@PathVariable("numberTwo") String numberTwo) 
					throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		Double mean = (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
		return mean;
	}
	
	@RequestMapping(value="/squareroot/{number}", method=RequestMethod.GET)
	public Double mean(
			@PathVariable("number") String number) 
					throws Exception {
		
		if (!isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		Double squareroot = Math.sqrt(convertToDouble(number));
		return squareroot;
	}
	
	public Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0d; 
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0d;
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null) return false; 
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
	
}

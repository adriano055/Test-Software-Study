package udemy.roman;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {
	private Map<String, Integer> table;
	
	public RomanNumeral() {
		table = new HashMap<String, Integer>();
		table.put("I", 1);
		table.put("V", 5);
		table.put("X", 10);
		table.put("L", 50);
		table.put("C", 100);
		table.put("D", 500);
		table.put("M", 1000);
	}
	
	public int convert(String roman) {
		int result = 0;
		
		int beforeNumber = 0;
		for(int i = 0 ; i < roman.length() ; i++) {
			int number = table.get(String.valueOf(roman.charAt(i)));
			
			if(i > 0 && beforeNumber < number) {
				result = result + number - (2*beforeNumber);
			}
			
			else{
				result = result + number;
			}
			beforeNumber = number;
		}
		return result;
	}
}

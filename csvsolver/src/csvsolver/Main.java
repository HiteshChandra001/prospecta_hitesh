package csvsolver;

import java.util.HashMap;
import java.util.Map;

public class Main {
	
	 Map<String,Integer> map=new HashMap<>();
	
	public void addValue(String cell,String value) {
		if(cell.length()>2) throw new IllegalArgumentException("invalid cell");
		
		if(value.charAt(0)=='=') {
			
		}else {
			
			int val;
			try {
				val = Integer.valueOf(value);
			}catch(NumberFormatException ex) {
				throw new IllegalArgumentException("invalid value");
			}
			
			map.put(cell,val);
		}
	}
	
	public int findValue(String value) {
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
		main.addValue("A1", "5");
		main.addValue("A2", "7");
		main.addValue("A3", "9");
		main.addValue("B1", "3");
		main.addValue("B2", "8");
		main.addValue("B3", "=4+5");
		
		System.out.println(main.map);
	}
}
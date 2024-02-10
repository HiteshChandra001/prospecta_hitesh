package csvsolver;

import java.util.HashMap;
import java.util.Map;

public class Main {
	
	 Map<String,Integer> map=new HashMap<>();
	
	public void addValue(String cell,String value) {
		if(!map.containsKey(cell)) throw new IllegalArgumentException("invalid cell");
		
		int num=0;
		
		if(value.charAt(0)=='=') {
			
			int ind=1;
			
			while(ind<value.length()) {
				
				StringBuilder sb=new StringBuilder();
				
				while(ind<value.length() && value.charAt(ind)!='+') {
					sb.append(value.charAt(ind));
					ind++;
				}
				
				num+=findValue(sb.toString(),map);
				
				ind++;
			}
		}else {
			try {
				num = Integer.valueOf(value);
			}catch(NumberFormatException ex) {
				throw new IllegalArgumentException("invalid value");
			}
			
			
		}
		map.put(cell,num);
	}
	
	public int findValue(String value,Map<String,Integer> map) {
		int num;
		
		try {
			num=Integer.valueOf(value);
		}catch(NumberFormatException ex){
			if(!map.containsKey(cell)) throw new IllegalArgumentException("invalid cell");
			num=map.get(value);
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
//	test case	A1: 5, A2: 7, A3: 9, B1: 3, B2: 8, B3: =4+5, C1: =5+A1, C2: =A2+B2, C3: =C2+B3
		
		main.addValue("A1", "5");
		main.addValue("A2", "7");
		main.addValue("A3", "9");
		main.addValue("B1", "3");
		main.addValue("B2", "8");
		main.addValue("B3", "=4+5");
		main.addValue("C1", "=5+A1");
		main.addValue("C2", "=A2+B2");
		main.addValue("C3", "=C2+B3");
		
		System.out.println(main.map);
	}
}

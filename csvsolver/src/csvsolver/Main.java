package csvsolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private Map<String,Integer> map=new HashMap<>();
	
	
	public Map<String, Integer> getMap() {
		return map;
	}

	public void addValue(String cell,String value) {
		
		int num=0;
		
		if(value.charAt(0)=='=') {
			
			int ind=1;
			
			while(ind<value.length()) {
				
				StringBuilder sb=new StringBuilder();
				
				while(ind<value.length() && value.charAt(ind)!='+') {
					sb.append(value.charAt(ind));
					ind++;
				}
				
				num+=findValue(sb.toString());
				
				ind++;
			}
		}else {
			try {
				num = Integer.valueOf(value);
			}catch(NumberFormatException ex) {
				throw new IllegalArgumentException("invalid value: "+num);
			}
			
			
		}
		map.put(cell,num);
		
	}
	
	public int findValue(String value) {
		int num;
		
		try {
			num=Integer.valueOf(value);
		}catch(NumberFormatException ex){
			if(!map.containsKey(value)) throw new IllegalArgumentException("invalid cell: "+ value);
			num=map.get(value);
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Main main=new Main();
		
		int choice=1;
		System.out.println("welcome to CSV Services");
		
		while(choice != 0) {
			
			System.out.println("enter 1 to enter values");
			System.out.println("enter 2 to show result");
			System.out.println("enter 0 to exit");
			
			System.out.print("enter: ");
			choice=sc.nextInt();
			if(choice == 0) break;
			else if(choice == 2) {
				System.out.println("Result: "+main.getMap());
				continue;
			}else if(choice != 1) {
				System.out.println("invalid input");
				continue;
			}
			
			System.out.print("enter cell address : ");
			String cell=sc.next();
			System.out.print("enter value : ");
			String val=sc.next();
			
			main.addValue(cell,val);
		}
		
		System.out.println("thank you for using our services");
		sc.close();
		
		
		
	}
}

package Ticket;
import java.util.*;
public class Display{
	public  static void d(HashMap hm4) {
		HashMap<String,Theatre> d1=hm4;
		Scanner sc=new Scanner(System.in);
		System.out.println("Select movie");
		System.out.println(hm4.keySet());
		int breaker1=0;
		String moviename=new String();
		Theatre o1 = null;
		//movie check
		while(true) {
			System.out.print("Type your movie:");
			 moviename=sc.nextLine();
			for(Map.Entry<String,Theatre> e1:d1.entrySet()) {
				if(moviename.equals(e1.getKey())) {
					breaker1=1;
					o1=e1.getValue();
					System.out.println(o1.hm3.keySet());
					
				}
			}
			if(breaker1==1) {break;}
		}
		//Theater check
		HashMap<String,Date> d2=o1.hm3;
		int breaker2=0;
		Date o2= null;
		String theatrename=new String();
		while(true) {
			System.out.print("Type your theater:");
			theatrename=sc.nextLine();
			for(Map.Entry<String,Theatre> e1:d1.entrySet()) {
				if(moviename.equals(e1.getKey())) {
					for(Map.Entry<String,Date> e2:d2.entrySet()) {
						if(theatrename.equals(e2.getKey())) {
							breaker2=1;
							o2=e2.getValue();
							System.out.println(o2.hm2.keySet());
						}
					}
				}
			}
			if(breaker2==1) {break;}
		}
		//Date check
		HashMap<String,Shows> d3=o2.hm2;
		int breaker3=0;
		Shows o3= null;
		String getDate=new String();
		while(true) {
			System.out.print("Type your date:");
			getDate=sc.nextLine();
			for(Map.Entry<String,Theatre> e1:d1.entrySet()) {
				if(moviename.equals(e1.getKey())) {
					for(Map.Entry<String,Date> e2:d2.entrySet()) {
						if(theatrename.equals(e2.getKey())) {
							for(Map.Entry<String,Shows> e3:d3.entrySet()) {
								if(getDate.equals(e3.getKey())) {
									breaker3=1;
									o3=e3.getValue();
									System.out.println(o3.hm1.keySet());
								}
							}
						}
					}
				}
			}
			if(breaker3==1) {break;}
		}
		//shows check
		HashMap<String, Seats> d4=o3.hm1;
		int breaker4=0;
		Seats o4= null;
		String ShowTime=new String();
		while(true) {
			System.out.print("Type Show Time:");
			ShowTime=sc.nextLine();
			for(Map.Entry<String,Theatre> e1:d1.entrySet()) {
				if(moviename.equals(e1.getKey())) {
					for(Map.Entry<String,Date> e2:d2.entrySet()) {
						if(theatrename.equals(e2.getKey())) {
							for(Map.Entry<String,Shows> e3:d3.entrySet()) {
								if(getDate.equals(e3.getKey())) {
									for(Map.Entry<String,Seats> e4:d4.entrySet()) {
										if(ShowTime.equals(e4.getKey())) {
											PrintSeat.print(e4.getValue());
											Book.b(e4.getValue());
											System.out.println("To cancel press '^'");
											char c=sc.next().charAt(0);
											if(c=='^') {
												Book.cancel(e4.getValue());
											}
											breaker4=1;
										}
										
									}
								}
							}
						}
					}
				}
			}
			if(breaker4==1) {break;}
		}
		
	}
}

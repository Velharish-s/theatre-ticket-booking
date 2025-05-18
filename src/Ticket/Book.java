package Ticket;
import java.util.*;
import java.util.Scanner;
public class Book {
	static HashMap<String,StringBuilder> cancel=new HashMap<>();
	static void b(Seats obj) {
		Scanner s1=new Scanner(System.in);
		String phNo;
		while(true) {
			System.out.print("Enter phNo:");
			phNo=s1.next();
			if(phNo.length()==10) {break;}
		}
		StringBuilder index=new StringBuilder();
		ArrayList<String> need=new ArrayList<>();
		while(true) {
			System.out.println("Enter your seat number(if enough press '0'):");
			String dupseat=s1.next();
			if(dupseat.equals("0"))break;
			if(!need.contains(dupseat)) {
				need.add(dupseat);
			}
		}
		String h[][]=obj.seat;
		for(int k=0;k<need.size();k++) {
			for(int i=0;i<h.length;i++) {
				for(int j=0;j<h[0].length;j++) {
					if(need.get(k).equals(h[i][j])) {
						h[i][j]="**";
						index.append(i);
						index.append(j);
					}
				}
			}
		}
		cancel.put(phNo,index);
		PrintSeat.print(obj);
	}
	static void cancel(Seats obj) {
		String h[][]=obj.seat;
		Scanner s2=new Scanner(System.in);
		String ph=new String();
		while(true) {
			System.out.println("Enter your ph.NO Number:");
			ph=s2.next();
			if(ph.length()==10)break;
		}
		int breaker=0;
			for(Map.Entry<String,StringBuilder> e:cancel.entrySet()) {
				if(ph.equals(e.getKey())) {
					StringBuilder temp=e.getValue();
					for(int i=0;i<temp.length()-1;i+=2) {
						int n1=temp.charAt(i)-'0';
						int n2=temp.charAt(i+1)-'0';
						n1++;n2++;
						StringBuilder t=new StringBuilder();
						t.append(n1);
						t.append(n2);
						n1--;
						n2--;
						h[n1][n2]=t.toString();
					}
					breaker=1;
				}
				if(breaker==1) {break;}
			}
		
	}
}

package Ticket;
import java.util.*;
public class Sign_in {
	HashMap<String,User> s1=new HashMap<>();
	Scanner scan=new Scanner(System.in);
	{
		String password=new String();
		while(true) {
			System.out.print("Enter Password:");
			password=scan.nextLine();
			if(password.length()<8) {continue;}
			int L=0,l=0;
			int d=0,sc=0,space=0;
			for(int i=0;i<password.length();i++) {
				if(Character.isDigit(password.charAt(i))) {d++;}
				else if(password.charAt(i)>='a'&&password.charAt(i)<='b') {l++;}
				else if(password.charAt(i)>='A'&&password.charAt(i)<='B') {L++;}
				else if(password.charAt(i)!=' '&&!Character.isLetter(password.charAt(i))&&!Character.isDigit(password.charAt(i))) {sc++;}
				else if(password.charAt(i)==' ') {space++;}
			}
			if(d>=1&&l>=1&&L>=1&&space==0&&sc>=1) {break;}
		}
		s1.put(password,new User());
		Starting.intial1();
	}
}

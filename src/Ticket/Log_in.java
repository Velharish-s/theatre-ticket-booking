package Ticket;

import java.util.*;

public class Log_in {
	static Scanner s1=new Scanner(System.in);
	static void check_Login(HashMap<String,Sign_in> s2){
		System.out.println(s2.keySet());
		System.out.print("Enter Name:");
		String name=new String();
		name=s1.nextLine();
		for(Map.Entry<String,Sign_in> e1:s2.entrySet()) {
			if(name.equals(e1.getKey())) {
				System.out.print("Enter PassWord:");
				String password=s1.nextLine();
				Sign_in o=e1.getValue();
				HashMap<String,User> s3=o.s1;
				for(Map.Entry<String,User> e2:s3.entrySet()) {
					if(password.equals(e2.getKey())) {
						System.out.print("okok");
					}
				}
			}
		}
		Starting.intial1();
	}
}

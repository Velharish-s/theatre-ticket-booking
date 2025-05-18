package Ticket;
import java.util.*;
public class Sign_in_name {
	 HashMap<String,Sign_in> s2=new HashMap<>();
	Scanner scan=new Scanner(System.in);
	void name() {
		String Name=new String();
		while(true) {
			System.out.print("Enter Name:");
			Name=scan.nextLine();
			if(Name.length()>=2) {
				break;
			}
			else {
				System.out.println("Invalid!");
			}
		}
		s2.put(Name, new Sign_in());
		
	}
}

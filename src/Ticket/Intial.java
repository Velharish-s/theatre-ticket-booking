package Ticket;
import java.util.*;
public class Intial {
	static Scanner s1=new Scanner(System.in);
	public static int get() {
		System.out.println("1.sign in");
		System.out.println("2.login in");
		int need=0;
		while(true) {
			System.out.print("Enter:");
			need=s1.nextInt();
			if(need==1||need==2) {break;}
			else {
				System.out.println("Invalid!");
			}
		}
		return need;
	}
}

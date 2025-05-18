package Ticket;

import java.util.*;

public class Starting extends Movies{
	static void intial1(){
		int n1=Intial.get();
		if(n1==1) {
			Sign_in_name o1=new Sign_in_name();
			o1.name();
		}else {
			Log_in.check_Login();
		}
	}
	public static void main(String hj[]) {
		intial1();
		
//		Movies obj1=new Movies();
//		while(true){
//			Display.d(hm4);
//		}
	}
}

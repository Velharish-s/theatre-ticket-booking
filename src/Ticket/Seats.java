package Ticket;
import java.util.*;
public class Seats {
	String seat[][]=new String[9][9];
	{//instance block
		for(int i=0;i<seat.length;i++) {
			for(int j=0;j<seat[0].length;j++) {
				StringBuilder temp=new StringBuilder();
				temp.append(i+1);
				temp.append(j+1);
				seat[i][j]=temp.toString();
			}
		}
	}
}


package Ticket;
import java.util.*;
public class Shows {
	HashMap<String,Seats> hm1=new HashMap<>();
	{
		hm1.put("Morning",new Seats());
		hm1.put("Afternoon",new Seats());
		hm1.put("Evening",new Seats());
		hm1.put("Night",new Seats());
	}
}

package ticketmanager;
import java.util.HashMap;
public class ShowSchedule {
	enum show{
		MORNING,
		AFTERNOON,
		EVENING,
		NIGHT;
	}
	
	HashMap<String,SeatingArrangement> showsList=new HashMap<>();
	{
		showsList.put(show.MORNING.toString(),new SeatingArrangement());
		showsList.put(show.AFTERNOON.toString(),new SeatingArrangement());
		showsList.put(show.EVENING.toString(),new SeatingArrangement());
		showsList.put(show.NIGHT.toString(),new SeatingArrangement());
	}
}

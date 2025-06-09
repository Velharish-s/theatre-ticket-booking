package ticketmanager;
import java.util.HashMap;
import java.time.LocalDate;
public class DateManagement {
	HashMap<String,ShowSchedule> dateList=new HashMap<>();
	{
		LocalDate today = LocalDate.now(); 
		dateList.put(today.plusDays(0)+"",new ShowSchedule());
		dateList.put(today.plusDays(1)+"",new ShowSchedule());
		dateList.put(today.plusDays(2)+"",new ShowSchedule());
		dateList.put(today.plusDays(3)+"",new ShowSchedule());
		dateList.put(today.plusDays(4)+"",new ShowSchedule());
	}
}

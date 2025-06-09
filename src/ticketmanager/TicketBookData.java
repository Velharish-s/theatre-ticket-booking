package ticketmanager;
import java.util.ArrayList;
public class TicketBookData {
	String mailId;
	Long pnr;
	String movie;
	String theatre;
	String date;
	String shows;
	ArrayList<String> booked;
	TicketBookData(String mailId,Long pnr,String movie,String theatre,String date,String shows,ArrayList<String> booked){
		this.mailId=mailId;
		this.pnr=pnr;
		this.movie=movie;
		this.theatre=theatre;
		this.date=date;
		this.shows=shows;
		this.booked=booked;
	}
	
}

package ticketmanager;
import java.util.*;
public class TicketCancellation {
	static Scanner scan1=new Scanner(System.in);
	static int ticketSize=InformationSet.details.get(Log.currentIndex).bookings.size();
	static void ticketViewer() {
		System.out.println();
			for(int i=0;i<ticketSize;i++) {
				TicketBookData specificTicket =InformationSet.details.get(Log.currentIndex).bookings.get(i);
				System.out.println();
				if(specificTicket.booked.size()!=0) {
					System.out.println("SNo: "+(i+1));
					System.out.println("Movie: "+specificTicket.movie);
					System.out.println("Date: "+specificTicket.date);
					System.out.println("Theatre name: "+specificTicket.theatre);
					System.out.println("Show: "+specificTicket.shows);
					System.out.println("Selected seats:"+specificTicket.booked);
				}
			}	
	}
	static void cancelType(MovieDetails movie) {
		System.out.println("1.cancel all ticket");
		System.out.println("2.cancel specific ticket");
		int userSelection=0;
		while(true) {
			userSelection=InputCentre.integerGetter();
			if(Display.rightInput(userSelection,1,2)) {
				break;
			}
		}
		if(userSelection==1) {
			cancelTicket(movie,1);
		}
		else {
			cancelTicket(movie,2);
		}
		
	}
	static void cancelTicket(MovieDetails movie,int directionInteger) {
		ticketViewer() ;
		int userSelection=0;
		while(true) {
			System.out.println("serial number");
			userSelection=InputCentre.integerGetter();
			if(Display.rightInput(userSelection,1,ticketSize)) {
				break;
			}else {
				System.out.println("Invalid");
			}
		}int breaker=0;
		TicketBookData selectedTicket=InformationSet.details.get(Log.currentIndex).bookings.get(userSelection-1);
		for(int i=0;i<MovieDetailAdder.moviedetailsObject.size();i++) {
			MovieDetails particularMovie=MovieDetailAdder.moviedetailsObject.get(i);
			if(particularMovie.movie.equalsIgnoreCase(selectedTicket.movie)) {
					if(particularMovie.theatre.equalsIgnoreCase(selectedTicket.theatre)) {
						DateManagement date=particularMovie.Date;
						HashMap<String,ShowSchedule> dateList=date.dateList;
						for(Map.Entry<String,ShowSchedule> traverse1:dateList.entrySet()) {
							if(traverse1.getKey().equals(selectedTicket.date)) {
								HashMap<String,SeatingArrangement> showsList=traverse1.getValue().showsList;
								for(Map.Entry<String,SeatingArrangement> traverse2:showsList.entrySet()) {
									if(traverse2.getKey().equalsIgnoreCase(selectedTicket.shows)) {
										breaker=1;
										if(directionInteger==1) {
											cancelAllTicket(traverse2.getValue(),selectedTicket);
										}
										else if(directionInteger==2) {
											selectedTicketCancel(traverse2.getValue(),selectedTicket);
										}
										if(breaker==1) {break;}
									}
								}
							}
						}
					}
			}
		}
	}
	
	static void cancelAllTicket(SeatingArrangement seats,TicketBookData selectedTicket) {
		ArrayList<String> cancelList=selectedTicket.booked;
		for(int i=0;i<cancelList.size();i++) {
			int rowIndex=cancelList.get(i).charAt(0)-'0';
			int columnIndex=cancelList.get(i).charAt(1)-'0';
			rowIndex--;
			columnIndex--;
			seats.seatsList[rowIndex][columnIndex].bookStatus=false;
		}
		selectedTicket.booked.clear();
	}
	static void selectedTicketCancel(SeatingArrangement seats,TicketBookData selectedTicket) {
		System.out.println(selectedTicket.booked);
		ArrayList<String> getCancelTicket=new ArrayList<>();
		while(true) {
			System.out.print("Enter seat number (If enough press 0):");
			String seat=scan1.next();
			if(seat.length()==1&&seat.charAt(0)=='0') {
				break;
			}
			else if(seat.length()==2) {
				if(Character.isDigit(seat.charAt(0)) && Character.isDigit(seat.charAt(1))) {
					int rowIndex=seat.charAt(0)-'0';
					int columnIndex=seat.charAt(1)-'0';
					rowIndex--;
					columnIndex--;
					if(rowIndex>=0 && rowIndex <=8 && columnIndex >=0 && columnIndex <=8) {
						seats.seatsList[rowIndex][columnIndex].bookStatus=false;
						selectedTicket.booked.remove(seat);
						System.out.println("cancelled!");
					}
					
				}
			}
			else {
				System.out.println("Invalid!");
			}
		}
	}
}

package ticketmanager;
import java.util.*;
public class SeatsDisplay {
	static Scanner scanner=new Scanner(System.in);
	static void seatsDisplay(Seat[][] seatsList) {
		for(int i=0;i<seatsList.length;i++) {
			for(int j=0;j<seatsList[0].length;j++) {
					if(!seatsList[i][j].bookStatus) {
						System.out.print(seatsList[i][j].seatNo+" ");
					}else {
						System.out.print("** ");
					}
			}System.out.println();
		}
	}
	static void detailsCollecter(String selectedMovie,String selectedDistrict,String selectedTheatre,String selectedDate,String selectedShows) {
		int breaker=0;//work is here
		for(int i=0;i<MovieDetailAdder.moviedetailsObject.size();i++) {
			MovieDetails particularMovie=MovieDetailAdder.moviedetailsObject.get(i);
			if(particularMovie.movie.equalsIgnoreCase(selectedMovie)) {
				if(particularMovie.district.equalsIgnoreCase(selectedDistrict)) {
					if(particularMovie.theatre.equalsIgnoreCase(selectedTheatre)) {
						DateManagement date=particularMovie.Date;
						HashMap<String,ShowSchedule> dateList=date.dateList;
						for(Map.Entry<String,ShowSchedule> traverse1:dateList.entrySet()) {
							if(traverse1.getKey().equals(selectedDate)) {
								HashMap<String,SeatingArrangement> showsList=traverse1.getValue().showsList;
								for(Map.Entry<String,SeatingArrangement> traverse2:showsList.entrySet()) {
									if(traverse2.getKey().equalsIgnoreCase(selectedShows)) {
										breaker=1;
										SeatsDisplay newBook=new SeatsDisplay();
										seatsDisplay(traverse2.getValue().seatsList);
										newBook.book(traverse2.getValue().seatsList);
										if(breaker==1) {break;}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	//bookticket
	ArrayList<String> selected=new ArrayList<>();
	 void book(Seat[][] seatsList) {
		while(true) {
			System.out.println("If Enough press '0'");
			System.out.print("Enter seat no:");
			String selectedSeat=scanner.nextLine();
			if(selectedSeat.length()==1&&selectedSeat.charAt(0)=='0') {
				if(selected.size()!=0) {
					Display.dataTransfer(selected);
				}
				System.out.println("Thank you");
				break;
			}
			else if(selectedSeat.length()==2) {
				if(Character.isDigit(selectedSeat.charAt(0)) && Character.isDigit(selectedSeat.charAt(1)) ) {
					int rowIndex=selectedSeat.charAt(0)-'0';
					int columnIndex=selectedSeat.charAt(1)-'0';
					rowIndex--;
					columnIndex--;
					if(seatsList[rowIndex][columnIndex].bookStatus==false) {
						seatsList[rowIndex][columnIndex].bookStatus=true;
						selected.add(selectedSeat);
					}
					else {
						System.out.println("Its already bloked");
					}
				}
			}
		}
		Display.userDisplay();	
	}
	
}

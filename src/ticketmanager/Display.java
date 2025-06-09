package ticketmanager;
import java.time.LocalDate;
import java.util.*;
public class Display {
	static Scanner scan=new Scanner(System.in);
	static MovieDetails movieList;
	static {
		movieList=new MovieDetails();
	}
	static String selectedMovie;
	static String selectedDistrict;
	static String selectedTheatre;
	static String selectedDate;
	static String selectedShows;
	static Long randomNumber=1000L;
	
	
	SeatingArrangement seatsObject;
	static void bookTravel1(int userSelection){
		switch(userSelection){
		case 1:
			userLoginDisplay();
			break;
		case 2:
			InformationSet.adminSignin();
			display1();
			break;
		default:
			System.out.print("Invalid!");
			display1();
	    }
	}
	static void bookTravel2(int userSelection) {
		switch(userSelection) {
		case 1:
			Log.signinDetail();
			Display.userLoginDisplay();
			break;
		case 2:
			InformationSet.informationSetter();
			Display.userLoginDisplay();
			break;
		case 3:
			Display.display1();
			break;
		default:
			System.out.println("Invalid!");
			userLoginDisplay();
		}
	}
	static void bookTravel3(int userSelection) {
		switch(userSelection) {
		case 1:
			TheatreDetails.movieChange();
			adminOption();
			break;
		case 2:
			TheatreDetails.theatreScreen();
			adminOption();
			break;
		case 3:
			TheatreDetails.theatreRemove();
			adminOption();
			break;
		case 4:
			Display.display1();
			break;
		default:
			adminOption();
		}
	}
	static void bookTravel4(int userSelection) {
		switch(userSelection) {
		 case 1:
				Display ticketDetails=new Display();
				ticketDetails.movieDisplay();
				ticketDetails.DistrictDisplay();
				ticketDetails.TheatreDisplay();
				ticketDetails.DateDisplay();
				ticketDetails.ShowsDisplay();
				SeatsDisplay.detailsCollecter(selectedMovie,selectedDistrict,selectedTheatre,selectedDate,selectedShows);
				break;
		 case 2:
			 TicketCancellation.cancelType(movieList);
			 userDisplay();
			 break;
		 case 3:
			 TicketCancellation.ticketViewer();
			 userDisplay();
			 break;
		 case 4:
			 Log.passwordChanger();
			 userDisplay();
			 break;
		 case 5:
			 display1();
			 break;
		 default:
			 userDisplay();
		 }
	}
	static boolean rightInput(int value,int start_limit,int end_limit) {
			if(start_limit<=value&&end_limit>=value) {
				return true;
			}
				return false;
	}
	static void display1() {
		System.out.println("1.User login");
		System.out.println("2.Admin login");
		int userSelection=0;
		while(true) {
			userSelection=InputCentre.integerGetter();
			if(rightInput(userSelection,1,2)) {
				break;
			}
		}
		bookTravel1(userSelection);
	}

	static void userLoginDisplay() {
		int userSelection=0;
		while(true) {
			System.out.println("1.sign in");
			System.out.println("2.sign up");
			System.out.println("3.Exit");
			userSelection=InputCentre.integerGetter();
			if(rightInput(userSelection,1,3)) {
				break;
			}
		}
		bookTravel2(userSelection);
	}
	static void adminOption() {
		int userSelection=0;
		while(true) {
			System.out.println("1.Change Movie");
			System.out.println("2.Theatre add");
			System.out.println("3.Theatre Remove");
			System.out.println("4.Exit");
		
		
			userSelection=InputCentre.integerGetter();
			if(rightInput(userSelection,1,4)) {
				break;
			}
		}
		bookTravel3(userSelection);
	}
	static String movie=new String();
	 void movieDisplay() {
		 ArrayList<String> movie=new ArrayList<>();
		 for(int i=0;i<MovieDetailAdder.moviedetailsObject.size();i++) {
			 String particularMovie=MovieDetailAdder.moviedetailsObject.get(i).movie;
			 int existCounter=0;
			 for(int j=0;j<movie.size();j++) {
				 if(movie.get(j).equalsIgnoreCase(particularMovie)) {existCounter++;}
			 }
			 if(existCounter==0) {
				 movie.add(particularMovie);
			 }
		 }
		while(true) {
			System.out.println(movie);
			System.out.print("Enter the Movie:");
			selectedMovie=scan.nextLine();
			int breaker=0;
			for(int i=0;i<movie.size();i++) {
				if(movie.get(i).equalsIgnoreCase(selectedMovie)) {
					breaker=1;
					break;
				}
				else if(i==movie.size()-1) {
					System.out.println("Invalid");
				}
			}
			if(breaker==1) {break;}
		}
	}
	 void DistrictDisplay() {
		 ArrayList<String> districtList=new ArrayList<>();
		 for(int i=0;i<MovieDetailAdder.moviedetailsObject.size();i++) {
			 String particularDistrict=MovieDetailAdder.moviedetailsObject.get(i).district;
			 int existCounter=0;
			 for(int j=0;j<districtList.size();j++) {
				 if(districtList.get(j).equalsIgnoreCase(particularDistrict)) {existCounter++;}
			 }
			 if(existCounter==0) {
				 districtList.add(particularDistrict);
			 }
		 }
		 while(true) {
			 System.out.println(districtList);
			 System.out.print("Enter the District:");
			 selectedDistrict=scan.nextLine();
			 int breaker=0;
			 for(int i=0;i<districtList.size();i++) {
					if(districtList.get(i).equalsIgnoreCase(selectedDistrict)) {
						breaker=1;
						break;
					}
					else if(i==districtList.size()-1) {
						System.out.println("Invalid");
					}
			 }
			 if(breaker==1) {break;}
		 }
	 }
	 void TheatreDisplay() {
		 ArrayList<String> theatreList=new ArrayList<>();
		 for(int i=0;i<MovieDetailAdder.moviedetailsObject.size();i++) {
			 String particularMovie=MovieDetailAdder.moviedetailsObject.get(i).movie;
			 String particularTheatre=MovieDetailAdder.moviedetailsObject.get(i).theatre;
			 String particularDistrict=MovieDetailAdder.moviedetailsObject.get(i).district;
			 int existCounter=0;
			 
			 if(particularMovie.equalsIgnoreCase(selectedMovie)) {
				 if(particularDistrict.equalsIgnoreCase(selectedDistrict)){
					 for(int j=0;j<theatreList.size();j++) {
						 if(theatreList.get(j).equalsIgnoreCase(particularTheatre)) {
							 existCounter++;
						 }
					 }
					 if(existCounter==0) {
						 theatreList.add(particularTheatre);
					 }
				 }
			 }
		 }
		 while(true) {
			 if(theatreList.size()==0) {
				 System.out.println("Theatre Unavailable");
				 userDisplay();
			 }
			 System.out.println(theatreList);
			 System.out.print("Enter the Theatre:");
			 selectedTheatre=scan.nextLine();
			 int breaker=0;
			 for(int i=0;i<theatreList.size();i++) {
					if(theatreList.get(i).equalsIgnoreCase(selectedTheatre)) {
						breaker=1;
						break;
					}
					else if(i==theatreList.size()-1) {
						System.out.println("Invalid");
					}
			 }
			 if(breaker==1) {break;}
		 }
	 }
	 void DateDisplay() {
		 LocalDate today=LocalDate.now();
		 System.out.println(today.plusDays(0));
		 System.out.println(today.plusDays(1));
		 System.out.println(today.plusDays(2));
		 System.out.println(today.plusDays(3));
		 System.out.println(today.plusDays(4));
		 while(true) {
			 System.out.print("Enter Date:");
			 selectedDate=scan.next();
			 scan.nextLine();
			 String date0=today.plusDays(0)+"";
			 String date1=today.plusDays(1)+"";
			 String date2=today.plusDays(2)+"";
			 String date3=today.plusDays(3)+"";
			 String date4=today.plusDays(4)+"";
			 if(date0.equals(selectedDate) ||date1.equals(selectedDate) ||date2.equals(selectedDate) ||date3.equals(selectedDate) ||date4.equals(selectedDate)) {
				 break;
			 }
		 } 
	 }
	 void ShowsDisplay() {
		 int userSelection=0;
		 while(true) {
			 System.out.println("1.Morning show");
			 System.out.println("2.Afternoon show");
			 System.out.println("3.Evening show");
			 System.out.println("4.Night show");
			 System.out.print("S.No ");
			 userSelection=InputCentre.integerGetter();
			if(rightInput(userSelection,1,4)) {
				break;
			}
		 }
		 switch(userSelection) {
		 case 1:
			 selectedShows="Morning";
			 break;
		 case 2:
			 selectedShows="Afternoon";
		 	 break;
		 case 3:
			 selectedShows="Evening";
			 break;
		 case 4:
			 selectedShows="Night";
			 break;
		 }
	 }
	 static void dataTransfer(ArrayList<String> selectedSeats) {
		 randomNumber++;
		 TicketBookData data=new TicketBookData(Log.currentMailId,randomNumber, selectedMovie,selectedTheatre,selectedDate,selectedShows,selectedSeats);
		 InformationSet.details.get(Log.currentIndex).bookings.add(data);
	 }
	 static void userDisplay() {
		    int userSelection=0;
			while(true) {
				System.out.println("1.Book Ticket");
				System.out.println("2.Cancel Ticket");
				System.out.println("3.View Ticket");
				System.out.println("4.password change");
				System.out.println("5.Exit");
				userSelection=InputCentre.integerGetter();
				if(rightInput(userSelection,1,5)) {
					break;
				}
			}
			bookTravel4(userSelection);
	 }
}

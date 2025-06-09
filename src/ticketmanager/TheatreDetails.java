package ticketmanager;
import java.util.*;
public class TheatreDetails {
	static Scanner scanner=new Scanner(System.in);
	static void theatreRemove() {
		System.out.println("1.Remove Particular Screen in the Theatre");
		System.out.println("2.Remove Theatre");
		int userSelection=0;
		while(true) {
			userSelection=InputCentre.integerGetter();
			if(Display.rightInput(userSelection,1,2)) {
				break;
			}
		}
		if(userSelection==1) {
			particularScreenRemove();
		}
		else{
			removerTheatre();
		}
		
	}
	static void particularScreenRemove() {
		System.out.print("Enter theatre name:");
		String theatreName=scanner.nextLine();
		System.out.print("Enter District Name:");
		String districtName=scanner.nextLine();
		for(int i=0;i<MovieDetailAdder.moviedetailsObject.size();i++) {
			if(theatreName.equalsIgnoreCase(MovieDetailAdder.moviedetailsObject.get(i).theatre)) {
				if(districtName.equalsIgnoreCase(MovieDetailAdder.moviedetailsObject.get(i).district)) {
					System.out.println(MovieDetailAdder.moviedetailsObject.get(i).movie);
					System.out.println(MovieDetailAdder.moviedetailsObject.get(i).language);
					System.out.println(MovieDetailAdder.moviedetailsObject.get(i).screenNo);
				}
			}
		}
		while(true) {
			System.out.println("Enter screen number(if enough press '0'):");
			int screenNumber=scanner.nextInt();
			if(screenNumber==0) {break;}
			for(int i=0;i<MovieDetailAdder.moviedetailsObject.size();i++) {
				if(theatreName.equalsIgnoreCase(MovieDetailAdder.moviedetailsObject.get(i).theatre)) {
					if(districtName.equalsIgnoreCase(MovieDetailAdder.moviedetailsObject.get(i).district)) {
						if(screenNumber==MovieDetailAdder.moviedetailsObject.get(i).screenNo) {
							MovieDetailAdder.moviedetailsObject.remove(i);
							System.out.println("Removed");
							break;
						}
					}
				}
			}
		}
	}
	static void removerTheatre() {
		System.out.print("Enter theatre name:");
		String theatreName=scanner.nextLine();
		System.out.print("Enter District Name:");
		String districtName=scanner.nextLine();
		for(int i=0;i<MovieDetailAdder.moviedetailsObject.size();i++) {
			if(theatreName.equalsIgnoreCase(MovieDetailAdder.moviedetailsObject.get(i).theatre)) {
				if(districtName.equalsIgnoreCase(MovieDetailAdder.moviedetailsObject.get(i).district)) {
					MovieDetailAdder.moviedetailsObject.remove(i);
					System.out.println("Removed");
					return;
				}
			}
		}
		System.out.println("Theatre Not Exist");
	}
	static void theatreScreen() {
		System.out.print("Already exising theatre (Y/N):");
		char decision=scanner.next().charAt(0);
		if(decision=='Y' || decision =='y') {
			while(true) {
				System.out.println("\nSCREEN ADD\n");
				System.out.print("Entre Theatre Name:");
				String theatreName=scanner.nextLine();
				System.out.print("Enter District:");
				String districtName=scanner.nextLine();
				int max=0,index=0;
				for(int i=0;i<MovieDetailAdder.moviedetailsObject.size();i++) {
					if(theatreName.equalsIgnoreCase(MovieDetailAdder.moviedetailsObject.get(i).theatre)) {
						if(districtName.equalsIgnoreCase(MovieDetailAdder.moviedetailsObject.get(i).district)) {
							max=Math.max(max, MovieDetailAdder.moviedetailsObject.get(i).screenNo);
							if(max==MovieDetailAdder.moviedetailsObject.get(i).screenNo) {index=i;}
						}
					}
				}
				if(max<MovieDetailAdder.moviedetailsObject.get(index).screenCount) {
					MovieDetails newScreen=new MovieDetails();
					System.out.print("Enter movie name:");
					String movie=scanner.nextLine();
					System.out.print("Enter Language:");
					String language=scanner.nextLine();
					newScreen.movie=movie;
					newScreen.language=language;
					newScreen.theatre=MovieDetailAdder.moviedetailsObject.get(index).theatre;
					newScreen.Date=new DateManagement();
					newScreen.district=MovieDetailAdder.moviedetailsObject.get(index).district;
					newScreen.screenCount=MovieDetailAdder.moviedetailsObject.get(index).screenCount;
					newScreen.screenNo=max+1;
					MovieDetailAdder.moviedetailsObject.add(newScreen);
					break;
				}
				else {
					System.out.println("OOPs you not have enough screen to add");
				}
			}
		}
		else if(decision=='N' || decision =='n') {
			theatreAdded();
		}
		else {
			System.out.println("Invalid!");
		}
	}
	static void theatreAdded() {
		scanner.nextLine();
		MovieDetails newTheatre=new MovieDetails();
		System.out.print("Enter theatre name:");
		newTheatre.theatre=scanner.nextLine();
		int breaker=0;
		for(int i=0;i<MovieDetailAdder.moviedetailsObject.size();i++) {
			if(newTheatre.theatre.equalsIgnoreCase(MovieDetailAdder.moviedetailsObject.get(i).theatre)) {
				System.out.println("Theatre already exist Find an unique name");
				breaker=1;
				break;
			}
		}
		if(breaker==1) {
			return;
		}
		System.out.println("no of screen in Theatre:");
		while(true) {
			newTheatre.screenCount=InputCentre.integerGetter();
			if(Display.rightInput(newTheatre.screenCount,1,10)) {
				break;
			}
		}
		newTheatre.screenNo=1;
		System.out.print("Enter theatre Name:");
		newTheatre.theatre=scanner.nextLine();
		System.out.print("Enter District:");
		newTheatre.district=scanner.nextLine();
		System.out.print("Enter movie name:");
		newTheatre.movie=scanner.nextLine();
		System.out.println("Enter Movie Language:");
		newTheatre.language=scanner.nextLine();
		MovieDetailAdder.moviedetailsObject.add(newTheatre);
		
	}
	static void movieChange() {
		while(true) {
			System.out.print("Enter theatre name:");
			String theatreName=scanner.nextLine();
			System.out.print("Enter District:");
			String districtName=scanner.nextLine();
			int breaker=0;
			for(int i=0;i<MovieDetailAdder.moviedetailsObject.size();i++) {
				MovieDetails particularMovie=MovieDetailAdder.moviedetailsObject.get(i);
				if(particularMovie.district.equalsIgnoreCase(districtName)) {
					if(particularMovie.theatre.equalsIgnoreCase(theatreName)) {
						if(breaker==1) {break;}
						System.out.println("Enter new Movie:");
						particularMovie.movie=scanner.nextLine();
						System.out.print("Enter Language:");
						particularMovie.language=scanner.nextLine();
						breaker=1;
					}
				}
			}
			if(breaker==0) {
				System.out.println("Inalid Theatre name or District name");
			}else {
				break;
			}
		}
		
	}
}

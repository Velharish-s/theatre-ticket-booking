package ticketmanager;
import java.util.*;
enum shows{
	MORNING,
	AFTERNOON,
	EVENING,
	NIGHT;
}
public class MovieDetails {
	String movie;
	String language;
	String district;
	String theatre;
	int screenCount;
	int screenNo;
	DateManagement Date;
}
class MovieDetailAdder {
	static ArrayList<MovieDetails> moviedetailsObject=new ArrayList<>();
	static void manualMovieAdder() {
		// tamil  movies list
		MovieDetails details1=new MovieDetails();
		details1.movie="soorarai pottru";
		details1.language="Tamil";
		details1.district="Erode";
		details1.theatre="Ganesh";
		details1.screenCount=3;
		details1.screenNo=1;
		details1.Date=new DateManagement();
		moviedetailsObject.add(details1);
		MovieDetails details2=new MovieDetails();
		details2.movie="vel";
		details2.language="Tamil";
		details2.district="Erode";
		details2.theatre="pvr";
		details2.screenCount=3;
		details2.screenNo=1;
		details2.Date=new DateManagement();
		moviedetailsObject.add(details2);
		MovieDetails details3=new MovieDetails();
		details3.movie="Love Today";
		details3.language="Tamil";
		details3.district="covai";
		details3.theatre="pvr";
		details3.screenCount=3;
		details3.screenNo=1;
		details3.Date=new DateManagement();
		moviedetailsObject.add(details3);
		MovieDetails details4=new MovieDetails();
		details4.movie="sattai";
		details4.language="Tamil";
		details4.district="karur";
		details4.theatre="karur cinemas";
		details4.screenCount=1;
		details4.screenNo=1;
		details4.Date=new DateManagement();
		moviedetailsObject.add(details4);
		MovieDetails details5=new MovieDetails();
		details5.movie="vel";
		details5.language="Tamil";
		details5.district="karur";
		details5.theatre="mari cinemas";
		details5.screenCount=1;
		details5.screenNo=1;
		details5.Date=new DateManagement();
		moviedetailsObject.add(details5);
		//english movie List
		MovieDetails details6=new MovieDetails();
		details6.movie="Finding Nemo";
		details6.language="English";
		details6.district="Covai";
		details6.theatre="Bro cinemas";
		details6.screenCount=2;
		details6.screenNo=1;
		details6.Date=new DateManagement();
		moviedetailsObject.add(details6);
		MovieDetails details7=new MovieDetails();
		details7.movie="Finding Nemo";
		details7.language="English";
		details7.district="Covai";
		details7.theatre="Bro cinemas";
		details7.screenCount=2;
		details7.screenNo=2;
		details7.Date=new DateManagement();
		moviedetailsObject.add(details7);
		MovieDetails details8=new MovieDetails();
		details8.movie="Toy Story";
		details8.language="English";
		details8.district="chennai";
		details8.theatre="Europe Cinemas";
		details8.screenCount=1;
		details8.screenNo=1;
		details8.Date=new DateManagement();
		moviedetailsObject.add(details8);
		MovieDetails details9=new MovieDetails();
		details9.movie="Paddington";
		details9.language="English";
		details9.district="chennai";
		details9.theatre="PPP";
		details9.screenCount=1;
		details9.screenNo=1;
		details9.Date=new DateManagement();
		moviedetailsObject.add(details9);
		MovieDetails details10=new MovieDetails();
		details10.movie="The Lion King";
		details10.language="English";
		details10.district="chennai";
		details10.theatre="swiz cinemas";
		details10.screenCount=1;
		details10.screenNo=1;
		details10.Date=new DateManagement();
		moviedetailsObject.add(details10);
	}
}
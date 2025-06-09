package ticketmanager;
import java.util.ArrayList;
public class SeatingArrangement {
	Seat seatsList[][]=new Seat[9][9];
	{
		for(int i=0;i<seatsList.length;i++) {
			for(int j=0;j<seatsList[0].length;j++) {
				seatsList[i][j]=new Seat();
				String position =new String();
				position+=(i+1);
				position+=(j+1);
				seatsList[i][j].bookStatus=false;
				seatsList[i][j].seatNo=position;
			}
		}
	}
}

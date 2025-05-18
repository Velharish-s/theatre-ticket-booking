package Ticket;

public class PrintSeat {
	static void print(Seats obj) {
		String h[][]=obj.seat;
		for(int i=0;i<h.length;i++) {
			for(int j=0;j<h[0].length;j++) {
				System.out.print(h[i][j]+" ");
			}System.out.println();
		}
	}
}

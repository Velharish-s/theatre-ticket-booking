package ticketmanager;
import java.util.*;
import java.util.regex.Pattern;
public class InputCentre {
	static Scanner scanner=new Scanner(System.in);
	static final Pattern NAME_PATTERN=Pattern.compile("[a-bA-Z]+");
	static int integerGetter() {
		int g=0;
		try {
			System.out.print("Enter:");
			g=scanner.nextInt();
			return g;
		}catch(Exception e){
			scanner.nextLine();
			System.out.println("Invalid!");
			return integerGetter();
		}
	}
}

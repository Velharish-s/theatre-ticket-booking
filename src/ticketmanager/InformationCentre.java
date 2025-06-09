package ticketmanager;
import java.util.*;
import java.sql.*;
public class InformationCentre {
	String name;
	int age;
	String mailId;
	String password;
	ArrayList<TicketBookData> bookings=new ArrayList<>();
}
class InformationSet{
	static String url="jdbc:mysql://localhost:3306/ticketBooking";
	static String userName="root";
	static String password="8838964688";
	static ArrayList<InformationCentre> details=new ArrayList<>();
	static Scanner scanner=new Scanner(System.in);
	static void intialAdminIN(){
		InformationCentre personDetail=new InformationCentre();
		personDetail.name="kiruba";
		personDetail.age=25;
		personDetail.mailId="kiruba2000@gmail.com";
		personDetail.password="Kiruba2@00";
		details.add(personDetail);
		//sql connection 
		Connection connect=null;
		try {
			connect=DriverManager.getConnection(url, userName, password);
			PreparedStatement st=connect.prepareStatement("insert into log(userName, currentpassword, age, email, QA) values(?,?,?,?,?)");
			//st.setInt(1, 1);
			st.setString(1,personDetail.name);
			st.setString(2,personDetail.password);
			st.setInt(3, personDetail.age);
			st.setString(4,personDetail.mailId);
			st.setString(5, "god");
			st.executeUpdate();
		} catch (SQLException e) {
			//System.out.println("error from data base connection:"+e);
		}finally {
			if(connect!=null) {
				try {
					connect.close();
				} catch (SQLException e) {
					System.out.println("error in close!");
				}
			}
		}
	}
	static void informationSetter() {
		InformationCentre personDetail=new InformationCentre();
		System.out.print("Enter Name: ");
		personDetail.name=scanner.nextLine();
		System.out.println("age ");
		personDetail.age=InputCentre.integerGetter();
		if(personDetail.age<=10) {
			System.out.println("Kids not allowed to book!");
			Display.display1();
		}
		personDetail.mailId=Log.mailChecker();
		if(Log.idChecker(personDetail.mailId,details,url,userName,password)) {
			System.out.print("mail Id is Already get signup");
			System.out.println();
			informationSetter();
		}
		personDetail.password=Log.passwordGetter();
		details.add(personDetail);
		Connection connect=null;
		try {
			connect=DriverManager.getConnection(url, userName, password);
			PreparedStatement st=connect.prepareStatement("insert into log(userName, currentpassword, age, email, QA) values(?,?,?,?,?)");
			st.setString(1,personDetail.name);
			st.setString(2,personDetail.password);
			st.setInt(3, personDetail.age);
			st.setString(4,personDetail.mailId);
			st.setString(5, "god");
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println();
		}finally {
			if(connect!=null) {
				try {
					connect.close();
				} catch (SQLException e) {
					System.out.println("error in close!");
				}
			}
		}
	}
	static void adminSignin() {
			System.out.print("Enter mailId:");
			String mail=scanner.nextLine();
			System.out.print("Enter your Password:");
			String password=scanner.nextLine();
			for(int i=0;i<details.size();i++) {
				InformationCentre particularCustomer=details.get(i);
				if(mail.equals(particularCustomer.mailId)) {
					if(password.equals(particularCustomer.password)) {
						Display.adminOption();
						break;
					}
				}
			}
			System.out.println("Invalid!-Name or Password");
	}
}

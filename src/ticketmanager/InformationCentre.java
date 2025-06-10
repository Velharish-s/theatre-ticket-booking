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
		Connection connect=null;
		try {
			connect=DriverManager.getConnection(url, userName, password);
			PreparedStatement st=connect.prepareStatement("insert into log(userName, currentpassword, age, email, QA) values(?,?,?,?,?)");
			st.setString(1,"kiruba");
			st.setString(2,"Kiruba2@00");
			st.setInt(3, 25);
			st.setString(4,"kiruba2000@gmail.com");
			st.setString(5, "root");
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println();
		}finally {
			if(connect!=null) {
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
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
			String givenPassword=scanner.nextLine();
			boolean mailCheck=false,passwordCheck=false;
			try {
				Connection connect=DriverManager.getConnection(InformationSet.url, InformationSet.userName, InformationSet.password);
				Statement st=connect.createStatement();
				ResultSet result=st.executeQuery("select email from log");
				while(result.next()) {
					String originalMail=result.getString(1);
					if(originalMail.equals(mail)) {
						mailCheck=true;
						break;
					}
				}
				connect.close();
				if(mailCheck) {
					Connection connect2=DriverManager.getConnection(InformationSet.url, InformationSet.userName, InformationSet.password);
					PreparedStatement statement=connect2.prepareStatement("select currentpassword from log where email=?");
					statement.setString(1, mail);
					ResultSet result2=statement.executeQuery();
					while(result2.next()) {
						String originalPassword=result2.getString(1);
						if(originalPassword.equals(givenPassword)) {
							passwordCheck=true;
							break;
						}
					}
				}
				else {
					System.out.println("Given mail id is not valid");
				}

				if(mailCheck && passwordCheck) {
					Display.adminOption();
				}
				else {
					System.out.println("Given password id is not valid");
				}
			}catch(Exception e) {
				System.out.println();
			}
	}
}

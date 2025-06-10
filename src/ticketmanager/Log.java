package ticketmanager;

import java.util.*;
import java.util.regex.Pattern;
import java.sql.*;
public class Log {
	static final Pattern EMAIL_CHECK = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
	static String currentMailId="";
	static int currentIndex;
	static int passwordChanger=1001;
	static Scanner scan=new Scanner(System.in);
	static String passwordGetter() {
		while(true) {
			System.out.println("Password must contain a letter both upper and lower case\nmust hava a number\nmust have a special character\nminimum 8 characters");
			System.out.print("Enter Password:");
			String dupUserPassword=scan.nextLine();
			int smallLetter=0,capseLetter=0,digit=0,specialCharacters=0,space=0;
			if(dupUserPassword.length()<8) {
				System.out.println("size not enough!");
			}
			for(int i=0;i<dupUserPassword.length();i++) {
				if(Character.isDigit(dupUserPassword.charAt(i))) {digit++;}
				else if(dupUserPassword.charAt(i)>='a' && dupUserPassword.charAt(i)<='z') {smallLetter++;}
				else if(dupUserPassword.charAt(i)>='A' && dupUserPassword.charAt(i)<='Z') {capseLetter++;}
				else if(dupUserPassword.charAt(i)==' ') {space++;}
				else if(!Character.isLetterOrDigit(i)) {specialCharacters++;}
			}
			if( space==0 && smallLetter>=1 && capseLetter>=1 && digit>=1 && specialCharacters>=1 ) {
				return dupUserPassword;
			}
		}
	}
	static boolean idChecker(String givenMail,ArrayList<InformationCentre> information,String url,String userName,String password) {
		try {
			Connection connect=DriverManager.getConnection(url, userName, password);
			Statement st=connect.createStatement();
			ResultSet result=st.executeQuery("select email from log");
			while(result.next()) {
				if(result.getString(1).equals(givenMail)) {
					return true;
				}
			}
			return false;
		}catch(Exception e) {
			System.out.println();
		}
		
		for(int i=0;i<information.size();i++) {
			InformationCentre specificUser=information.get(i);
			if(givenMail.equals(specificUser.mailId)) {
				return true;
			}
		}
		return false;
	}
	static String mailChecker() {
		while(true) {
			System.out.print("Enter your mailId:");
			String givenMail=scan.nextLine();
			if(EMAIL_CHECK.matcher(givenMail).matches()) {
				return givenMail;
			}else {
				System.out.println("Invalid email");
			}
		}
	}
	static void signinDetail() {
		System.out.print("Enter mail_id:");
		String mail=scan.nextLine();
		String password=passwordGetter();
		signinCheckUp(mail,password,InformationSet.details);
	}
	static void signinCheckUp(String mail,String password,ArrayList<InformationCentre> userDetail) {
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
					if(originalPassword.equals(password)) {
						passwordCheck=true;
						break;
					}
				}
			}
			else {
				System.out.println("Given mail id is not valid");
			}

			if(mailCheck && passwordCheck) {
				Display.userDisplay();
			}
			else {
				System.out.println("Given password id is not valid");
			}
		}catch(Exception e) {
			System.out.println();
		}
	}
	static void passwordChanger() {
		System.out.println("Enter your mail id:");
		String mail=scan.nextLine();
		if(mail.equals(currentMailId)) {
			System.out.println("Wait...");
			try {
				Thread.sleep(10000);
				System.out.println("otp: "+passwordChanger);
			} catch (InterruptedException e) {
				System.out.println("otp: "+passwordChanger);
			}
		}
		System.out.println("Enter otp");
		if(scan.nextInt()==passwordChanger) {
			passwordChanger++;
			String newPassword=Log.passwordGetter();
			InformationSet.details.get(currentIndex).password=newPassword;
			System.out.println("Password changed");
		}
	}
}

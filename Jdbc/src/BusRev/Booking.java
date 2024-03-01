package BusRev;
import java.sql.SQLException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
public class Booking {
	//import java.sql.*;
	   static String Pname;
	   static int busNo;
	  static Date date;
	  
	  public Booking() {
		  Scanner in=new Scanner(System.in);
		  System.out.println("Enter your Name:");
		  Pname=in.next();
		  System.out.println("Enter Bus Number:");
		  busNo=in.nextInt();
		  System.out.println("Enter date:");
		  String s=in.next();
		  SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
		  try {
			date=sd.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  public static boolean isAvailable() throws SQLException {
		  BusData bd=new BusData();
		  int cap = bd.getCapacity(busNo);
		  //int cap=BusData.getCapacity(busNo);
		  BookingData bod=new BookingData();
		  int c=bod.getBookedCount(busNo,date);
		  return cap>c;
	  }
}

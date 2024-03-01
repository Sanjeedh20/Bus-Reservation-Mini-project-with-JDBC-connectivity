package BusRev;

import java.util.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner in=new Scanner(System.in);
		int op=1;
		BusData bd=new BusData();
		bd.displayBusInfo();
		while(op==1) {
			System.out.println("Enter 1 to book (or) 2 to exit");
			op=in.nextInt();
			if(op==1) {
				Booking b=new Booking();
				if(b.isAvailable()) {
					BookingData bod=new BookingData();
					bod.addBooking(b);
					System.out.println("Ticket is Booked sucessfully");
				}
				else {
					System.out.println("Sorry Try with different time or date");
				}
			}else {
				break;
			}
		}
	}

}

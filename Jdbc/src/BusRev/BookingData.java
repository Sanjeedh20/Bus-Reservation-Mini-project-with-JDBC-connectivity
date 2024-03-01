package BusRev;
import java.util.Date;
import java.sql.*;

public class BookingData {
public int getBookedCount(int busNo,Date date) throws SQLException{
		
		String query = "select count(Name) from booking where busNo=? and travel_Date=?";
		Connection con = BusConnect.connect();
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		pst.setInt(1, busNo);
		pst.setDate(2, sqldate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	public void addBooking(Booking booking) throws SQLException{
		String query = "Insert into booking values(?,?,?)";
		Connection con = BusConnect.connect();
		java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, booking.Pname);
		pst.setInt(2, booking.busNo);
		pst.setDate(3, sqldate);
		
		pst.executeUpdate();
		
	}
}

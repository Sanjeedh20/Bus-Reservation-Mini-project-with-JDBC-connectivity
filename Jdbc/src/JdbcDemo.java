import java.sql.*;
import java.util.*;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//		insertrecords();
//        readrecorde();
		Scanner in=new Scanner(System.in);
		//insertPst(in);
		//delete(in);
		//update(in);
		call();
	}
    public static void readrecorde() throws SQLException {
    	String url="jdbc:mysql://localhost:3306/demo";
        String user="root";
        String pass="pubg@123";
        String query="select*from student";
        Connection con=DriverManager.getConnection(url, user, pass);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        
        while(rs.next()) {
        	System.out.println("Id is "+rs.getInt(1));
        	System.out.println("Name is "+rs.getString(2));
        	System.out.println("Salary is "+rs.getFloat(3));
        	System.out.println();
        }
        con.close();
    }
    public static void insertrecords() throws SQLException{
    	String url="jdbc:mysql://localhost:3306/demo";
        String user="root";
        String pass="pubg@123";
        String query="insert into student(ename,Gpa) values('peaky',7.99)";
        Connection con=DriverManager.getConnection(url, user, pass);
        Statement st=con.createStatement();
        int rs=st.executeUpdate(query);
        System.out.println("No. of rows affected : "+rs);
        con.close();
    }
    public static void insertPst(Scanner in) throws SQLException{
    	//Scanner in=new Scanner(System.in);
    	String url="jdbc:mysql://localhost:3306/demo";
    	String user="root";
    	String pass="pubg@123";
    	int id=in.nextInt();
    	String name=in.next();
    	float gpa=in.nextFloat();
    	String query="insert into student(id,ename,Gpa) values(?,?,?)";
    	
    	Connection con=DriverManager.getConnection(url, user, pass);
    	PreparedStatement pr=con.prepareStatement(query);
    	pr.setInt(1, id);
    	pr.setString(2, name);
    	pr.setFloat(3, gpa);
    	int r=pr.executeUpdate();
    	System.out.println("No. of rows affected : "+r);
    	con.close();
    }
    public static void delete(Scanner in) throws SQLException{
    	String url="jdbc:mysql://localhost:3306/demo";
    	String name="root";
    	String pass="pubg@123";
    	int id=in.nextInt();
    	
    	Connection con=DriverManager.getConnection(url,name,pass);
    	String query="delete from student where id=?";
    	
    	PreparedStatement ps=con.prepareStatement(query);
    	ps.setInt(1, id);
    	
    	int r=ps.executeUpdate();
    	System.out.println("No. of rows affected : "+r);
    	con.close();
    }
    public static void update(Scanner in) throws SQLException{
    	String url="jdbc:mysql://localhost:3306/demo";
    	String name="root";
    	String pass="pubg@123";
    	int id=in.nextInt();
    	
    	Connection con=DriverManager.getConnection(url,name,pass);
    	String query="update student set ename='sanjeedh' where id=?";
    	PreparedStatement ps=con.prepareStatement(query);
    	
    	ps.setInt(1, id);
    	int r=ps.executeUpdate();
    	
    	System.out.println("No. of rows affected : "+r);
    	con.close();
    }
    public static void call() throws SQLException{
    	String url="jdbc:mysql://localhost:3306/demo";
    	String name="root";
    	String pass="pubg@123";
    	int i=3;
    	
    	Connection con=DriverManager.getConnection(url,name,pass);
    	CallableStatement cs=con.prepareCall("{call getCol2(?)}");
    	
    	cs.setInt(1, i);
    	ResultSet rs=cs.executeQuery();
    	
    	 while(rs.next()) {
         	System.out.println("Id is "+rs.getInt(1));
         	System.out.println("Name is "+rs.getString(2));
         	System.out.println("Gpa is "+rs.getFloat(3));
         	System.out.println();
         }
         con.close();
    }
}

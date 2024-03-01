package BusRev;

public class Bus {
   private int busNo;
   private boolean ac;
   private int capacity;
   
   public Bus(int busNo,boolean ac,int capacity) {
	   this.busNo=busNo;
	   this.ac=ac;
	   this.capacity=capacity;
   }
   
   public int getbusNo() {
	   return busNo;
   }
   public boolean getAc() {
	   return ac;
   }
   public int capacity() {
	   return capacity;
   }
   
   public void setbusNo(int busNo) {
	   this.busNo=busNo;
   }
   public void setcapacity(int capacity) {
	   this.capacity=capacity;
   }
   public void setAc(boolean ac) {
	   this.ac=ac;
   }
   
}

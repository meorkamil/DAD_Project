/**
 * 
 */
package controller.project2.com;

/**
 * @author Meor Muhammad Kamil Bin Meor Muhammad Sulaiman
 *
 */
public class Booking {
	
    private String Name, DateStart, DateEnd, Address, TelNo, CameramanName;
    private double TotalPrice;
    public String getName(){
        return Name;
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    
    public String getTelNo(){
        return TelNo;
    }
    
    public void setTelNo(String TelNo){
        this.TelNo = TelNo;
    }
    
    public String getDateStart(){
        return DateStart;
    }
    
    public void setDateStart(String DateStart){
        this.DateStart = DateStart;
    }
    
    public String getDateEnd(){
        return DateEnd;
    }
    
    public void setDateEnd(String DateEnd){
        this.DateEnd = DateEnd;
    }
    
    public String getAddress(){
        return Address;
    }
    
    public void setAddress(String Address){
        this.Address = Address;
    }
    
    public double getTotalPrice(){
        return TotalPrice;
    }
    public void setTotalPrice(double TotalPrice){
        this.TotalPrice = TotalPrice;
    }
    
    public String getCameramanName(){
        return CameramanName;
    }
    public void setCameramanName(String CameramanName){
        this.CameramanName = CameramanName;
    }
}

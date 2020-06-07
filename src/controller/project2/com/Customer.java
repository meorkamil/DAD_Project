package controller.project2.com;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @author Muhammad Adib Bin Noor Hazuki
 *
 */

public class Customer {
	
    private String Name, DateStart, DateEnd, Address, TelNo;


	/*
	 * public Customer(String Name, String Address, String TelNo, String DateStart,
	 * String DateEnd){ this.Name = Name; this.TelNo = TelNo; this.Address =
	 * Address; this.DateStart = DateStart; this.DateEnd = DateEnd; }
	 */
    
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
    
    //Find the different between two date
    public long showDaysBetween(){
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate startDateParse = LocalDate.parse( this.DateStart, formatter);
        LocalDate endDateParse = LocalDate.parse(this.DateEnd , formatter);

        //Total days between date
        long daysBetween = ChronoUnit.DAYS.between(startDateParse, endDateParse);

        //If the days between is 0 it will count as 1
        if(daysBetween == 0 ){
            int dayOne = 1;
            return dayOne;
        }
        return daysBetween;
    }
    
}
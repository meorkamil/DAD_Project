package controller.project2.com;


/**
 * 
 * @author Muhamad Aqif Danish Bin Mohamad Daud
 *
 */

public class Cameraman  {
	
    private String name;
    private double rate;
    private int CameramanNo;

 
    

	public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 20) {
            this.name = name.substring(0, 19);
        }
        else {
            this.name = name;
        }
    }

    public double getRate() {
        return rate;
    }
    public int getCameramanNo() {
        return CameramanNo;
    }
    
    public void setCameramanNo(int CameramanNo) {
        this.CameramanNo = CameramanNo;
    }
    public void setRate(double rate) {
        if (rate < 0) {
            return;
        }
        this.rate = rate;
    }


}

package controller.project2.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


import db.project2.com.DBConnector;




/**
 * @author Meor Muhammad Kamil Bin Meor Muhammad Sulaiman
 *
 */

public class ProjectController {

	private static final double Null = 0;
	
	// Select Cameraman
	public List<Cameraman> selectCameramans() throws SQLException, ClassNotFoundException{

		// SQL Statement
		String sql="select c.CameramanId, c.Name, c.Rate from Cameraman c";

		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;

		List<Cameraman> cameramans=new ArrayList<Cameraman>();

		try {
			// MySQL Connection
			conn=DBConnector.getConnection();
			stmt=conn.createStatement();

			// Execute statement
			rs=stmt.executeQuery(sql);

			// Wrap result in list
			while(rs.next()) {
				Cameraman cameraman=new Cameraman();
				cameraman.setCameramanNo(rs.getInt(1));
				cameraman.setName(rs.getString(2));
				cameraman.setRate(rs.getDouble(3));

				cameramans.add(cameraman);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Close all the objects
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
		return cameramans;
	}

	// Insert Cameraman
	public int insertCameraman(Cameraman cameraman) {

		Connection conn = null;
		PreparedStatement preparedStatement=null;
		int affectedRow=0;

		try {

			conn = DBConnector.getConnection();
			preparedStatement = conn.prepareStatement("insert into cameraman ( Name,Rate) VALUES (?,?)");
			preparedStatement.setString (1, cameraman.getName());	
			preparedStatement.setDouble (2, cameraman.getRate());
			affectedRow+=preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affectedRow;

	}

	// Get Cameraman Info
	public Cameraman getCameramanInfo(Cameraman cameraman) {

		Connection conn=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		Cameraman cameramanInfo=new Cameraman();

		try {

			conn=DBConnector.getConnection();
			preparedStatement=conn.prepareStatement("select p.CameramanId, p.Name, p.Rate from cameraman p where CameramanId=?");
			preparedStatement.setInt(1, cameraman.getCameramanNo());
			rs=preparedStatement.executeQuery();
			while(rs.next()) {
				cameramanInfo.setCameramanNo(rs.getInt(1));
				cameramanInfo.setName(rs.getString(2));
				cameramanInfo.setRate(rs.getDouble(3));

			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cameramanInfo;

	}

	// Update Cameraman
	public int updateCameraman(Cameraman cameraman) {

		Connection conn = null;
		PreparedStatement preparedStatement=null;
		int affectedRow=0;

		try {

			conn = DBConnector.getConnection();
			preparedStatement = conn.prepareStatement("update cameraman set Name=?, Rate=? where CameramanId=?");
			preparedStatement.setString (1, cameraman.getName());	
			preparedStatement.setDouble (2, cameraman.getRate());
			preparedStatement.setInt (3, cameraman.getCameramanNo());
			affectedRow+=preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affectedRow;

	}


	// Delete Cameraman
	public int deleteCameraman(Cameraman cameraman) {
		
		Connection conn = null;
		PreparedStatement preparedStatement=null;
		int affectedRow=0;

		try {

			conn = DBConnector.getConnection();
			preparedStatement = conn.prepareStatement("delete from cameraman where CameramanId=?");
			preparedStatement.setInt (1, cameraman.getCameramanNo());	
			affectedRow+=preparedStatement.executeUpdate();;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affectedRow;

	}


	// Get random element
	public int getRandomElement(List<Integer> list, int bound) 
	{ 
		// ThreadLocalRandom generate a int type number 
		return list.get(ThreadLocalRandom.current() 
				.nextInt(list.size()) 
				% bound); 
	} 


	// Add Booking
	public int addBooking(Customer customer) {

		Connection conn = null;
		PreparedStatement preparedStatement=null;
		int affectedRow=0;
		ResultSet rs=null;

		try {

			// Define projectController for random select
			ProjectController projectController = new ProjectController();

			// Cameraman List
			List<Cameraman> cameramans = selectCameramans();

			// List for random select
			List<Integer> list = new ArrayList<>(); 

			// Add to "list"
			for (Cameraman cameraman : cameramans) {
				list.add(cameraman.getCameramanNo());
			}

			//double rate = cameraman.getRate();
			// Define "list" size
			int boundIndex = list.size();

			// Assign CameramanNo
			int CameramanNo = projectController.getRandomElement(list, boundIndex);

			conn = DBConnector.getConnection();
			preparedStatement = conn.prepareStatement("select count(BookingId) as total from booking as b where b.DateStart >='"+ customer.getDateStart()+"' AND b.DateEnd <='"+customer.getDateEnd()+"' AND CameramanId="+CameramanNo+";");
			rs=preparedStatement.executeQuery();

			while(rs.next()) {

				int bookingNo =rs.getInt(1); 

				if(bookingNo > 0) {
					return affectedRow = 0;
				}
			}


			// MySql Connection and SQL Query
			preparedStatement = conn.prepareStatement("insert into booking ( CustomerName,Address,TelNo,CameramanId,TotalPrice,DateStart,DateEnd) VALUES (?,?,?,?,?,?,?);");
			preparedStatement.setString (1, customer.getName());	
			preparedStatement.setString (2, customer.getAddress());
			preparedStatement.setString (3, customer.getTelNo());
			preparedStatement.setInt (4, CameramanNo);
			preparedStatement.setDouble (5, getCameramanRate(CameramanNo));
			preparedStatement.setString (6, customer.getDateStart());
			preparedStatement.setString (7, customer.getDateEnd());
			affectedRow+=preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * try { return preparedStatement.executeUpdate(); } catch (SQLException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

		return affectedRow;
	}
	
	//Get cameramanRate
	public double getCameramanRate(int cameramanNo) {
		
		List<Cameraman> cameramans;
		
		try {
			cameramans = selectCameramans();
			for (Cameraman cameraman : cameramans) { 
				if(cameraman.getCameramanNo() == cameramanNo ) {

					double rate = cameraman.getRate() ;
					return rate;
				} 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Null;

	}

	// View Booking
	public List<Booking> viewBooking() throws SQLException, ClassNotFoundException {

		Connection conn=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;

		// List receipt history
		List<Booking> bookings=new ArrayList<Booking>();

		try {

			conn=DBConnector.getConnection();
			
			preparedStatement=conn.prepareStatement("select b.CustomerName, b.Address, b.TelNo, c.Name, b.TotalPrice, b.DateStart, b.DateEnd from booking as b join cameraman as c on b.CameramanId=c.CameramanId");
			rs=preparedStatement.executeQuery();


			while(rs.next()) {
				Booking booking=new Booking();
				booking.setName(rs.getString(1));
				booking.setAddress(rs.getString(2));
				booking.setTelNo(rs.getString(3));
				booking.setCameramanName(rs.getString(4));
				booking.setTotalPrice(rs.getDouble(5));
				booking.setDateStart(rs.getString(6));
				booking.setDateEnd(rs.getString(7));


				bookings.add(booking);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookings;

	}



	// Search Booking
	public List<Booking> searchBooking(Customer customer) {

		Connection conn=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		List<Booking> bookings=new ArrayList<Booking>();

		try {

			conn=DBConnector.getConnection();
			preparedStatement=conn.prepareStatement("select b.CustomerName, b.Address, b.TelNo, c.Name, b.TotalPrice, b.DateStart, b.DateEnd from booking as b join cameraman as c on b.CameramanId=c.CameramanId where b.CustomerName like '%"+customer.getName()+"%'");
			rs=preparedStatement.executeQuery();
			while(rs.next()) {

				Booking booking=new Booking();
				booking.setName(rs.getString(1));
				booking.setAddress(rs.getString(2));
				booking.setTelNo(rs.getString(3));
				booking.setCameramanName(rs.getString(4));
				booking.setTotalPrice(rs.getDouble(5));
				booking.setDateStart(rs.getString(6));
				booking.setDateEnd(rs.getString(7));


				bookings.add(booking);

			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookings;

	}

	// Get BookingNo
	public int getBookingNo() {

		Connection conn=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		int bookingNo=0;

		try {

			conn=DBConnector.getConnection();
			
			preparedStatement=conn.prepareStatement("select BookingId from booking order by BookingId desc limit 1");
			rs=preparedStatement.executeQuery();

			while(rs.next()) {

				bookingNo=rs.getInt(1);

			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookingNo;
	}

	// View Booking Detail
	public List<Booking> viewBookingDetail(int bookingNo) {

		Connection conn=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;

		List<Booking> bookings=new ArrayList<Booking>();

		try {

			// Establish Connection
			conn=DBConnector.getConnection();

			// SQL Query
			preparedStatement = conn.prepareStatement("select b.CustomerName, b.Address, b.TelNo, c.Name, b.TotalPrice, b.DateStart, b.DateEnd from booking as b join cameraman as c on b.CameramanId=c.CameramanId where b.BookingId=?");
			preparedStatement.setInt (1, bookingNo);	

			// Execute statement
			rs=preparedStatement.executeQuery();

			// Wrap result in list
			while(rs.next()) {
				Booking booking=new Booking();
				booking.setName(rs.getString(1));
				booking.setAddress(rs.getString(2));
				booking.setTelNo(rs.getString(3));
				booking.setCameramanName(rs.getString(4));
				booking.setTotalPrice(rs.getDouble(5));
				booking.setDateStart(rs.getString(6));
				booking.setDateEnd(rs.getString(7));

				bookings.add(booking);

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return bookings;
	}


}

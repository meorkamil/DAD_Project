package servlet.project2.com;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.project2.com.Customer;
import controller.project2.com.ProjectController;

/**
 * Servlet implementation class AddBookingServlet
 */
/**
 * @author Meor Muhammad Kamil Bin Meor Muhammad Sulaiman
 *
 */
@WebServlet("/AddBookingServlet")
public class AddBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		

		String Name = request.getParameter("CustomerName");
		String Address = request.getParameter("Address");
		String TelNo = request.getParameter("TelNo");
		String DateStart = request.getParameter("DateStart");
		String DateEnd = request.getParameter("DateEnd");


		Customer newCustomer=new Customer();

		newCustomer.setName(Name);
		newCustomer.setAddress(Address);
		newCustomer.setTelNo(TelNo);
		newCustomer.setDateStart(DateStart);
		newCustomer.setDateEnd(DateEnd);


		ProjectController projectController=new ProjectController();
	

		if(projectController.addBooking(newCustomer)==1) {
			request.setAttribute("result", "Booking Successfully Added");
		}
		else {
			request.setAttribute("result", "Date already Booked");
		}

		//request.setAttribute("cameramans", projectController.selectCameramans());
		int bookingNo =  projectController.getBookingNo();
		request.setAttribute("bookings", projectController.viewBookingDetail(bookingNo));
		request.getRequestDispatcher("BookingDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

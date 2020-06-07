package servlet.project2.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.project2.com.Cameraman;
import controller.project2.com.Customer;
import controller.project2.com.ProjectController;

/**
 * Servlet implementation class SearchBookingServlet
 */


/**
 * @author Muhamad Aqif Danish Bin Mohamad Daud
 *
 */
@WebServlet("/SearchBookingServlet")
public class SearchBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ProjectController projectController=new ProjectController();
		Customer searchCustomer=new Customer();
		searchCustomer.setName(request.getParameter("CustomerName"));
		request.setAttribute("result", "");

		// Use request to return object to JSP 
		request.setAttribute("bookings", projectController.searchBooking(searchCustomer));

		// Forward object to deleteproduct.jsp
		request.getRequestDispatcher("SearchBooking.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package servlet.project2.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.project2.com.Cameraman;
import controller.project2.com.ProjectController;


/**
 * Servlet implementation class DeleteConfirmationServlet
 */
/**
 * @author Meor Muhammad Kamil Bin Meor Muhammad Sulaiman
 *
 */
@WebServlet("/DeleteConfirmationServlet")
public class DeleteConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteConfirmationServlet() {
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
		Cameraman viewCameraman=new Cameraman();
		viewCameraman.setCameramanNo(Integer.parseInt(request.getParameter("cameramanNo")));

		// Use request to return object to JSP 
		request.setAttribute("cameraman", projectController.getCameramanInfo(viewCameraman));

		// Forward object to deleteproduct.jsp
		request.getRequestDispatcher("DeleteCameraman.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

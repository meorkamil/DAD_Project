package servlet.project2.com;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.project2.com.Cameraman;
import controller.project2.com.ProjectController;


/**
 * Servlet implementation class UpdateCameramanServlet
 */
/**
 * @author Meor Muhammad Kamil Bin Meor Muhammad Sulaiman
 *
 */
@WebServlet("/UpdateCameramanServlet")
public class UpdateCameramanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCameramanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int CameramanNo = Integer.parseInt(request.getParameter("CameramanNo"));
		String Name = request.getParameter("Name");
		double Rate = Double.parseDouble(request.getParameter("Rate"));
		
		Cameraman updateCameraman=new Cameraman();
		updateCameraman.setCameramanNo(CameramanNo);
		updateCameraman.setName(Name);
		updateCameraman.setRate(Rate);
		
		ProjectController projectController=new ProjectController();
		
		if(projectController.updateCameraman(updateCameraman)==1) {
			request.setAttribute("result", "Cameraman Successfully Update");
		}
		else {
			request.setAttribute("result", "Fail to update Cameraman");
		}
		
		try {
			request.setAttribute("cameramans", projectController.selectCameramans());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("CameramanList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

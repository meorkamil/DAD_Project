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
 * Servlet implementation class DeleteCameramanServlet
 */

/**
 * @author Meor Muhammad Kamil Bin Meor Muhammad Sulaiman
 *
 */
@WebServlet("/DeleteCameramanServlet")
public class DeleteCameramanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCameramanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int cameramanno = Integer.parseInt(request.getParameter("cameramanNo"));
		String name = request.getParameter("Name");
		double rate = Double.parseDouble(request.getParameter("Rate"));
		
		Cameraman deleteCameraman =new Cameraman();
		deleteCameraman.setCameramanNo(cameramanno);
		deleteCameraman.setName(name);
		deleteCameraman.setRate(rate);
		
		ProjectController projectController =new ProjectController();
		
		if(projectController.deleteCameraman(deleteCameraman)==1) {
			request.setAttribute("result", "Cameraman Successfully Deleted");
		}
		else {
			request.setAttribute("result", "Fail to delete Cameraman");
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

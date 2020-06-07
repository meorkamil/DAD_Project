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
 * Servlet implementation class AddCameramanServlet
 */
/**
 * @author Meor Muhammad Kamil Bin Meor Muhammad Sulaiman
 *
 */
@WebServlet("/AddCameramanServlet")
public class AddCameramanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCameramanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//int productCode = Integer.parseInt(request.getParameter("productcode"));
		String Name = request.getParameter("Name");
		double Rate = Double.parseDouble(request.getParameter("Rate"));
		
		Cameraman newCameraman=new Cameraman();
		//newCameraman.setProductCode(productCode);
		newCameraman.setName(Name);
		newCameraman.setRate(Rate);
		
		ProjectController projectController=new ProjectController();
		
		if(projectController.insertCameraman(newCameraman)==1) {
			request.setAttribute("result", "Cameraman Successfully Added");
		}
		else {
			request.setAttribute("result", "Fail to add Cameraman");
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

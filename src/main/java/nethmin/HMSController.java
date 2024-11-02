package nethmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
  
  @WebServlet("/")
public class HMSController extends HttpServlet{
	  
	  HmsDao dao = new HmsDao();  //create object for check doctors 
	    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		   String act = req.getServletPath();
		   
		   switch(act) {
		   case "/loginDoctor":
			   System.out.println("Login Clicked"+act);
			   checkLogin(req,res);
			   break;
			   
		  
		   case "/dashboard":
			   showDashbaord(req,res);
			   break;
			   
		   case "/insertPatient":
			   insertPatient(req,res);
			   break;
			   
			   
		   }
	}
 
	private void insertPatient(HttpServletRequest req, HttpServletResponse res) throws IOException {
		   String name= req.getParameter("uname");
		   String email= req.getParameter("uemail");
		   int age=Integer.parseInt(req.getParameter("uage"));
		   String city= req.getParameter("ucity");
		   String gender= req.getParameter("ugender");
		   
		   Patient pt = new Patient(name,email,age,city,gender);
		
		   dao.addNewPatient(pt);
		   
		   System.out.println("Patient added");
		   res.sendRedirect("dashboard");
	}

	private void showDashbaord(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		  List<Patient> ptList = new ArrayList<>();
		  
		  ptList = dao.getAllPatients();
		  req.setAttribute("pts", ptList);
		  RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
		  rd.forward(req,res);
	}

	private void checkLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		 String un =req.getParameter("uname");
		 String up= req.getParameter("upass");
		 
		 System.out.println(un);
		 
		 if(dao.doctorCheck(un,up)) {
			System.out.println("login sucess");
			res.sendRedirect("dashboard");
		 }else {
			 System.out.println("Wrong credential");
			 res.sendRedirect("login.jsp");
		 }
		
	}

}

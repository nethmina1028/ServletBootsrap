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
import jakarta.servlet.http.HttpSession;
  
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
			   
		   case "/update":
			   showUpdateForm(req,res);
			   break;
			   
		   case "/updatePatient":
			   updatePatient(req,res);
			   break;
			   
		   case "/delete":
			    deletePatient(req,res);
			    break;
		  
		   case "/logout":
			   logoutDoctor(req,res);
			   break;
			 
		 
		  default:
			  showDashbaord(req,res);
		   break;
			   
		   }
	}
 
	private void logoutDoctor(HttpServletRequest req, HttpServletResponse res) throws IOException  {
		
		  HttpSession s = req.getSession();
		  s.removeAttribute("doctor");
		  s.invalidate();
		  
		  res.sendRedirect("index.jsp");
	}

	private void deletePatient(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		dao.deletePatient(id);
		
		System.out.print("User deleted");
		res.sendRedirect("dashboard");
		
	}

	private void updatePatient(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int id =Integer.parseInt(req.getParameter("uid"));
		String name = req.getParameter("uname");
		String email =req.getParameter("uemail");
		int age =Integer.parseInt(req.getParameter("uage"));
		String city = req.getParameter("ucity");
		String gender =req.getParameter("ugender");
		
		Patient updatedPatient = new Patient(id,name,email,age,city,gender);
		boolean check=dao.updateOldPatient(updatedPatient);
		
		if(check) {
			res.sendRedirect("dashboard");
		}else {
			System.out.println("Failed to update");
		}
	}

	private void showUpdateForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 int id=Integer.parseInt(req.getParameter("id"));
		 
		 Patient oldPatient =dao.selectOldPatient(id);
		 
		 RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
		 req.setAttribute("pt",oldPatient);
		 rd.forward(req, res);
		 
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
			 
			 //Session
			 
			 HttpSession session= req.getSession();
			 session.setAttribute("doctor", un);
			 
			System.out.println("login sucess");
			res.sendRedirect("dashboard");
			
			
		 }else {
			 System.out.println("Wrong credential");
			 res.sendRedirect("login.jsp");
		 }
		
	}

}

package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/user")
public class UserLoginServlet extends HttpServlet{
	@Override
  protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  UserBean ub=new UserLoginDAO().login(req);
	  if(ub==null) {
		  pw.println("Invalid Login Process...<br>");
		  req.getRequestDispatcher("UserLogin.html").include(req, res);
	  }else {
		  HttpSession hs=req.getSession();
		  hs.setAttribute("ub", ub);
		  pw.println("Welcome User :"+ub.getfName()+"<br>");
		  req.getRequestDispatcher("link2.html").include(req, res);
	  }
  }
}

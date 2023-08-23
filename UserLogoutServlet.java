package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/userlogout")
public class UserLogoutServlet extends HttpServlet{
  protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  HttpSession hs=req.getSession(false);
	  if(hs==null) {
		  pw.println("Session Expired...<br>");
	  }else {
		  hs.removeAttribute("ub");
		  hs.invalidate();
		  pw.println("User Logged Out Seccessfully...<br>");
	  }
	  req.getRequestDispatcher("UserLogin.html").include(req, res);
  }
}

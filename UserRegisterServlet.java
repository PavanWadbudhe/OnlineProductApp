package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet{
	@Override
  protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  UserBean ub=new UserBean();
	  ub.setuName(req.getParameter("uname"));
	  ub.setpWord(req.getParameter("pword"));
	  ub.setfName(req.getParameter("fname"));
	  ub.setlName(req.getParameter("lname"));
	  ub.setAddr(req.getParameter("addr"));
	  ub.setmId(req.getParameter("mid"));
	  ub.setPhNo(Long.parseLong(req.getParameter("phno")));
	  int k=new UserRegisterDAO().register(ub);
	  if(k>0) {
		  pw.println("User Registered Successfully...");
	  }
	  RequestDispatcher rd=req.getRequestDispatcher("UserLogin.html");
	  rd.include(req, res);
  }
}

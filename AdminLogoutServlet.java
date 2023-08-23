package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class AdminLogoutServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
    	PrintWriter pw=res.getWriter();
    	res.setContentType("text/html");
    	HttpSession hs=req.getSession(false);
    	if(hs==null) {
    		pw.println("Session expired...<br>");
    	}else {
    		hs.removeAttribute("ab");
    		hs.removeAttribute("al");
    		hs.invalidate();
    		pw.println("logged out Successfully...<br>");
    	}
    	RequestDispatcher rd=req.getRequestDispatcher("home.html");
    	rd.include(req, res);
    }
}

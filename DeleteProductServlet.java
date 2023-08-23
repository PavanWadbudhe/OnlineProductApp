package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet{
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
    	PrintWriter pw=res.getWriter();
    	res.setContentType("text/html");
    	HttpSession hs=req.getSession(false);
    	if(hs==null) {
    		pw.println("Session Expired...<br>");
    		RequestDispatcher rd=req.getRequestDispatcher("home.html");
    		rd.include(req, res);
    	}else {
    		AdminBean ab=(AdminBean)hs.getAttribute("ab");
    		pw.println("Page belongs to :"+ab.getfName()+"<br>");
    		String code=req.getParameter("pcode");
    		ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
    		al.forEach((k)->{
    			if(code.equals(k.getCode())) {
    				int z=new DeleteProductDAO().delete(k);
    				if(z>0) {
    					pw.println("Product Deleted Successfully...<br>");
    				}
    			}
    		});
    		RequestDispatcher rd=req.getRequestDispatcher("link1.html");
    		rd.include(req, res);
    	}
    }
}

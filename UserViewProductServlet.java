package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/userview")
public class UserViewProductServlet extends HttpServlet{
	@Override
  protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  HttpSession hs=req.getSession(false);
	  if(hs==null) {
		  pw.println("Session Expired...");
		  req.getRequestDispatcher("UserLogin.html").include(req, res);
	  }else {
		  UserBean ub= (UserBean)hs.getAttribute("ub");
		  pw.println("Page belongs to :"+ub.getfName()+"<br>");	
		  ArrayList<ProductBean> al=new ViewProductsDAO().retrieve();
		  hs.setAttribute("al", al);
		  if(al.size()==0) {
			  pw.println("Product not Available...<br>");
		  }else {
			  		  
			  al.forEach((k)->{
				  pw.println(k.getCode()+"&nbsp&nbsp&nbsp"+
			                 k.getName()+"&nbsp&nbsp&nbsp"+
						     k.getPrice()+"&nbsp&nbsp&nbsp"+
			                 k.getQty()+"&nbsp&nbsp&nbsp"+
						     "<a href='buy?code="+k.getCode()+"'>Buy</a><br>");
			  });
			  pw.println("<a href='userlogout'>Logout</a>");
		  }
	  }
   }
}

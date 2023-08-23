package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet{
	@Override
  protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  HttpSession hs=req.getSession(false);
	  if(hs==null) {
		  pw.println("Session Expired...<br>");
		  req.getRequestDispatcher("UserLogin.html").include(req, res);
	  }else {
		  String code=req.getParameter("code");
		  @SuppressWarnings("unchecked")
		ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("al");
		  al.forEach((k)->{
			  if(code.equals(k.getCode())) {
				  ProductSubsDAO psd=new ProductSubsDAO();
				  int a=psd.update(req);
				  if(a>0) {
					  pw.println("Total Price :"+k.getPrice()+"<br>");
					  pw.println("Product Buyed Successfully...<br>");
				  }
				  pw.println("<a href='link2.html'>Back</a>");
			  }
		  });
	  }
  }
}

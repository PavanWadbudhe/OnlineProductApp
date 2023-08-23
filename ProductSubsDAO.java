package test;
import java.sql.*;
import javax.servlet.http.*;
public class ProductSubsDAO {
	public int a=0;
  public int update(HttpServletRequest req) {
	  try {
		  Connection con=DBConnection.getCon();
		  PreparedStatement ps=con.prepareStatement("update Products52 set qty=qty-1 where Id=?");
		  ps.setString(1, req.getParameter("code"));
		  a=ps.executeUpdate();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  return a;
  }
}

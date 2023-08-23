package test;
import java.sql.*;
public class DeleteProductDAO {
   public int z=0;
   public int delete(ProductBean pb) {
	   try {
		   Connection con=DBConnection.getCon();
		   PreparedStatement ps=con.prepareStatement("delete from Products52 where id=?");
		   ps.setString(1, pb.getCode());
		   z=ps.executeUpdate();
	   }catch(Exception e) {e.printStackTrace();}
	   return z;
   }
}

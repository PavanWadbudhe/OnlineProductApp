package test;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebListener
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener{
   public void sessionCreated(HttpSessionEvent hse) {
	   System.out.println("Session created...");
   }
   public void sessionDestroyed(HttpSessionEvent hse) {
	   System.out.println("Session destroyed...");
   }
   public void attributeAdded(HttpSessionBindingEvent hsae) {
	   System.out.println("Attribute added to HttpSession...");
   }
   public void attributeRemoved(HttpSessionBindingEvent hsae) {
	   System.out.println("Attribute removed from HttpSession...");
   }
}

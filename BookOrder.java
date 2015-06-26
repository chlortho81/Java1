// Ex 19.03
// Using cookies. 
// Add book price and order option to example 19.9 - 19.11
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class BookOrder extends HttpServlet {
   private String names[] = { "C", "C++", "Java",
                        "Visual Basic 6" };

   public void doPost( HttpServletRequest request,
                  HttpServletResponse response )
      throws ServletException, IOException
   {
      PrintWriter output;
      String language = request.getParameter( "lang" );

      String c = request.getParameter( "C" );
      String cpp = request.getParameter( "C++" );
      String java = request.getParameter( "Java" );
      String vb6 =  request.getParameter( "VB6" );
      
      response.setContentType( "text/html" );
      output = response.getWriter();       

      double total = 0.0;

      // send HTML page to client
      output.println( "<HTML><HEAD><TITLE>" );
      output.println( "Order Confirmation" );
      output.println( "</TITLE></HEAD><BODY>" );
      output.println( "<P>You ordered:<BR>" );
      
      if ( c != null )
        total += orderC( output );

      if ( java != null )
        total += orderJava( output );

      if ( cpp != null )
        total += orderCpp( output );

      if ( vb6 != null )
        total += orderVB6( output );
      
      if ( total == 0.0 )
        output.println( "No Books !<BR>" );
      else
        output.println( "Your total amount due is " + 
                    String.valueOf(total) + "!<BR>" );
            
      output.println( "<P>" );
      output.println( "</BODY></HTML>" );
      output.close();   // close stream
   }

   private double orderC( PrintWriter output )
   {
      output.println( "C How to Program for $61US <BR>" );
      return 61.00;
   }

   private double orderCpp( PrintWriter output )
   {
      output.println( "C++ How to Program for $61US <BR>" );
      return 61.00;
   }

   private double orderJava( PrintWriter output )
   {
      output.println( "Java How to Program for $61US <BR>" );
      return 61.00;
   }

   private double orderVB6( PrintWriter output )
   {
      output.println( "Visual Basic 6 How to Program for $61US <BR>" );
      return 49.99;
   }
}

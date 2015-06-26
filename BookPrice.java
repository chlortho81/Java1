// Ex 19.03
// Using cookies. 
// Add book price and order option to example 19.9 - 19.11
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class BookPrice extends HttpServlet {
   private String names[] = { "C", "C++", "Java", "Visual Basic 6" };
   private String shortName[] = { "C", "C++", "Java", "VB6" };
   private String isbn[] = { "0-13-226119-7", "0-13-528910-6",
                             "0-13-012507-5", "0-13-528910-6" };

   private String price[] = { "$61 US", "$61 US", "$61 US", "$49.99 US" };

   public void doPost( HttpServletRequest request,
                       HttpServletResponse response )
      throws ServletException, IOException
   {
      String language = request.getParameter( "lang" );
      Cookie c = new Cookie( language, getISBN( language ) );

      response.addCookie( c );  // must precede getWriter   
      response.setContentType( "text/html" );
      PrintWriter output = response.getWriter();         

      // send HTML page to client
      output.println( "<HTML><HEAD><TITLE>" );
      output.println( "Cookies" );
      output.println( "</TITLE></HEAD><BODY>" );
      output.println( "<P>Welcome to Cookies!<BR>" );
      output.println( "<P>" );
      output.println( language );
      output.println( " is a great language." );
      output.println( "</BODY></HTML>" );
      output.close();    // close stream
   }

   public void doGet( HttpServletRequest request,
                      HttpServletResponse response )
      throws ServletException, IOException
   {
      PrintWriter output;
      Cookie cookies[];
      
      cookies = request.getCookies(); // get client's cookies

      response.setContentType( "text/html" ); 
      output = response.getWriter();

      output.println( "<HTML><HEAD><TITLE>" );
      output.println( "Book Order" );
      output.println( "</TITLE></HEAD><BODY>" );

      if ( cookies != null ) {
         output.println( "<H1>Recommendations</H1>" );

         output.println( "<BODY>" );
         output.println( 
            "<FORM ACTION=\"http://localhost:8080/servlet/BookOrder\"" );
         output.println( "METHOD=\"POST\">" );

         // get the name of each cookie
         for ( int i = 0; i < cookies.length; i++ ) {
            if ( bookName( cookies[ i ].getName() ) ) {
               output.println( cookies[ i ].getName() + " How to Program. " +
                                "ISBN#: " + cookies[ i ].getValue() + " <BR>" );
               output.println( "      <INPUT TYPE=CHECKBOX NAME=" +  
                  getShortName( cookies[ i ].getName() ) + 
                     " VALUE=" + getShortName( cookies[ i ].getName() ) + "> " );
               output.println(" Buy it now for " + 
                  getPrice( cookies[ i ].getName() ) +  "!<BR>" );
            }
         }

         output.println( "<INPUT TYPE=SUBMIT Value=\"Submit\">" );
         output.println( "</FORM>" );

      } 
      else {
         output.println( "<H1>No Recommendations</H1>" );
         output.println( "You did not select a language or" );
         output.println( "the cookies have expired." );
      }

      output.println( "</BODY></HTML>" );
      output.close();    // close stream
   }

   // Determine if the cookie name is a book name.
   // If not, we aren't interested in it.
   private boolean bookName( String s )
   {
      for ( int i = 0; i < names.length; ++i )
         if ( s.equals( names[ i ] ))
            return true;

      return false;
   }

   private String getShortName( String lang )
   {
      for ( int i = 0; i < names.length; ++i )
         if ( lang.equals( names[ i ] ) )
            return shortName[ i ];
        
      return "";  // no matching string found
   }

   private String getPrice( String lang )
   {
      for ( int i = 0; i < names.length; ++i )
         if ( lang.equals( names[ i ] ) )
            return price[ i ];
        
      return "";  // no matching string found
   }


   private String getISBN( String lang )
   {
      for ( int i = 0; i < names.length; ++i )
         if ( lang.equals( names[ i ] ) )
            return isbn[ i ];

      return "";  // no matching string found
   }
}

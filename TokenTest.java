// Fig. 8.20: TokenTest.java
// Testing the StringTokenizer class of the java.util package
import java.applet.Applet;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class TokenTest extends Applet
             implements ActionListener {
   // GUI components
   Label prompt;
   TextField input;
   TextArea output;

   public void init()
   {
      prompt = new Label( "Enter a sentence and press Enter" );
      input = new TextField( 50 );
      input.addActionListener( this );
      output = new TextArea( 10, 30 );
      output.setEditable( false );
      add( prompt );
      add( input );
      add( output );
   }

   public void actionPerformed( ActionEvent e )
   {      
      String stringToTokenize = e.getActionCommand();
      StringTokenizer tokens =
         new StringTokenizer( stringToTokenize );

      output.setText( "" );

      output.append( "Number of elements: " +
         tokens.countTokens() + "\nThe tokens are:\n" );

      while ( tokens.hasMoreTokens() )
         output.append( tokens.nextToken() + "\n" );
   }
}


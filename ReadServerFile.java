// Fig. 16.2: ReadServerFile.java
// This program uses a URL connection to read a file
// on the server.
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.applet.Applet;

public class ReadServerFile extends Applet
             implements ActionListener {
   private TextField enter;
   private TextArea contents;

   public void init()
   {
      setLayout( new BorderLayout() );

      enter = new TextField( "Enter file URL here" );
      enter.addActionListener( this );
      add( enter, BorderLayout.NORTH );

      contents = new TextArea( "", 0, 0,
                     TextArea.SCROLLBARS_VERTICAL_ONLY );
      add( contents, BorderLayout.CENTER );
   }

   public void actionPerformed( ActionEvent e )
   {
      URL url;
      BufferedReader input;
      String line;
      StringBuffer buffer = new StringBuffer();
      String location = e.getActionCommand();

      try {
         url = new URL( location );
         input = new BufferedReader(
            new InputStreamReader( url.openStream() ) );
         contents.setText( "Reading file..." );

         while ( ( line = input.readLine() ) != null ) 
            buffer.append( line ).append( '\n' );

         contents.setText( buffer.toString() );
         input.close();
      }
      catch ( MalformedURLException mal ) {
         contents.setText( "Invalid URL format." );
      }
      catch ( IOException io ) {
         contents.setText( io.toString() );
      }
      catch ( Exception ex ) {
         contents.setText( "This browser only allows " +
            "opening a file on the applet's server" );
      }
   }
}


// This program reads a file sequentially and displays each
// record in text fields.
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class ReadPayrollFile extends Frame
             implements ActionListener {

 

   private TextField RecNumberField,  NameField,
                      SocSecField, HoursField,RateField;


  

   private Button next,   // get next record in file
                  done;   // quit program

   // Application other pieces
   private DataInputStream input;

   // Constructor -- initialize the Frame 
   public ReadPayrollFile()
   {
      super( "Read Client File" );

      // Open the file
      try {
         input = new DataInputStream(
                     new FileInputStream( "payroll.dat" ) );
      }
      catch ( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }      

      setSize( 300, 150 );
      setLayout( new GridLayout( 6, 2 ) );
    

   




               // create the components of the Frame
      add( new Label( "Account Number" ) );
      RecNumberField = new TextField();
            RecNumberField.setEditable( false );
      add( RecNumberField );

      add( new Label( "Name" ) );
       NameField = new TextField( 20 );
         NameField.setEditable( false );
      add(  NameField );      

      add( new Label( "SocSec Number" ) );
       SocSecField = new TextField( 20 ); 
         SocSecField.setEditable( false );      
       add(SocSecField );

      add( new Label( "Hours" ) );
      HoursField = new TextField( 20 );
            HoursField.setEditable( false );
      add( HoursField );

      add( new Label( "Rate" ) );
      RateField = new TextField( 20 );
      RateField.setEditable( false );
      add( RateField );

      next = new Button( "Next" );
      next.addActionListener( this );
      add( next );      

      done = new Button( "Done" );
      done.addActionListener( this );
      add( done );       

      setVisible( true );  
   }

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == next )
         readRecord();
      else
         closeFile();
   }

   public void readRecord()
   {
      int recnumber;
      String name, socsec;
      double h,r;

      // input the values from the file
      try {
         recnumber = input.readInt();
         name = input.readUTF();
         socsec = input.readUTF();
         h = input.readDouble();
         r=input.readDouble();
 
         RecNumberField.setText( String.valueOf( recnumber ) );
         NameField.setText( name );
         SocSecField.setText( socsec );
         HoursField.setText( String.valueOf( h ) );
            RateField.setText( String.valueOf( r ) );

      }
      catch ( EOFException eof ) {
         closeFile();
      }
      catch ( IOException e ) {
         System.err.println( "Error during read from file\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }

   private void closeFile()
   {
      try {
         input.close();
         System.exit( 0 );
      }
      catch ( IOException e ) {
         System.err.println( "Error closing file\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }

   public static void main( String args[] )
   {
      new ReadPayrollFile();
   }
}


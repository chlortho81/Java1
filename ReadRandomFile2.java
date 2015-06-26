
// This program reads a random access file sequentially and
// displays the contents one record at a time in text fields.
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class ReadRandomFile2 extends Frame 
             implements ActionListener {

   // TextFields to display account number, first name,
   // last name and balance.
   private TextField accountField, firstNameField,
                     lastNameField, balanceField, socsecField;

   private Button next,   // get next record in file
                  done;   // quit program

   // Application other pieces
   private RandomAccessFile input;  
   private Record data;

   // Constructor -- initialize the Frame
   public ReadRandomFile2()
   {
      super( "Read Client File" );

      // Open the file
      try {
         input = new RandomAccessFile( "credit.dat", "r" );
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }

      data = new Record();

      setSize( 300, 150 );
      setLayout( new GridLayout( 6, 2 ) );

      // create the components of the Frame
      add( new Label( "Account Number" ) );
      accountField = new TextField();
      accountField.setEditable( false );
      add( accountField );

      add( new Label( "First Name" ) );
      firstNameField = new TextField( 20 );
      firstNameField.setEditable( false );
      add( firstNameField );      

      add( new Label( "Last Name" ) );
      lastNameField = new TextField( 20 );
      lastNameField.setEditable( false );
      add( lastNameField );

      add( new Label( "Balance" ) );
      balanceField = new TextField( 20 );
      balanceField.setEditable( false );
      add( balanceField );
	  
	     add( new Label( "Socsec" ) );
      socsecField = new TextField( 20 );
	   socsecField.setEditable( false );
      add( socsecField );
	  
	  
	  
	  
	  

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
      DecimalFormat twoDigits = new DecimalFormat( "0.00" );

      // read a record and display
      try {
         do {
            data.read( input );
         } while ( data.getAccount() == 0 );

         accountField.setText(
            String.valueOf( data.getAccount() ) );
         firstNameField.setText( data.getFirstName() );
         lastNameField.setText( data.getLastName() );
         balanceField.setText(   String.valueOf(     twoDigits.format  ( data.getBalance()   )   )   );
		 
		 
		  socsecField.setText( data.getSocsec() );
		 
		 
		 
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
   
   // Instantiate a ReadRandomFile object and start the program
   public static void main( String args[] )
   {
      new ReadRandomFile2();
   }
}



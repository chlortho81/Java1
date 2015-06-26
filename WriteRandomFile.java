
// This program uses TextFields to get information from the
// user at the keyboard and writes the information to a
// random access file.
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class WriteRandomFile extends Frame 
             implements ActionListener {

   // TextFields where user enters account number, first name,
   // last name and balance.
   private TextField accountField, firstNameField,
                     lastNameField, balanceField,socsecField;

   private Button enter,  // send record to file
                  done;   // quit program

   // Application other pieces
   private RandomAccessFile output;  // file for output
   private Record data;

   // Constructor -- intialize the Frame 
   public WriteRandomFile()
   {
     super( "Write to random access file" );

      data = new Record();

      // Open the file
      try {
         output = new RandomAccessFile( "credit.dat", "rw" );
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }

      setSize( 300, 150 );
      setLayout( new GridLayout( 6, 2 ) );
          setFont(new Font("SansSerif",Font.BOLD,10));  
      // create the components of the Frame
      add( new Label( "Account Number" ) );
      accountField = new TextField();
      add( accountField );

      add( new Label( "First Name" ) );
      firstNameField = new TextField( 20 );
      add( firstNameField );      

      add( new Label( "Last Name" ) );
      lastNameField = new TextField( 20 );
      add( lastNameField );

      add( new Label( "Balance" ) );
      balanceField = new TextField( 20 );
      add( balanceField );
	  
	  
	   add( new Label( "Socsec" ) );
      socsecField = new TextField( 20 );
      add( socsecField );
	  
	  
	  
	  
	  

      enter = new Button( "Enter" );
      enter.addActionListener( this );
      add( enter );      

      done = new Button( "Done" );
      done.addActionListener( this );
      add( done );       

      setVisible( true );  
   }

   public void addRecord()
   {
      int accountNumber = 0;
      Double d;

      if ( ! accountField.getText().equals( "" ) ) {

         // output the values to the file
         try {
            accountNumber =
               Integer.parseInt( accountField.getText() );

            if ( accountNumber > 0 && accountNumber <= 100 ) {
               data.setAccount( accountNumber );
               data.setFirstName( firstNameField.getText() );
               data.setLastName( lastNameField.getText() );
               d = new Double ( balanceField.getText() );
               data.setBalance( d.doubleValue() );
			   
			   
			   
			   data.setSocsec( socsecField.getText() );
			   
			   
			   
			   
               output.seek(
                  (long) ( accountNumber-1 ) * Record.size() );
               data.write( output );
            }

            // clear the TextFields
            accountField.setText( "" );
            firstNameField.setText( "" );
            lastNameField.setText( "" );
            balanceField.setText( "" );
			socsecField.setText("");
         }
         catch ( NumberFormatException nfe ) {
            System.err.println(
               "You must enter an integer account number" );
         }
         catch ( IOException io ) {
            System.err.println(
               "Error during write to file\n" +
               io.toString() );
            System.exit( 1 );
         }
      }
   }

   public void actionPerformed( ActionEvent e )
   {
     if ( e.getSource() == enter ) addRecord();

      if ( e.getSource() == done ) {
         try {
            output.close();
         }
         catch ( IOException io ) {
            System.err.println( "File not closed properly\n" +
                                io.toString() );
								 System.exit( 1 );
         }

         System.exit( 0 );
      }
   }
   
   // Instantiate a WriteRandomFile object and start the program
   public static void main( String args[] )
   {
   
        new WriteRandomFile();
   }
}









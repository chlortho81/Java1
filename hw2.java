// add fields for a long, a float and for
// extra credit a boolean.
// make sure you change the size of your grid
// and leave one line for the button.


// Fig. 15.4: CreateSequentialFile.java
// This program uses TextFields to get information from the
// user at the keyboard and writes the information to a 
// sequential file.
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class CreateSequentialFile extends Frame
             implements ActionListener {

   // TextFields where user enters account number, first name,
   // last name and balance.
   private TextField accountField, firstNameField,
                     lastNameField, balanceField;

   private Button enter,  // send record to file
                  done;   // quit program

   // Application other pieces
   private DataOutputStream output;  

   public CreateSequentialFile()
   {
      super( "Create Client File" );

      // Open the file
      try {
         output = new DataOutputStream(
                      new FileOutputStream( "client.dat" ) );
      }
      catch ( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }      

      setSize( 300, 150 );
      setLayout( new GridLayout( 5, 2 ) );

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

            if ( accountNumber > 0 ) {
               output.writeInt( accountNumber );
               output.writeUTF( firstNameField.getText() );
               output.writeUTF( lastNameField.getText() );
               d = new Double ( balanceField.getText() );
               output.writeDouble( d.doubleValue() );
            }

            // clear the TextFields
            accountField.setText( "" );
            firstNameField.setText( "" );
            lastNameField.setText( "" );
            balanceField.setText( "" );
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
      addRecord();

      if ( e.getSource() == done ) {
         try {
            output.close();
         }
         catch ( IOException io ) {
            System.err.println( "File not closed properly\n" +
                                io.toString() );
         }

         System.exit( 0 );
      }
   }

   public static void main( String args[] )
   {
      new CreateSequentialFile();
   }
}



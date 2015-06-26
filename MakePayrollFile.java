
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class MakePayrollFile extends Frame
             implements ActionListener {

 
 
   private TextField RecNumberField,  NameField,
                      SocSecField, HoursField,RateField;

   private Button enter,  // send record to file
                  done;   // quit program

   // Application other pieces
   private DataOutputStream output;  

   public MakePayrollFile()
   {
      super( "Create Client File one more time !!!!" );

      // Open the file
      try {
         output = new DataOutputStream(
                      new FileOutputStream( "payroll.dat" ) );
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
      add( RecNumberField );
	  

      add( new Label( "Name" ) );
       NameField = new TextField( 20 );
      add(  NameField );      

      add( new Label( "SocSec Number" ) );
       SocSecField = new TextField( 20 );
      add(  SocSecField );

      add( new Label( "Hours" ) );
      HoursField = new TextField( 20 );
      add( HoursField );

      add( new Label( "Rate" ) );
      RateField = new TextField( 20 );
      add( RateField );
	  
	  
	  

      enter = new Button( "Enter" );
   enter.addActionListener( this );
      add( enter );      

      done = new Button( "Done" );
     done.addActionListener( this );
      add( done );       
//show();
      setVisible( true );  
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
         }

         System.exit( 0 );
      }
   }




   public void addRecord()
   {
      int RecNumber = 0;
      Double h,r;
	  
	  
      if ( ! RecNumberField.getText().equals( "" ) ) {

         // output the values to the file
         try {
            RecNumber =
               Integer.parseInt( RecNumberField.getText() );

            if ( RecNumber > 0 ) {
               output.writeInt( RecNumber );
               output.writeUTF(  NameField.getText() );
               output.writeUTF(  SocSecField.getText() );
			   
			 			   
               h = new Double ( HoursField.getText() );
               output.writeDouble( h.doubleValue() );
               
			   r = new Double ( RateField.getText() );
               output.writeDouble( r.doubleValue() );

              }

            // clear the TextFields
            RecNumberField.setText( "" );
             NameField.setText( "" );
             SocSecField.setText( "" );
            HoursField.setText( "" );
               RateField.setText("");   
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


   public static void main( String args[] )
   {
      new MakePayrollFile();
   }
}













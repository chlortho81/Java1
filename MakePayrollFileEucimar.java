import javax.swing.*;
import java.io.*;
import java.awt.*; // this allows to make buttons and stuff
import java.awt.event.*; // what happens when u press a button



public class MakePayrollFileEucimar extends Frame    // frame allows the frames the windows 
             implements ActionListener, KeyListener {      // 

 
 // TEXFIELD CLASS it comes from AWT.*
 // its private the object cannot talk directly
 // u cant talk directly to the field
   private TextField RecNumberField,  NameField,
                      SocSecField, HoursField,RateField,GPAField;

   private Button enter,  // send record to file
                  done;   // quit program

   // Application other pieces
   private DataOutputStream output;  

   public MakePayrollFileEucimar() // constructor is public
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

      setSize( 500, 350 );
      setLayout( new GridLayout( 7, 2 ) );
	  

      // create the components of the Frame
      add( new Label( "Account Number" ) );
      RecNumberField = new TextField();
      add( RecNumberField );

      add( new Label( "Name" ) );
       NameField = new TextField(  );
      add(  NameField );      

      add( new Label( "SocSec Number" ) );
       SocSecField = new TextField(  );
      add(  SocSecField );

      add( new Label( "Hours" ) );
      HoursField = new TextField( );
      add( HoursField );

      add( new Label( "Rate" ) );
      RateField = new TextField(  );
      add( RateField );
	  
	  add( new Label( "GPA" ) );
      GPAField = new TextField(  );
      add( GPAField );

      
	  enter = new Button( "Enter" );
      enter.addActionListener( this );
	  enter.addKeyListener(this);
      add( enter );      	  

      done = new Button( "Done" );
     done.addActionListener( this );
	 done.addKeyListener(this);
      add( done );       
	  
	setVisible( true ); 
	RecNumberField.requestFocus();

   }

public void keyPressed(KeyEvent evt) {
 
       int code = evt.getKeyCode();  // which key was pressed

       if (evt.getSource() == enter && code == KeyEvent.VK_ENTER) 
               addRecord();
			   
		
		
		if (evt.getSource() == done && code == KeyEvent.VK_ENTER) {
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
			             
   } // end keyPressed()   
      
 
  public void keyTyped(KeyEvent e) {
    
    }
            
    
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
    
    }
     
    

   


   public void actionPerformed( ActionEvent e )
   {   
   
       if ( e.getSource() == enter) addRecord();

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


   public void addRecord()
   {
      int RecNumber = 0;
      Double h,r,gpa; // using the rapper class cuz they colletions dont accept primitives

      if ( ! RecNumberField.getText().equals( "" ) ) {

         // output the values to the file
         try {
            RecNumber =
               Integer.parseInt( RecNumberField.getText() );

            if ( RecNumber > 0 ) {
               output.writeInt( RecNumber );
               output.writeUTF(  NameField.getText() );
               output.writeUTF(  SocSecField.getText() );
			   //UTF UNIFORM TRANSFORM FORMAT
            
			h = new Double ( HoursField.getText() );
               output.writeDouble( h.doubleValue() );
              
			  r = new Double ( RateField.getText() );
               output.writeDouble( r.doubleValue() );
			   
			    gpa = new Double ( GPAField.getText() );
               output.writeDouble( gpa.doubleValue() );

              }

            // clear the TextFields
            RecNumberField.setText( "" );
             NameField.setText( "" );
             SocSecField.setText( "" );
            HoursField.setText( "" );
               RateField.setText("");   
			   GPAField.setText("");   
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
      new MakePayrollFileEucimar();
   }
}















import java.io.*;
import java.awt.*;
import java.awt.event.*;




import java.io.*;

 class Record {
   protected int  recnumber;
   protected String name;
   protected String socsec;
   protected double hours;
   protected double rate;

   
public void read( RandomAccessFile file ) throws IOException
   {
 recnumber = file.readInt();

      char fullname[] = new char[ 20 ];

      for ( int i = 0; i < fullname.length; i++ )
         fullname[ i ] = file.readChar();

      name = new String( fullname );

      char ssnum[] = new char[ 20 ];

      for ( int i = 0; i < ssnum.length; i++ )
         ssnum[ i ] = file.readChar();

      socsec = new String( ssnum );

      hours = file.readDouble();
      rate   = file.readDouble();
   }

  
   public void write( RandomAccessFile file ) throws IOException
   {
      StringBuffer buffer;

      file.writeInt( recnumber );

      if ( name != null ) 
         buffer = new StringBuffer( name );
      else 
         buffer = new StringBuffer( 20 );

      buffer.setLength( 20 );

      file.writeChars( buffer.toString() );

      if ( socsec != null ) 
         buffer = new StringBuffer( socsec );
      else 
         buffer = new StringBuffer( 20 );

      buffer.setLength( 20 );

      file.writeChars( buffer.toString() );

      file.writeDouble( hours );
       file.writeDouble( rate ); 
   }

   public void setrecnumber( int recnumber ) { this.recnumber=recnumber; }

   public int getrecnumber() { return recnumber; }

   public void setname( String name ) { this.name = name; }

   public String getname() { return name; }

   public void setsocsec( String socsec ) { this.socsec=socsec; }

   public String getsocsec() { return socsec; }

   public void sethours( double hours ) { this.hours=hours; }

   public double gethours() { return hours; }
 
   public void setrate( double rate ) { this.rate=rate; }

   public double getrate() { return rate; }

  
   public static int record_size() { return 100; }
}











public class LoadRandomPayrollFile extends Frame 
             implements ActionListener {


   private TextField recnumberField, nameField,
		     socsecField, hoursField,rateField;

   private Button add_record,  // send record to file
		  quit;   // quit program

   // Application other pieces
   private RandomAccessFile output;  // file for output

    Record new_entry;

 
   public  LoadRandomPayrollFile()
   {
      super( "Load the payroll file " );

      new_entry = new Record();

      // Open the file
      try {
         output = new RandomAccessFile( "payroll.dat", "rw" );
      }
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }

      setSize( 300, 150 );
      setLayout( new GridLayout( 6, 2 ) );

      setFont(new Font("SansSerif",Font.BOLD,12));  

      add( new Label( "Record Number" ) );
      recnumberField = new TextField();
      add( recnumberField );

      add( new Label( "Full Name" ) );
      nameField = new TextField( 20 );
      add( nameField );

      add( new Label( "Social Security Number" ) );
      socsecField = new TextField( 20 );
      add( socsecField );

      add( new Label( "Hours" ) );
      hoursField = new TextField( 20 );
      add( hoursField );

      add( new Label( "Rate" ));
      rateField = new TextField( 20 );
      add( rateField );

      add_record = new Button( "Add New Entry" );
      add_record.addActionListener( this );
      add( add_record );      

      quit = new Button( "Quit" );
      quit.addActionListener( this );
      add( quit );

      setVisible( true );  
   }

   public void CreateNewEntry()
   {
      int recnumber = 0;
      Double h,r;

      if ( ! recnumberField.getText().equals( "" ) ) {

         // output the values to the file
         try {
	    recnumber =
	       Integer.parseInt( recnumberField.getText() );

	    if ( recnumber > 0 && recnumber <= 100 ) {
	      
                       new_entry.setrecnumber( recnumber );

	       new_entry.setname( nameField.getText() );

	       new_entry.setsocsec( socsecField.getText() );

	       h = new Double ( hoursField.getText() );

	       new_entry.sethours( h.doubleValue() );

                       r = new Double ( rateField.getText() );
	     
                       new_entry.setrate( r.doubleValue() );

                  
                       output.seek((long) ( recnumber-1 ) * Record.record_size() );
	     
                        new_entry.write( output );
	    }

           
	    recnumberField.setText( "" );
	    nameField.setText( "" );
	    socsecField.setText( "" );
	    hoursField.setText( "" );
                    rateField.setText("");

         }
         catch ( NumberFormatException e ) {
            System.err.println(
	       "You have an incorrect number entered !!!" );
         }
         catch ( IOException e ) {
            System.err.println( "File write error " +e.toString() );
            System.exit( 1 );
         }
      }
   }

   public void actionPerformed( ActionEvent e )
   {
    
      if ( e.getSource() == add_record )  CreateNewEntry();

      if ( e.getSource() == quit ) {
         try {
            output.close();
         }
         catch ( IOException errmsg ) {
            System.err.println( "ERROR CLOSING FILE !!!!!" +
                                errmsg.toString() );
         }

         System.exit( 0 );
      }
   }
   
  
   public static void main( String args[] )
   {
   
 new LoadRandomPayrollFile();
   }
}



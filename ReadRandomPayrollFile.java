
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;

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
   
   
   
   
   
   
 public  String toString()
{

return
("\n your name is   "+   this.name+
"\n your socsec is "+   socsec+
"\n your hours are   "+   hours+
"\n your rate is    "+   rate);


}//toString

   
   
}







public class ReadRandomPayrollFile extends Frame 
             implements ActionListener {



  private TextField recnumberField, nameField,
		     socsecField, hoursField,rateField;

   private Button add_record,  // send record to file
		  quit;   // quit program

  
   private RandomAccessFile input; 

    Record new_entry;

 
   public  ReadRandomPayrollFile()
   {
      super( "Read the payroll file " );

      new_entry = new Record();

      // Open the file
      try {
         input = new RandomAccessFile( "payroll.dat", "rw" );
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
       recnumberField.setEditable( false );
      add( recnumberField );

       add( new Label( "Full Name" ) );
        nameField = new TextField( 20 );
        nameField.setEditable( false );
       add( nameField );

        add( new Label( "Social Security Number" ) );
         socsecField = new TextField( 20 ); 
          socsecField.setEditable( false );      
           add( socsecField );
   
      add( new Label( "Hours" ) );
       hoursField = new TextField( 20 ); 
      hoursField.setEditable( false );
         add( hoursField );

      add( new Label( "Rate" ));
       rateField = new TextField( 20 );
      rateField.setEditable( false );
       add( rateField );

      add_record = new Button( "Read Entry" );
      add_record.addActionListener( this );
      add( add_record );      

      quit = new Button( "Quit" );
      quit.addActionListener( this );
      add( quit );

      setVisible( true );  
   }



   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == add_record )
         ReadPayrollRecord();
      else
         closeFile();
   }

   public void ReadPayrollRecord()
   {

      DecimalFormat twoplaces = new DecimalFormat( "0.00" );
      LinkedList Employee_Record = new LinkedList();
      // read a record and display
      try {
        do {
       new_entry.read( input );
     } while ( new_entry.getrecnumber() == 0 );

	
     Employee_Record.add(new_entry);
    System.out.println("\n\n\nContents of Employee_Record:\n\n\n "+Employee_Record);
System.out.println("\n\n\nContents of new_entry:\n\n\n "+new_entry);

	 
	 
	 
	 
	 
	 
	 
	 
            recnumberField.setText(
            String.valueOf(  new_entry.getrecnumber() ) );
            nameField.setText(  new_entry.getname() );
           socsecField.setText(  new_entry.getsocsec() );
           hoursField.setText( String.valueOf(
            twoplaces.format(  new_entry.gethours() ) ) );
            rateField.setText( String.valueOf(
            twoplaces.format(  new_entry.getrate() ) ) );

      }
      catch ( EOFException eof ) {
         closeFile();
      }
      catch ( IOException e ) {
         System.err.println( "FILE READ ERROR!!!!" +
                             e.toString() );
         System.exit( 1 );
      }
   }

    void closeFile()
   {
      try {
         input.close();
         System.exit( 0 );
      }
      catch ( IOException e ) {
         System.err.println( "FILE CLOSE ERROR !!!" +
                             e.toString() );
         System.exit( 1 );
      }
   }

   public static void main( String args[] )
   {
      new ReadRandomPayrollFile();
	 
   }
}



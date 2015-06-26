
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




public class  MakeRandomPayrollFile {

   Record blank_record;

   private RandomAccessFile stream;

   public MakeRandomPayrollFile()

   {
      blank_record = new Record();

      try {
         stream = new RandomAccessFile( "payroll.dat", "rw" );

         for ( int i = 0; i < 50; i++ )
            blank_record.write( stream );

stream.close();
      }//try

      catch( IOException e ) {
         System.err.println( "FILE OPEN ERROR !!!!!!" +e );
         System.exit( 1 );
      }//catch


   }// MakeRandomPayrollFile

   public static void main( String args[] )
   {

      new MakeRandomPayrollFile();

   } //main  

}// MakeRandomPayrollFile



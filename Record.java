
// Record class for the RandomAccessFile programs.
import java.io.*;

public class Record {
   private int account;
   private String lastName;
   private String firstName;
   private double balance;
   private String socsec;

   // Read a record from the specified RandomAccessFile
   public void read( RandomAccessFile file ) throws IOException
   {
      account = file.readInt();

      char first[] = new char[ 15 ];

      for ( int i = 0; i < first.length; i++ )
         first[ i ] = file.readChar();

      firstName = new String( first );

      char last[] = new char[ 15 ];

      for ( int i = 0; i < last.length; i++ )
         last[ i ] = file.readChar();

      lastName = new String( last );

      balance = file.readDouble();
	  
	  
	   char ssn[] = new char[ 15 ];

      for ( int i = 0; i < ssn.length; i++ )
         ssn[ i ] = file.readChar();

      socsec = new String( ssn );
	  
	  
	  
   }

   // Write a record to the specified RandomAccessFile
   public void write( RandomAccessFile file ) throws IOException
   {
      StringBuffer buf;

      file.writeInt( account );

      if ( firstName != null ) 
         buf = new StringBuffer( firstName );
      else 
         buf = new StringBuffer( 15 );

      buf.setLength( 15 );

      file.writeChars( buf.toString() );

      if ( lastName != null ) 
         buf = new StringBuffer( lastName );
      else 
         buf = new StringBuffer( 15 );

      buf.setLength( 15 );

      file.writeChars( buf.toString() );

      file.writeDouble( balance );
	  
	
	
	  
	  
	  if ( socsec != null ) 
         buf = new StringBuffer( socsec );
      else 
         buf = new StringBuffer( 15 );

      buf.setLength( 15 );

      file.writeChars( buf.toString() );
	  
	  
	  
	  
	  
	  
	  
   }

   public void setAccount( int account ) { this.account = account; }

   public int getAccount() { return account; }

   public void setFirstName( String firstName) {this.firstName = firstName;}
   
   public String getFirstName() { return firstName; }

   public void setLastName( String l ) { lastName = l; }

   public String getLastName() { return lastName; }

   public void setBalance( double b ) { balance = b; }

   public double getBalance() { return balance; }
   
   
   
    public void setSocsec( String socsec ) { this.socsec  = socsec; }

   public String getSocsec() { return socsec; }
   
   
   
   

   // NOTE: This method contains a hard coded value for the
   // size of a record of information.
   public static int size() { return 102; }
}












// This program creates a random access file sequentially
// by writing 100 empty records to disk.
import java.io.*;

public class CreateRandomFile {
   private Record blank;
   private RandomAccessFile file;

   public CreateRandomFile()
   {
      blank = new Record();

      try {
         file = new RandomAccessFile( "credit.dat", "rw" );

         for ( int i = 0; i < 100; i++ )
            blank.write( file );
      }
      catch( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }

   }

   public static void main( String args[] )
   {
      CreateRandomFile accounts = new CreateRandomFile();
	  
   }   
}








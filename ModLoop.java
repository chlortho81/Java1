/*	ModLoop
	Tom McManus
	Extra Credit Assignment Week 5
	IT-4286
	August 6, 2009 
*/
import java.io.*;

public class ModLoop
{
	public static void main(String[] args)
		throws IOException 
	{
		int i, i_lowerlimit, i_upperlimit;
		int i_Seven = 0, i_Eleven = 0, 
				i_Thirteen = 0, i_Seventeen = 0;
				
		// create strings for the input data.
		String str_lowlimit = "", str_upperlimit = "";
		
		BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));

		while (!str_lowlimit.equalsIgnoreCase("exit")
				 && !str_upperlimit.equalsIgnoreCase("exit"))
		{
		
			System.out.println("Type \"exit\" at any time to quit.");

			System.out.print("Please enter the lower limit:  ");
			str_lowlimit     =  inData.readLine();
			if (str_lowlimit.equalsIgnoreCase("exit"))
				break;
				
			System.out.print("Please enter the upper limit:  ");
			str_upperlimit     =  inData.readLine();
			if (str_lowlimit.equalsIgnoreCase("exit"))
				break;

			try
			{
				i_lowerlimit =Integer.parseInt(str_lowlimit);
				i_upperlimit =Integer.parseInt(str_upperlimit);				
			} catch(NumberFormatException errmsg)
			{
				// Don't need the class information on the output, simply
				// dump the message text.
				System.out.println("Invalid format: " + errmsg.getMessage());

				i_lowerlimit = 0;
				i_upperlimit = 0;
				
				continue;
			}//catch

			if (i_lowerlimit > i_upperlimit)
			{
				System.out.println("Lower Limit cannot be greater than Upper Limit, try again.");
				continue;
			}
				
			for (i = i_upperlimit; i >= i_lowerlimit; i--)
			{
				if (0 == (i % 7))
				{
					i_Seven = i;
				}
				if (0 == (i % 11))
				{
					i_Eleven = i;
				}
				if (0 == (i % 13))
				{
					i_Thirteen = i;
				}
				if (0 == (i % 17))
				{
					i_Seventeen = i;
				}
				
				if ( 0 != i_Seven
				&&	 0 != i_Eleven
				&&	 0 != i_Thirteen
				&&	 0 != i_Seventeen)
				{
					break;
				}
		
			}
			
			System.out.println("The largest number between " + i_lowerlimit + 
								" and " + i_upperlimit + " divisible by 7 is: " + i_Seven);
			System.out.println("The largest number between " + i_lowerlimit + 
								" and " + i_upperlimit + " divisible 11 is: " + i_Eleven);
			System.out.println("The largest number between " + i_lowerlimit + 
								" and " + i_upperlimit + " divisible 13 is: " + i_Thirteen);
			System.out.println("The largest number between " + i_lowerlimit + 
								" and " + i_upperlimit + " divisible 17 is: " + i_Seventeen);
								
			// Reset the variables
			i_Seven = i_Eleven = i_Thirteen = i_Seventeen = 0;
		}

			
	}

}

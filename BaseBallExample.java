
import java.io.*;
import java.text.*;
import javax.swing.JOptionPane;

class BaseBall
{

String name;
double average;
int number;
String team;

BaseBall(String name, String average, String number, String team)
{

try{
this.name = name;
this.average =Double.valueOf(average).doubleValue();
this.number =Integer.parseInt(number);
this.team = team;

} 
catch(NumberFormatException errmsg)
{
  

}//catch

}//BaseBall constructor
//HINT:  THE CODE FOR THE TOSTRING() GOES HERE !!!!!!!

  public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        return
        (   "\n Name:\t\t\t"+ this.name +
            "\n Address:\t\t"+ average +
            "\n Hours:\t\t\t"+ String.format("%d",number)+
			"\n Team:\t\t\t"+team);

    }//toString








}//BaseBall


class BaseBallExample{
  
public static void main(String args[]) 
   throws IOException
{

	   BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
	 
	 String str_name;
    String str_average;    
    String str_number;
	String str_team;
	
	 for(;;){  
	 
	 

 str_name  =  inData.readLine();
   if(str_name.equalsIgnoreCase("exit")) System.exit(0);
 
str_average    =  inData.readLine();
 str_number   =  inData.readLine();
 str_team = inData.readLine();
 

	BaseBall player=new BaseBall(str_name,str_average,str_number,str_team); 

	 
	 
	 JOptionPane.showMessageDialog(null,
                "Baseball Information:" +
                player.toString(),
                "Baseball player Being Processed",
                JOptionPane.PLAIN_MESSAGE );
		
		
		System.out.println(player);
	
//FOR EXTRA CREDIT FINISH THE toString()	 
	
	
	
}//for	
}//main	
}//BaseBallExample	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




















// save this file as Conventions.java

class Madness {
  String Convention_name;
  String Convention_theme;
  int Convention_month;
  int Convention_day;
  int Convention_year;

String Calc_weekday()
{
  String [] Days = {"SATURDAY","SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"};  
  int [] Magic =  {1,4,4,0,2,5,0,3,6,1,4,6};  // MAGIC TABLE             
  int Weekday_number;
  int Last_2;
  
  Last_2 = Convention_year % 100;   // use last 2 digits of year
  Weekday_number = Last_2 / 12 + Last_2 % 12 + Last_2 % 12 / 4; 
                                    // compute calendar cycle        
  Weekday_number += Magic[Convention_month - 1]; 
                                    // add in month adjustment number
  Weekday_number += Convention_day; // add in day of the month      
 
                                    // now adjust for leap year
  if (Convention_year % 4 == 0 && Convention_year != 1800 && Convention_year != 1900)
     if (Convention_month == 1 || Convention_month == 2)
         Weekday_number -= 1;   // back up a day for Jan / Feb of Leap year
   
                                //now adjust for century
  if (Convention_year > 1999)
     Weekday_number -= 1;  // back up a day for 2000 - 2099
   
  if (Convention_year < 1900)
     Weekday_number += 2;  // forward 2 days for 1800 - 1899                                                                   

  Weekday_number = Weekday_number % 7; // determine weekday index
                                                                                                
  return Days[Weekday_number];
} // Calc_weekday

void Show_Convention ()
{
    System.out.print("The " + Convention_name);
    System.out.println(" convention is a " + Convention_theme + " convention");
    System.out.print("It begins on: " + Convention_month + "/");
    System.out.println(Convention_day + "/" + Convention_year);
    System.out.println("This is a " + Calc_weekday() + "\n");
}
                                                                     
}// Madness

class Conventions {

   public static void main(String args[]) {

    Madness Con1 = new Madness ();
    Madness Con2 = new Madness ();
    Madness Ref1;

    Con1.Convention_name = "Total Confusion";
    Con1.Convention_theme = "Role Playing";
    Con1.Convention_month = 2;
    Con1.Convention_day = 24;
    Con1.Convention_year = 2000;
   
    
    Con2.Convention_name = "Chiller Theatre";
    Con2.Convention_theme = "Horror / Gothic";
    Con2.Convention_month = 4;
    Con2.Convention_day = 14;
    Con2.Convention_year = 2000;
    
    Ref1 = Con1;
    Ref1.Show_Convention ();

    Ref1 = Con2;
    Ref1.Show_Convention ();

    for (int x=0;x<10;++x)
	System.out.println(".");
    System.out.println("Demonstrating that there are METHODS to my MADNESS.");

  }//main

}// Conventions


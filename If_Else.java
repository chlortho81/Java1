// save this file as If_Else.java

class If_Else {

  public static void main(String args[]) {

    int day_number = 3; // Wednesday_number

    String day_name ="";

     if (day_number == 0) day_name="Sunday";
else if(day_number == 1)  day_name="Monday";
else if(day_number == 2)  day_name="Tuesday";
else if(day_number == 3)  day_name="Wednesday";
else if(day_number == 4)  day_name="Thursday";
else if(day_number == 5)  day_name="Friday";
else if(day_number == 6)  day_name="Saturday";
else day_name="Missing";

    System.out.println("Day number " + day_number + " is a " + day_name);

  }//main

}//If_Else

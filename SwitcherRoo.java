// call this file For_Ex.java

 

class SwitcherRoo {

  public static void main(String args[]) {

    int day_number = 3; // Wednesday_number

    String day_name = "" ;

     switch(day_number) {

case 0: day_name="Sunday";break;
case 1: day_name="Monday";break;
case 2: day_name="Tuesday";break;
case 3: day_name="Wednesday";break;
case 4: day_name="Thursday";break;
case 5: day_name="Friday";break;
case 6: day_name="Saturday";break;
default:day_name="Undefined";break;
}//switch

System.out.println("Day number " + day_number + " is a " + day_name);

}}//main








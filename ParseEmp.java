
// MORE EXTRA CREDIT !!!!
// TURKEY DAY SPECIAL !!!!
// FORGET THE FOOTBALL GAMES !!!
// THE RELATIVES !!!!
// THE COOKING AND CLEANING
// AND ALL THE OTHER STRESSFUL THINGS
// THAT MAKE HOLIDAYS SUCH FUN !!!
// AND DIVE INTO THE EXCITING LAND OF JAVA
// AND FINISH THIS PROGRAM FOR EXTRA CREDIT
// AND PRACTICE FOR THE FINAL (hint hint) WHICH
// WILL BE COMING SOON !!!!!!
// FINISH THIS ANY WAY YOU WISH.
// TRY READING THE DATA IN FROM A TEXT FILE.
// GOOD LUCK
// ANY QUESTIONS PLEASE EMAIL ME !!!!

import java.io.*;


class Emprec {
  String name;
  String address;  
  double hours;
  double rate;
  char sex;
  int age;
//boolean active;  //this is extra credit
// see if you can get the boolean to load from a text file.
// what's missing ????

//methods !!!!
// constructors !!!
}// Emprec



class ParseEmp{
  
public static void main(String args[]) 
    throws IOException
 
 {
    // create a DataInputStream using System.in
   // DataInputStream inData = new DataInputStream(System.in);
      BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));




// create strings for the input data for the Emprec object

    String str_name;
    String str_hours;
    String str_rate;

// the scope of the object is important !!!
Emprec employee = new Emprec();

    do {
     
//Emprec employee = new Emprec();/// noy here but above !!!

 str_name  =  inData.readLine();
 str_hours =  inData.readLine();
 str_rate  =  inData.readLine();

      try {


// HERE'S YOUR TOOLKIT USE IT !!!!
/*        i = Integer.parseInt(str);
        if(i==-1) break;

        l = Long.parseLong(str);
        f = Float.valueOf(str).floatValue();
        d = Double.valueOf(str).doubleValue();
        b =Boolean.valueOf(str).booleanValue();
        // as you will see you do the booleans
        // like the floats and doubles !!!

       // c=  str[0];// nope this is C or C++
         c = str.charAt(0);// correct way to read a cahracter in Java
                       // zero is the first character of the string object.

       System.out.println(i+" "+l+" "+f+" "+d+ "   "+ c);
*/


 
//Emprec employee = new Emprec(); // not here either !!!
employee.name = str_name;
employee.hours = Double.valueOf(str_hours).doubleValue();
      
employee.rate = Double.valueOf(str_rate).doubleValue();

System.out.println(" \n the salary for " + employee.name);
System.out.println(" is " + employee.hours * employee.rate);
 

      } catch(NumberFormatException e) {
        System.out.println("Invalid format"+ e);
     employee.name  = "";  
     employee.hours = 0.0;
     employee.rate  = 0.0;


      }

    } while(employee.hours != -1.0);
  }
}

// you may try this method     System.exit(0);
// to exit from the program.





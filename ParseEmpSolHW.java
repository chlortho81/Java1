 







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
         c = str.charAt(0);// correct way to read a character in Java
                       // zero is the first character of the string object.

       System.out.println(i+" "+l+" "+f+" "+d+ "   "+ c);
*/


import java.io.*;


class Emprec {
  String name;
  String address; 
 // double gpa;
 // int age;
 

Emprec (String name,String address)
{

try{
this.name=name;
this.address=address;


} catch(NumberFormatException errmsg)
{
  System.out.println("Invalid format"+ errmsg);
    
     this.name  = ""; 
    // this.gpa = 0.0;
    // this.age = 0;
   

}//catch

}//Emprec constructor !!!!


public  String toString()
{

return
("\n your name is   "+ name+
"\n your address is "+ address);


}//toString


// see if you can get the boolean to load from a text file.
// what's missing ????

//methods !!!!
// constructors !!!
}// Emprec

class ParseEmpSolHW
{
 
public static void main(String args[])
    throws IOException
 
 {

      BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));


// create strings for the input data for the Emprec object

    String str_name;
    String str_address;  
  
   

   for(;;){ 

//READ THE FILE !!!!

 str_name     =  inData.readLine();

 if (str_name.equalsIgnoreCase("exit")) System.exit(0);

str_address  =  inData.readLine();

Emprec employee=new Emprec(str_name,str_address);

System.out.println(employee);


    
    }//for

 
   }//main

}//ParseEmpSol

// you may try this method     System.exit(0);
// to exit from the program.



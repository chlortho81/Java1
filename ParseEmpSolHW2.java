//HW 5 Double Credit 
// Add 3 more fields
// and two methods
//Finally, finsih the toString()
// you may make your own class if you really want to practice.

// HERE'S YOUR TOOLKIT USE IT !!!!
/*        i = Integer.parseInt(str);
        if(i==-1) break;

        l = Long.parseLong(str);
        f = Float.valueOf(str).floatValue();
        d = Double.valueOf(str).doubleValue();
        b =Boolean.valueOf(str).booleanValue();
        // as you will see you do the booleans
        // like the floats and doubles !!!

       // c=  str[0];// nope this is C or C++ or C#
         c = str.charAt(0);// correct way to read a cahracter in Java
                       // zero is the first character of the string object.

       System.out.println(i+" "+l+" "+f+" "+d+ "   "+ c);
*/


import java.io.*;


class Emprec {
  String name;
  // DECLARE THE NEW FIELD     STEP 1
 





Emprec (String name)   
//STEP 2 ADD IT TO THE PARAMETER LIST
{

try{
this.name=name;



// Step 3 ASSIGN IT TO THE OBJECT 
} catch(NumberFormatException errmsg)
{
  System.out.println("Invalid format"+ errmsg);
     
     this.name  = "";  
    

}//catch

}//Emprec constructor !!!!



// Step 4 ASSIGN IT TO THE toString() 
public  String toString()
{

return  ("\n your name is " + name);



}//toString


// see if you can get the boolean to load from a text file.
// what's missing ????

//methods !!!!
// constructors !!!
}// Emprec



class ParseEmpSolHW2
{
  
public static void main(String args[]) 
    throws IOException
 
 {

     BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));



// create strings for the input data for the Emprec object

    String str_name;
     //Step 5 make a stunt double !!!!!	
	
	
	
	
    

   for(;;){  

//READ THE FILE !!!!

 str_name     =  inData.readLine();

 if (str_name.equalsIgnoreCase("exit")) System.exit(0);



Emprec employee=new Emprec(str_name);  
//Step 7 pass the new field to the constructor !!!  V.O.
System.out.println(employee);


     
    }//for

 
   }//main

}//ParseEmpSol



// you may try this method     System.exit(0);
// to exit from the program.







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
  String address; 
String socsec;     // DECLARE THE NEW FIELD     STEP 1
int age;
double gpa;
  
//boolean active;  //this is extra credit





Emprec (String name,String address, String socsec, String age,String gpa)   //STEP 2 ADD IT TO THE PARAMETER LIST
{

try{
this.name=name;
this.address=address;
this.socsec = socsec;   // Step 3 ASSIGN IT TO THE OBJECT 
this.age = Integer.parseInt(age);
this.gpa = Double.valueOf(gpa).doubleValue();

} catch(NumberFormatException errmsg)
{
  System.out.println("Invalid format"+ errmsg);
     
     this.name  = "";  
    

}//catch

}//Emprec constructor !!!!




public  String toString()
{

return
("\n your name is   "+   name+
"\n your address is "+   address+
"\n your socsec is "+   socsec +
"\n your age is "+   age+
"\n your gpa is "+   gpa);  // Step 4 add it to the toString()


}//toString


// see if you can get the boolean to load from a text file.
// what's missing ????

//methods !!!!
// constructors !!!
}// Emprec



class ExtraCredit
{
  
public static void main(String args[]) 
    throws IOException
 
 {

      BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));




// create strings for the input data for the Emprec object

    String str_name;
    String str_address;   
    String str_socsec;   //Step 5 make a stunt double !!!!!	
	String   str_age;
	String  str_gpa;
	
	
	
    

   for(;;){  

//READ THE FILE !!!!

 str_name     =  inData.readLine();

 if (str_name.equalsIgnoreCase("exit")) System.exit(0);

str_address  =  inData.readLine();

str_socsec  =  inData.readLine();  //Step 6 Read in the data for the new field !!!

str_age = inData.readLine();

str_gpa = inData.readLine();
  

Emprec employee=new Emprec(str_name,str_address,str_socsec,str_age,str_gpa);  //Step 7 pass the new field to the constructor !!!  V.O.

System.out.println(employee);


     
    }//for

 
   }//main

}//ParseEmpSol



// you may try this method     System.exit(0);
// to exit from the program.





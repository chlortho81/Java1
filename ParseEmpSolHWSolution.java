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
  double gpa;
  int age;
  
  //constructor below
  
	Emprec(String name,String address, String gpa, String age){
	try{// is this try here because of the catch?????
		this.name = name;
		this.address = address;
		this.gpa = Double.valueOf(gpa).doubleValue();
		this.age = Integer.parseInt(age);
	}//closes try????
		catch(NumberFormatException errmsg) {
			System.out.println("Invalid format"+ errmsg);
				this.name  = "";  
				this.address = "";
				this.gpa = 0.00;
				this.age = 0;
		}//close catch????
	}//This closes Emprec
	
	public  String toString() {
		return("\n Your name is: " + name +
				"\n Your address is: " + address +
				"\n Your gpa is " + gpa +
				"\n Your age is " + age);
		} //toString method


}// Emprec
class ParseEmpSolHWSolution{
public static void main(String args[]) 
    throws IOException {
      BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
   
   
   for(;;){ 
	
	System.out.print("Enter your name or type exit to exit program: "); 
		String str_name = inData.readLine();
	
	if (str_name.equalsIgnoreCase("exit")) System.exit(0);
	
	System.out.print("Enter your address: "); 
		String str_address = inData.readLine();
	System.out.print("Enter your GPA: ");
		String str_gpa = inData.readLine();
	System.out.print("Enter your age: ");
		String str_age = inData.readLine();
   
      Emprec employee = new Emprec(str_name, str_address, str_gpa, str_age);
	
	System.out.println(employee); 
	
    }//for
 
   }//main
}//ParseEmpSol
// you may try this method     System.exit(0);
// to exit from the program.=
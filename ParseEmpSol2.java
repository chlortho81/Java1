

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
         c = str.charAt(0);// correct way to read a character in Java
                       // zero is the first character of the string object.

       System.out.println(i+" "+l+" "+f+" "+d+ "   "+ c);
*/


import java.io.*;


class Emprec {
 private String name;
  String address;  
  double hours;
  double rate;
  char sex;
  int age;
  boolean active;  





Emprec (String name,String address,String hours,String rate,String sex,String age,String active)
{

try{
this.name=name;
this.address=address;
this.hours=Double.valueOf(hours).doubleValue();
this.rate=Double.valueOf(rate).doubleValue();
this.sex=sex.charAt(0);
this.age=Integer.parseInt(age);
this.active=Boolean.valueOf(active).booleanValue();
} catch(NumberFormatException errmsg)
{
  System.out.println("Invalid format"+ errmsg);
     
     this.name  = "";  
     this.hours = 0.0;
     this.rate  = 0.0;

}//catch

}//Emprec constructor !!!!



double calc_fed_tax(double hours,double rate)
{

  double yearly_income;

  yearly_income = hours * rate *52;

   if (yearly_income < 30000.00) return (hours * rate *.28);

   else if ( yearly_income < 50000.00 ) return (hours * rate* .32);

   else return (hours * rate * .38);


}// calc_fed_tax


double calc_gross_pay()
{

   return (hours * rate);

}// calc_gross_pay


double calc_state_tax(double hours, double rate)
{

  double state_tax;

  state_tax = hours * rate * .0561;

  return (state_tax);

}// calc_state_tax


public String toString() {
     
	  return("\nyour name is " + this.name +
               "\nyour address is " + this.address +
	      
               "\nyour hours are " + hours +
               "\nyour rate is " + rate +
               "\nyour sex is " + sex +
               "\nyour age is " + age +
	        
               "\nyour status is " + active +
               "\nyour gross pay is " + calc_gross_pay() +
               "\nyour state tax is " +
this.calc_state_tax(this.hours,this.rate));
   }// toString()



// see if you can get the boolean to load from a text file.
// what's missing ????

//methods !!!!
// constructors !!!
}// Emprec



class ParseEmpSol2{
  
public static void main(String args[]) 
    throws IOException
 
 {

      BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));




// create strings for the input data for the Emprec object

    String str_name;
    String str_address;    
    String str_hours;
    String str_rate;
    String str_sex;
    String str_age;
    String str_active;

   for(;;){  

//READ THE FILE !!!!cd

 str_name     =  inData.readLine();

//if(Integer.parseInt(str_name)==-1) System.exit(0);

if(str_name.equalsIgnoreCase("exit")) System.exit(0);

 str_address  =  inData.readLine();
 str_hours    =  inData.readLine();
 str_rate     =  inData.readLine();
 str_sex      =  inData.readLine();
 str_age      =  inData.readLine();  
 str_active   =  inData.readLine();
 
Emprec employee=new Emprec(str_name,str_address,str_hours,str_rate,str_sex,str_age,str_active);

System.out.println(employee.toString());

System.out.println("the federal tax is "+employee.calc_fed_tax(employee.hours, employee.rate));
     
    }//for

 
   }//main

}//ParseEmpSol2



// you may try this method     System.exit(0);
// to exit from the program.





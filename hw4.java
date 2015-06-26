//TRY AND ADD 2 MORE FIELDS OF YOUR CHOICE TO THIS EXAMPLE.
// TRY AND ADD 2 MORE METHODS TO THIS EXAMPLE.  MAYBE A HEALTH PLAN
// DEDUCTION OR A DEPENDENT CREDIT OR AN ANNUITY.


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
                       // zero is the first character of the String object.

       System.out.println(i+" "+l+" "+f+" "+d+ "   "+ c);
*/


import java.io.*;







class Emprec {
  String name;
  String address;  
  double hours;
  double rate;
  char sex;
  int age;
  boolean active; //this is extra credit
// MY FIELDS ADDED FOR HW4.
  double medical;
  double pension;  

  




Emprec (String name,String address,String hours,String rate,String sex,String age,String active,String medical,String pension)
{

try{
this.name=name;
this.address=address;
this.hours=Double.valueOf(hours).doubleValue();
this.rate=  Double.valueOf(rate).doubleValue();
this.sex=sex.charAt(0);
this.age=Integer.parseInt(age);
this.active=Boolean.valueOf(active).booleanValue();
//
//ADDED FOR HW4.
//
this.medical=Double.valueOf(medical).doubleValue();
this.pension=Double.valueOf(pension).doubleValue();

} catch(NumberFormatException errmsg)
{
  System.out.println("Invalid format"+ errmsg);
     
     this.name  = "";  
     this.hours = 0.0;
     this.rate  = 0.0;
     this.medical=0.0;
     this.pension=0.0;

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

//
//MY TWO METHODS ADDED TO PROGRAM.
//
double calc_net_pay(double hours, double rate,double medical,double pension)
{

  double net_pay;
 
  net_pay=(hours*rate)-calc_fed_tax(hours,rate)-calc_state_tax(hours,rate)-medical-pension;
  return(net_pay);
}

public double test_contribution(double hours,double rate,double pension)
{

   int test_result;
   
   if((pension*52)>9655) return(test_result=-1);
   else return(test_result=1);

}





 public  String toString()
{

if(test_contribution(hours,rate,pension)==-1) return("\nFailed Limitation test. Need to contact "+name+"\n\n");
else if(test_contribution(hours,rate,pension)==1)
  return
  ("\n your name is   "+   this.name+
   "\n your address is "+   address+
   "\n your hours are   "+   hours+
   "\n your rate is    "+   rate+
   "\n your sex is     "+   sex+
   "\n your age is     "+   age+
   "\n your status is " + active+
   "\n\nPAY TOTALS: \n"+
   " your GROSS pay is "+calc_gross_pay()+
   "\n your Medical Insurance Premimun is "+medical+
   "\n your 401K Contribution is "+pension+
   "\n___________________________\n"+
   "\n your NET pay is "+calc_net_pay(hours,rate,medical,pension)); 

                                                                 

else return("\nERROR!");

}//toString


// see if you can get the boolean to load from a text file.
// what's missing ????

//methods !!!!
// constructors !!!
}// Emprec



class hw4{
  
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
    String str_medical;
    String str_pension;

   for(;;){  

//READ THE FILE !!!!

 str_name     =  inData.readLine();

//if(Integer.parseInt(str_name)==-1) System.exit(0);

if(str_name.equalsIgnoreCase("exit")) System.exit(0);

str_address  =  inData.readLine();
 str_hours    =  inData.readLine();
 str_rate     =  inData.readLine();
 str_sex      =  inData.readLine();
 str_age      =  inData.readLine();  
 str_active=    inData.readLine();
 str_medical=   inData.readLine();
 str_pension=   inData.readLine();
Emprec employee=new Emprec(str_name,str_address,str_hours,str_rate,str_sex,str_age,str_active,str_medical,str_pension);
//
//MY QUESTION:Why does complier allow strings to be used for double and int values in emprec class object????????
//Is it because the emprec constructor is called when object is created and does the conversion?
//
if(employee.test_contribution(employee.hours,employee.rate,employee.pension)==-1) System.out.println("\nFailed Limitation test. Need to contact "+str_name);
else

  { System.out.println(employee);

    System.out.println("\nTax Details:\n  the federal tax is "+employee.calc_fed_tax(employee.hours, employee.rate));
    
    System.out.println("  the state tax is "+employee.calc_state_tax(employee.hours,employee.rate));     
  }
    }//for

 
   }//main
     

//System.exit(0);  // to exit from the program.

}//end of hw4.





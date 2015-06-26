import java.io.*;
import java.text.*;
import javax.swing.JOptionPane;

class Emprec {

    String name;
    String address;
    double hours;
    double rate;
    char sex;
    int age;
    boolean active; 

//This is the Emprec class's constructor !!!!!   
   Emprec (String name,String address,String hours,String rate,
            String sex,String age,String active)
    {
        try
        {
            this.name=name;
            this.address=address;
            this.hours=Double.valueOf(hours).doubleValue();
            this.rate=Double.valueOf(rate).doubleValue();
            this.sex=sex.charAt(0);
            this.age=Integer.parseInt(age);
            this.active=Boolean.valueOf(active).booleanValue();
        }
        catch(NumberFormatException errmsg)
        {
            System.out.println("Invalid format"+ errmsg);
            this.name = "";
            this.hours = 0.0;
            this.rate = 0.0;
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


    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        return
        (   "\n Name: \t\t\t"+ this.name +
            "\n Address: \t\t"+ this.address +
            "\n Hours: \t\t"+ hours +
            "\n Rate: \t\t\t"+ fmt.format(rate) +
            "\n Sex: \t\t\t"+ sex +
            "\n Age: \t\t\t"+ age +
            "\n Status: \t\t" + (this.active ? "Active" : "Inactive") +
            "\n Gross pay: \t\t"+ fmt.format(calc_gross_pay()) +
            "\n State tax: \t\t"+ fmt.format(this.calc_state_tax(this.hours,this.rate))
        );

    }//toString


}// Emprec


class Assignment1
{
    public static void main(String args[]) throws IOException
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
        
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

        for(;;){
            //READ THE FILE !!!!
            str_name = inData.readLine();

            if(str_name.equalsIgnoreCase("exit")) System.exit(0);

            str_address = inData.readLine();
            str_hours = inData.readLine();
            str_rate = inData.readLine();
            str_sex = inData.readLine();
            str_age = inData.readLine();
            str_active= inData.readLine();

            Emprec employee=new Emprec(str_name,str_address,str_hours,str_rate,str_sex,str_age,str_active);

            System.out.println(employee.toString());

            System.out.println(" Federal tax:\t\t"
                          + fmt.format(employee.calc_fed_tax(employee.hours, employee.rate)));

            JOptionPane.showMessageDialog(null,
                "Employee Information:" +
                employee.toString(),
                "Employee Payroll Being Processed",
                JOptionPane.PLAIN_MESSAGE );

        }//for
    }//main
}//Assignment1
class StuRec {
    String name;
    String address;
    char sex;
    int age;
    int credits;
    double points;
    boolean active;

StuRec ()
{
    this("undefined", "undefined", "0", "0", "0", "0.0", "false");
} // StuRec constructor

StuRec (String name)
{
    this(name, "undefined", "0", "0", "0", "0.0", "false");
} // StuRec constructor

StuRec (String name, String address)
{
    this(name, address, "0", "0", "0", "0.0", "false");
} // StuRec constructor

StuRec (String name, String address, String sex, String age)
{
    this(name, address, sex, age, "0", "0.0", "false");
}

StuRec (String name, String address, String sex, String age, String credits, String points, String active)
{
    try{
        this.name = name;
        this.address = address;
        this.sex = sex.charAt(0);
        this.age = Integer.parseInt(age);
        this.credits = Integer.parseInt(credits);
        this.points = Double.valueOf(points).doubleValue();
        this.active = Boolean.valueOf(active).booleanValue();
    } catch(NumberFormatException ex) {
        System.err.println("StuRec NumberFormatException: " + ex.getMessage());
        this.name  = "undefined";
        this.address = "undefined";
        this.sex = 0;
        this.age = 0;
        this.credits = 0;
        this.points = 0.0;
        this.active = false;
    } catch(Throwable t) {
        System.err.println("StuRec Throwable: " + t.getMessage());
        this.name  = "undefined";
        this.address = "undefined";
        this.sex = 0;
        this.age = 0;
        this.credits = 0;
        this.points = 0.0;
        this.active = false;
    }//catch
} // StuRec constructor

double calc_gpa(int credits, double points)
{
    double gpa = 0.0;
    if (credits != 0) gpa = points / credits;
    return gpa;
} // calc_gpa

String calc_level()
{
    String level = "";
    if (credits < 45) level = "Freshman";
    else if (credits < 90) level = "Sophomore";
    else if (credits < 135) level = "Junior";
    else level = "Senior";
    return level;
} // calc_level

boolean is_active()
{
    return active;
} // is_active

void calc_credits_to_grad(int credits)
{
    int credits_to_grad = 180 - credits;
    System.out.println("Credits needed to graduate is " + credits_to_grad);
} // calc_credits_to_grad

void is_deans_list()
{
    if (calc_gpa(credits, points) >= 3.5) System.out.println("Student is on the Dean's List");    
    else System.out.println("Student is not on the Dean's List");
} // is_deans_list

public  String toString()
{
     return("Name is             " + this.name +
             "\nAddress is          " + this.address +
             "\nSex is              " + this.sex +
             "\nAge is              " + this.age +
             "\nTotal Credits       " + this.credits +
             "\nTotal Points        " + this.points +
             "\nGrade Point Average " + this.calc_gpa(this.credits, this.points) +
             "\nGrade Level         " + this.calc_level() +
             "\nActive              " + this.is_active()
     );
} // toString

} // StuRec

public class ParseEmpStudentProcess {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // create multiple instances of StuRec using different constructors
        StuRec student = new StuRec();
        StuRec student2 = new StuRec("Jane Doe");
        StuRec student3 = new StuRec("John Jones", "111 North Street");
        StuRec student4 = new StuRec("Susan Black", "222 South Drive", "F", "18");
        StuRec student5 = new StuRec("Mary Smith", "123 Main Street", "F", "22", "135", "499.5", "true");
        StuRec student6 = new StuRec("Butch Barkley", "789 South Avenue", "M", "45", "50", "25.0", "true");

        // display the output for first student, created with default constructor
        System.out.println("\nStudent (default constructor): ");
        System.out.println(student);
        student.calc_credits_to_grad(student.credits);
        student.is_deans_list();

        // display the output for second student
        System.out.println("\nStudent 2 (constructor set name only): ");
        System.out.println(student2);
        student2.calc_credits_to_grad(student2.credits);
        student2.is_deans_list();

        // display the output for third student
        System.out.println("\nStudent 3 (constructor set name and address): ");
        System.out.println(student3);
        student3.calc_credits_to_grad(student3.credits);
        student3.is_deans_list();

        // display the output for fourth student
        System.out.println("\nStudent 4 (constructor set name, address, sex, and age): ");
        System.out.println(student4);
        student4.calc_credits_to_grad(student4.credits);
        student4.is_deans_list();

        // display the output for fifth student
        System.out.println("\nStudent 5 (constructor set all fields): ");
        System.out.println(student5);
        student5.calc_credits_to_grad(student5.credits);
        student5.is_deans_list();

        // display the output for sixth student
        System.out.println("\nStudent 6 (constructor set all fields): ");
        System.out.println(student6);
        student6.calc_credits_to_grad(student6.credits);
        student6.is_deans_list();
    } // main
} // StudentProcess



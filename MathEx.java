// save this as MathEx.java

class MathEx {

  public static void main(String args[]) {

    int i = 5;
    int j = 3;
    long l = 17L;
    float f = 3.5f;// note that the "f" need not be capitalized
    double d = 42.9;

    i = i + 12;// addition

    j = j - 5;//subtraction

    l = j / i;//division

 //  f = f * d; //error why ????? fix it !!!!
    //f = ( float)  f * d;
 
 
 
 f = (float) (f*d);

    i= 17 % 3;// modulus

i = 100;
    System.out.printf(" i is %o",i);


    System.out.println(" \n\n \t\t l is " + l);

f = (float)222221.12345678901234;
    System.out.printf(" LINE 34  f is after being cast to float %f" , f);

d = 751871.12845678901234;
    System.out.printf("\n\n d is %.2f", d);


  }//main

}//MathEx










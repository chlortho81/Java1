/**************************************************
	CharExHW.java
	Julie Stoller
	Java Programming - Tues. 8-10pm, Burlington
	Fall 2000
 
***************************************************/


class CharExHW {

  public static void main(String args[]) {

    char ch;
    // assign ch to capital "A" - "The String"

    ch='A'; //"The Character"

    // now display the value
    System.out.println("the value of ch is  " + ch);

   // you can also display the value as an int
    System.out.println("the value of  ch is  " + (int)ch); //65
    // in this way you can do the following
    ++ch;

   // note what is displayed now

    System.out.println("the value of  ch is  " + ch);

    System.out.println("the value of  ch is  " + (int)ch);

   // what will be the output if I do this

   --ch;

    System.out.println("the value of  ch is  " + ch);

    System.out.println("the value of  ch is  " + (int)ch);

   // some more things to try
   
   char ch2=0;

   ch2='g'; //"The Character"

   System.out.println("the value of ch is " + (int)ch);

   System.out.println("the value of ch2 is " + (int)ch2);

   int result;

   result = ch2 - ch;

   System.out.println("the result of ch2 minus ch is " + result);

   System.out.println("or in other words, " + (char)result);

  }//main

}// CharEx

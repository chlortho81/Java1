// save as TernEx.java

class TernEx {

  public static void main(String args[]) {

    int a=5000, b=750;

    boolean choice;


       //  BAD STYLE !!!!!              if (a<=b) choice =true; else choice = false;
      //                                            YES                   NO
    choice = (a<=b) ?   true  :   false;


    System.out.println(" choice is " + choice);

  }//main

} // TernEx









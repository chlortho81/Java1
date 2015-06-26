// save this file as Break_Ex2.java

class Break_Ex2 {

  public static void main(String args[]) {
    int i;

    for( i=0; i<20; ++i){

      switch(i) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
          System.out.println(i + " is 0 to 5");
          break;
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:

          System.out.println(i + " is 6 to 15");
          break;
        default:
          System.out.println(i+" is greater than 15");
      break;
      } // switch
    }//for
  }   //main

}//Break_Ex2


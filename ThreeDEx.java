// save as ThreeD.java

class ThreeDEx {
  public static void main(String args[]) {
    int list[][][] = new int[3][5][3];
    // what we have are mailboxes 3 rows by 5 columns
    // they are found in 3 apartment buildings

    int i, j, k;// to address the row, column and apartment bldg
                // of all the mailboxes !!!!

   // load by row,column and apartment bldg.
    for(i=0; i<3; i++) //row
      for(j=0; j<5; j++)//column
        for(k=0; k<3; k++)//apartment bldg.
        {
          System.out.println(" now loading row " + i + " column  " + j + " of building  " + k); 

         list[i][j][k] = i;// set all the values i
        }

    for(i=0; i<3; i++) 
      for(j=0; j<5; j++) 
        for(k=0; k<3; k++)

        {
          System.out.print(" row " + i + " column " + j + " of building " + k); 
        
          System.out.println(" has the value  "+ list[i][j][k]);

        }// for k


  }// main

}// ThreeD



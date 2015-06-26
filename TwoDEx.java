// save this file as TwoDEx.java

class TwoDEx {

  public static void main(String args[]) {

    int list[][]= new int[3][3]; // create a 2-d array
    int i, j; // declare variables to access the array elements
int ctr=0;
  // load the array
 for(i=0; i<3; i++)
 for(j=0; j<3; j++)
	       
	
	
     
	 
	 
      {

        System.out.println("row " + i + " column " + j + " now being loaded with " + ctr);

         list[i][j]=ctr++;// set the values in the array to the value of ctr
       }//for j

     
	for(i=0; i<3; i++) {
	for(j=0; j<3; j++)
    
     {

     //   System.out.println("row " + i + " column " + j + " now being printed " );

        System.out.print(list[i][j]+ "   "	);

    }//for j

	System.out.println();
	
	}// for i
    }//main

  }// TwoDEx



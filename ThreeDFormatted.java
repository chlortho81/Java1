 // save as ThreeD.java

 

class ThreeDFormatted {

public static void main(String args[]) {

int list[][][] = new int[3][5][3];

// what we have are mailboxes 3 rows by 5 columns

// they are found in 3 apartment buildings
 
int i, j, k;// to address the row, column and apartment bldg
int ctr=0;
// of all the mailboxes !!!!

// load by row,column and apartment bldg.
for(k=0; k<3; k++)//apartment bldg.
for(i=0; i<3; i++) //row

for(j=0; j<5; j++)//column



{

System.out.println(" now loading row " + i + " column "+ j + " of building " + k); 
 

list[i][j][k] = ctr++;// set all the values i

}


for(k=0;k<3; k++) {

System.out.println(" BUILDING " + k);
for(i=0;i<3; i++) {
 
 for(j=0;j<5; j++) 
         System.out.print(list[i][j][k] + " ");
		

		System.out.println();//for i
		 }
        System.out.println();//for k
}   		



 
}// main
 
}// ThreeD


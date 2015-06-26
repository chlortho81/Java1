class Divisibleby7_11_13_17 {

public static void main(String args[]) {

int i;

int greatest = 0;

for(i = 17; i<=100000; ++i) {
 


 if (i % 7 != 0) continue;
 
 if (i % 11 != 0) continue;
 
 if (i % 13 != 0) continue;
 
 if (i % 17 != 0) continue;

greatest = i;

 
}//for

 

System.out.println(" the LARGEST # up to " + i + " DIVISIBLE BY 7 11 13 17 IS " + greatest);

 

 

}//main

 

}// FOR71113


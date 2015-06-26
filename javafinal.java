/ HERE IS THE FINAL 
 // IT IS DUE TUESDAY MARCH 13, 2001 BY 10:00PM E.S.T. 
 // NO CREDIT WILL BE GIVEN FOR LATE WORK 
 // IF YOU HAEV ANY CONCERNS PLEASE E-MAIL ME AT YOUR 
 // EARLIEST CONVENIENCE. 
 // I HAVE TRIED TO WALK YOU THROUGH THIS BUT IF ANYTHING 
 // IS UNCLEAR DO NOT HESITATE TO LET ME KNOW. 
 // REMEMBER, I AM INTERESTED IN YOUR GRASP OF JAVA 
 // AND YOUR KNOWLEDGE OF THE AREAS WE HAVE EXPLORED. 


 // THINGS TO ADD 

 // CONSTRUCTORS AND USE SUPER( ) TO PASS INFORMATION INTO 
 // THE CONSTRUCTORS OF THE EXTENDED CLASSES. 
 // TOSTRING() TO MAKE A SHIPPING LABEL. 
 // ANY METHODS YOU DEEM NECESSARY TO ADD TO ANY OF THE 
 // PRESENTED CLASSES. 

 // LOAD THE DATA FROM A FILE LIKE PARSEDEMO PROGRAM 

 // USE AN INTERFACE ???? ONLY IF YOU WANT TO. 

 // NO THREADS !!!!!! THIS PROGRAM IS TOO 
 // SMALL FOR THREADS TO WORK EFFECTIVELY !!!! 


 // HERE'S WHAT I WANT YOU TO DO !!!!!!!!! 

 // FINISH THIS PROGRAM 
 // THIS IS LIKE A UPS OR FEDEX PROGRAM 
 // CREATE YOUR OWN COMPANY. CALL IT FEDUP IF YOU WANT. 
 // GENERATE SHIPPING LABELS. 
 // FOLLOW THROUGH THE METHODS AND MAKE ANY ASSUMPTIONS YOU //
 THINK ARE NECESSARY. 

 // I AM INTERESTED IN YOUR GRASP OF THE JAVA PROGRAMMING
 //LANGUAGE 

 // SO YOUR ALGORITHM NEED NOT BE COMPLICATED. 
 // I WANT TO SEE IF YOU HAVE GOTTEN THE BASIC CONCEPTS OF JAVA 
 // AND CAN EMPLOY THEM IN A DESIGN OF YOUR OWN. 

 // ALSO, I AM FINISHING AN ADVANCED JAVA CLASS FOR THE ONLINE 
 // SECTION AND THIS WILL BE OFFERED THIS SUMMER 2001. 
 // (just in case some you are gluttons for punishment !!!) 


 // OK LET'S START HERE !!!! 

 import java.io.*; 

 class box{ 

 int width, height, depth,volume; 

 box() 
 { 

 // FINISH THIS CONSTRUCTOR AND SET ALL THE FIELDS TO ZERO !!!! 

 }// null constructor 


 box(int width, int height, int depth) 
 { 
                 // FINISH THIS CONSTRUCTOR TO LOAD THE FIELDS 
                // OF THE BOX OBJECT FROM THE DATA PROVIDED 3 LINES UP 

 }// main constructor 


 //WRITE A METHOD TO CALCULATE THE VOLUME OF THE PACKAGE //multiply
// together 
 // VOLUME SHOULD NOT BE ASSIGNED THROUGH THE 
 // CONSTRUCTOR; IT IS CALCULATED FROM KNOWING THE WIDTH, HEIGHT, 
 // AND DEPTH WHICH ARE ASSIGNED IN THE CONSTRUCTOR. 

 void calc_volume(int width, int height, int depth) 
 { 
 // CALCULATE THE VOLUME AS AN INTEGER TO FILL THE VOLUME FIELD 
 // OF THIS OBJECT. 
 } 

 }//class box 

 // NOTICE THE INHERITANCE HERE AS BOXWEIGHT EXTENDS BOX 

 class boxweight extends box{ 

 double weight;  //width height and depth are super 

 boxweight() 
 { 
 // SET THE WEIGHT FIELD TO ZERO 
 }// null constructor 

 boxweight(double weight) 
 { 
 // ASSIGN THE WEIGHT FIELD OF THE OBJECT TO THE VALUE 
 // PASSED INTO THE METHOD UNDER   (double weight) see 3 lines up 
 }// main constructor 

 }//BOXWEIGHT 

 //AGAIN NOTICE THE INHERITANCE AS COST EXTENDS BOXWEIGHT 
 // AND REMEMBER BOXWEIGHT HAS ALREADY EXTENDED BOX 

 class cost extends boxweight{ 

 //HINT :     weight, width, height and depth are super to this class 

 int shipping_region;  // THE  AREA OF THE UNITED STATES   
                                    //  THE PARCEL IS GOING TO. 

 double shipping_cost; // THIS IS A VALUE YOU WRITE A METHOD TO CALCULATE 
                                     // NOT ASSIGN THROUGH A CONSTRUCTOR LIKE YOU
 DID FOR 
                                    //  VOLUME FIELD IN THE BOX OBJECT 


 cost() 
 { 
 // SET THE OBJECTS SHIPPING_REGION FIELD TO ZERO HERE 
 }// null constructor 

 cost (int shipping_region) 
 { 
 // ASSIGN THE SHIPPING_REGION FIELD OF THE OBJECT TO THE VALUE 
 // PASSED INTO THE METHOD UNDER   (int shipping_region) see 3 lines up 
 }// main constructor 



 //WRITE A METHOD TO CALCULATE THE SHIPPING_COST FOR THIS PACKAGE
 BASED 
 // ON THE CALCULATED  VOLUME AND ALSO THE WEIGHT. ALSO ADD TO THE
 COST 
 // A CHARGE FOR THE SHIPPING_REGION WHICH IS THE AREA OF THE
 COUNTRY 
 //YOUR PARCEL IS GOING TO. 
 //YOU MAKE UP THE FORMULA !!!! 
 // HAVE FUN, BE CREATIVE AND KEEP IT SIMPLE !!! 


 double calc_shipping_cost(int volume, double weight, int shipping_region) 
 { 


                  }// SHIPPING_REGION_COST METHOD ENDS HERE 


 }//COST 


 // THIS IS FINAL CLASS AND THE ONE THAT WILL PRINT THE 
 // LABEL FOR THE PACKAGE. 
 // AGAIN, NOTICE THAT IT EXTENDS COST WHICH EXTENDED BOXWEIGHT 
 //  WHICH EXTENDED BOX  (see how all the data is coming together!!!) 

 class customer extends cost{ 
 String receiver; 
 String receivers_address; 
 String sender; 
 String senders_address; 


 // here i will supply the null constructor for you ok? 
 customer() 
 { 
 receiver = ""; 
 sender = ""; 
 int volume=0; 
 double shipping_cost=0; 
 }// null constructor 

 customer (String receiver, String sender) 
 { 
 // ASSIGN THE FIELDS OF THE CONSTRUCTOR HERE BASED ON THE 
                 // INFORMATION PASSED INTO THE METHOD 3 LINES UP 

 }// main constructor 

 public String toString() 
 { 

 //HERE'S THE FUN PART. YOU WILL PRINT A SHIPPING LABEL NOT UNLIKE ONE

 // USED BY UPS OR THE POST OFFICE OR FEDEX. YOU WILL HAVE ON THE
 LABEL 
 // THE NAME AND ADDRESS OF THE SENDER AS WELL AS 
 // THE NAME AND ADDRESS OF THE RECEIVER 
 // AND FINALLY THE CALCULATED COST OF SHIPPING THE ITEM.   
 // REMEMBER YOU 
 // WILL MAKE UP THE FORMULA TO CALCULATE THE COST OF SHIPPING SO
 MAKE 
 // ANY ASSUMPTIONS YOU WANT TO. 
 // AND KEEP YOUR FORMULA RELATIVELY SIMPLE. 


 }//tostring ends here 

 }//customer 

 class FinalExam { 
 public static void main(String args[]) 
 throws IOException 
 { 

 // HERE YOU MAY ENTER YOUR DATA ANY WAY YOU WISH TO.  TRY A FILE 
 // FOR MORE EXTRA CREDIT IF YOU LIKE YOU ARE ABLE TO. 
 // ALSO YOU MAY CHOOSE TO WRITE THE FINISHED LABEL TO 
 //  A FILE IF YOU WANT TO. 
 // REMEMBER THAT THE TOSTRING() WILL BE CALLED FROM THE MAIN
 PROGRAM. 

 // GOOD LUCK !!!!!!!! 

 }//main 

 }//FinalExam



 
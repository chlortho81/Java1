// THINGS TO ADD
// CONSTRUCTORS AND USE SUPER()
// TOSTRING()
// ANY METHODS YOU DEEM NECESSARY
// LOAD THE DATA FROM A FILE LIKE PARSEDEMO3
// INTERFACE ???? ONLY IF YOU WANT.
// NO THREADS !!!!!!


//FINISH THIS PROGRAM

CLASS BOX()
{

INT WIDTH, HEIGHT, DEPTH;


WRITE A METHOD TO CALCULATE THE VOLUME OF THE PACKAGE


}//BOX

CLASS BOXWEIGHT EXTENDS BOX(){

DOUBLE WEIGHT;


}//BOXWEIGHT

CLASS COST() EXTEND BOXWEIGHT{

DOUBLE SHIPPING_COST;
INT SHIPPING_REGION;  // THE  AREA OF THE UNITED STATES THE PARCEL IS GOING TO.

WRITE A METHOD TO CALCULATE THE SHIPPING_COST FOR THIS PACKAGE BASED ON 
THE CALCULATED VOLUME AND ALSO THE WEIGHT. ALSO ADD TO THE COST FOR THE
 SHIPPING_REGION.

}//COST


CLASS CUSTOMER EXTEND COST(){
STRING RECEIVER;
STRING SENDER;


INCORPORATE THE TOSTRING METHOD() TO WRITE OUT A SHIPPING LABEL
WITH THE COST ON IT.

}//CUSTOMER









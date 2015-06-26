import java.io.*;

class Bicycle {
String name;
String address;
int gears;
double price;
char model;
boolean instock;


Bicycle(String name,String address, String gears,
String price, String model, String instock ) {
this.name      = name;
this.address   = address;
this.gears     = Integer.parseInt(gears);
this.price     = Double.valueOf(price).doubleValue();
this.model     = model.charAt(0);
this.instock   = Boolean.valueOf(instock).booleanValue();



}// Bicycle


void nada(){System.out.println("\n this does nothing");}


double nada2(double price, int gears){return gears * price;}

public String toString() {

return("\n your name is "+name+
"\n your address is "+ address+
"\n the number of gears is "+gears+
"\n the price is "+price+
"\n the model is "+model+
"\n in stock "+instock);


}//toString


}// class Bicycle

// FIX THE PROGRAM TO CORRECTLY USE THIS.
// LOAD THE DATA FROM A FILE LIKE R.D
// USE PARSEDEMO3.JAVA FOR ASSISTANCE
// ADD ANY MORE METHODS YOU MAY CHOOSE TO USE
// ASSUME THAT ALL DATA IS SUPPLIED BY THE FILE
// MAYBE JUST MAYBE TRY TO EXTEND THE SHIPMENT CLASS TO
// A CLASS WHICH WILL PROVIDE THE SENDER'S NAME AND ADDRESS 
// AND RECEIVER'S NAME AND ADDRESS
// Extend BoxWeight to include shipping costs.

import java.io.*;

//****************************************
// Start with Box.                       *
//****************************************
class Box {
   double width;
   double height;
   double depth;

//Box methods to GET private box variables
  double get_width()
     {return this.width;}

  double get_height()
     {return this.height;}

  double get_depth()
     {return this.depth;}

//Box methods to SET private box variables
  public void set_width(double w)
     {width=w;}

  public void set_height(double h)
     {height=h;}

  public void set_depth(double d)
     {depth=d;}

  // construct clone of an object
  Box(Box ob) { // pass object to constructor
    width = ob.width;
    height = ob.height;
    depth = ob.depth;
  }//clone constructor

  // constructor used when all dimensions specified
  Box(double w, double h, double d) {
    this.width = w;
    this.height = h;
    this.depth = d;
  }//constructor


// compute and return volume
  double volume() {
    return width * height * depth;
  }//volume method

}//Box


//************************************
// class BOXWEIGHT adds weight.      * 
//************************************
class BoxWeight extends Box {
  double weight; // weight of box

/*
//Boxweight methods to GET boxweight variables
  public double get_weight()
     {return weight;}
//Boxweight methods to SET private boxweight variables
  public void set_weight(double w)
     {weight=w;}

*/
  // construct clone of an object
  BoxWeight(BoxWeight ob) { // pass object to constructor
    super(ob);
    weight = ob.weight;
  }//clone constructor

  // constructor when all parameters are specified
  BoxWeight(double w, double h, double d, double m) {
    super(w, h, d); // call superclass constructor
    weight = m;
  }//constructor    

}//Boxweight

//**************************************
// class SHIPMENT adds shipping costs  * 
//**************************************
class Shipment extends BoxWeight {
  double cost;



//Shipment method to SET shipment variables
  public void set_cost(double c)
     {cost=c;}

  // construct clone of an object
  Shipment(Shipment ob) { // pass object to constructor
    super(ob);
    cost = ob.cost;
  }//clone constructor    

  // constructor when all parameters are specified
  Shipment(double w, double h, double d,
            double m, double c) {
    super(w, h, d, m); // call superclass constructor
    cost = c;
  }//constructor  

//Shipment method to GET shipment variables
  double get_cost()
     {return cost;}

//Shipment methods to GET boxweight variables
   double  get_weight()
     {return weight;}

 /*  get_width();
   get_height();
   get_depth();
   set_width(double width);
   set_height(double height);
   set_depth(double depth);
*/

//Shipment methods to GET box variables
  double  get_width()
     {return width;}

  double  get_height()
     {return height;}

  double  get_depth()
     {return depth;}

//Shipment methods to SET box variables
  public void  set_width(double w)
     {width=w;}

  public void  set_height(double h)
     {height=h;}

  public void  set_depth(double d)
     {depth=d;}

//Shipment methods to SET private boxweight variables
  public void  set_weight(double w)
     {weight=w;}  


public String toString(){


return("\n here it is   "+width+height+depth+weight+cost);



}//toString




}//Shipment
  
class ds{
  public static void main(String args[])
  throws IOException   {
    BufferedReader inData = new BufferedReader(new InputStreamReader(System.in));
	
    double vol;
    String str_width;
    String str_height;
    String str_depth;
    String str_weight;
    String str_cost;
// the scope of the object is important !!!
Shipment shipment1 = new Shipment(10, 20, 15, 10, 3.41);
Shipment shipment2= new Shipment(shipment1);
   
 do {
     
 str_width  =  inData.readLine();
 str_height =  inData.readLine();
 str_depth  =  inData.readLine();
 str_weight =  inData.readLine();
 str_cost   =  inData.readLine();

      try {

shipment1.set_width(Double.valueOf(str_width).doubleValue());
shipment1.set_height(Double.valueOf(str_height).doubleValue());
shipment1.set_depth(Double.valueOf(str_depth).doubleValue());
shipment1.set_weight(Double.valueOf(str_weight).doubleValue());
shipment1.set_cost(Double.valueOf(str_cost).doubleValue());
 
shipment2.set_width(Double.valueOf(str_width).doubleValue());
shipment2.set_height(Double.valueOf(str_height).doubleValue());
shipment2.set_depth(Double.valueOf(str_depth).doubleValue());
shipment2.set_weight(Double.valueOf(str_weight).doubleValue());
shipment2.set_cost(Double.valueOf(str_cost).doubleValue());

      } 
        catch(NumberFormatException e) { 
     System.out.println("Invalid format"+ e);
     shipment1.set_width(0.0);  
     shipment1.set_height(0.0);
     shipment1.set_depth(0.0);
     shipment1.set_weight(0.0);
     shipment1.set_cost(0.0);

     shipment2.set_width(0.0);  
     shipment2.set_height(0.0);
     shipment2.set_depth(0.0);
     shipment2.set_weight(0.0);
     shipment2.set_cost(0.0);	
      } 

    }
    while(shipment1.get_width() != -1.0);
	
    vol = shipment1.volume();
    System.out.println("Volume of shipment1 is " + vol);
    System.out.println("Weight of shipment1 is "
                        + shipment1.get_weight());
    System.out.println("Shipping cost: $" + shipment1.get_cost());
    System.out.println();


    vol = shipment2.volume();
    System.out.println("Volume of shipment2 is " + vol);
    System.out.println("Weight of shipment2 is "
                        + shipment2.get_weight());
    System.out.println("Shipping cost: $" + shipment2.get_cost());
    System.out.println();

  } //close4
} //close5


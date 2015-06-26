

//Integrated Program----combines CreatInput, ReadOutput, and PrintOutput
// all in one program


import java.io.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;

class CreateInput extends Frame
             implements ActionListener {

   // TextFields where user enters account number, first name,
   // last name and balance.
   private TextField senderField, senderAddressField,
		senderCityStateZipField, weightField,
                     heightField, widthField,
			lengthField, zip2Field,
			receiveField,	receiveAddressField,
			receiveCityStateZipField, receiveZip2Field;

   private Button enter,  // send record to file
                  done;   // quit program

   // Application other pieces
   private DataOutputStream output;  

   public CreateInput()
   {
      super( "Sender & Package Information" );

      // Open the file
      try {
         output = new DataOutputStream(
                      new FileOutputStream( "sender.dat" ) );
      }
      catch ( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }      

      setSize( 500, 350 );
    setLayout( new GridLayout( 13,2 ) );

      // create the components of the Frame
      add( new Label( "Sender Name" ) );
      senderField = new TextField(25);
      add( senderField );

      add( new Label( "Sender Address" ) );
      senderAddressField = new TextField(25);
      add( senderAddressField );

      add( new Label( "Sender City,State & Zip" ) );
      senderCityStateZipField = new TextField(25);
      add( senderCityStateZipField );

      add( new Label( "Package Weight" ) );
      weightField = new TextField( 20 );
      add( weightField );      

      add( new Label( "Package Height" ) );
      heightField = new TextField( 20 );
      add( heightField );

      add( new Label( "Package Width" ) );
      widthField = new TextField( 20 );
      add( widthField );

       add( new Label( "Package Length" ) );
      lengthField = new TextField( 20 );
      add( lengthField );

      add( new Label( "1st 2 digits of zip code" ) );
      zip2Field = new TextField( 4 );
      add( zip2Field );

       add( new Label( "Receiver's Name" ) );
      receiveField = new TextField( 25 );
      add( receiveField );

       add( new Label( "Receiver's Address" ) );
      receiveAddressField = new TextField( 25 );
      add( receiveAddressField );

       add( new Label( "Receiver's City, State & Zip" ) );
      receiveCityStateZipField = new TextField( 25 );
      add( receiveCityStateZipField );

       add( new Label( "Receivers 1st 2 digits of Zip" ) );
      receiveZip2Field = new TextField( 20 );
      add( receiveZip2Field );


     enter = new Button( "Enter" );
      enter.addActionListener( this );
      add( enter );      


      done = new Button( "Done" );
      done.addActionListener( this );
      add( done );       

      setVisible( true );  
   }

   public void addRecord()
   {
      int zip2Number = 0;
	int rzip2Number = 0;
      Double d,e,f,g;  //use to pass all doubles to appropriate text

      if ( ! zip2Field.getText().equals( "" ) ) {

         // output the values to the file
         try {
            zip2Number =
               Integer.parseInt( zip2Field.getText() );

            if ( zip2Number > 0 ) {
               output.writeUTF( senderField.getText() );
		output.writeUTF( senderAddressField.getText() );
		output.writeUTF( senderCityStateZipField.getText() );

               d = new Double ( weightField.getText() );
               output.writeDouble( d.doubleValue() );

              e = new Double ( heightField.getText() );
              output.writeDouble( e.doubleValue() );

               f = new Double ( lengthField.getText() );
               output.writeDouble( f.doubleValue() );

               g = new Double ( zip2Field.getText() );
               output.writeDouble( g.doubleValue() );
	
		output.writeInt( zip2Number);  //changed from writeDouble

		output.writeUTF( receiveField.getText() );
		output.writeUTF( receiveAddressField.getText() );
		output.writeUTF( receiveCityStateZipField.getText() );
		
		rzip2Number = 
			Integer.parseInt( receiveZip2Field.getText() );
		output.writeInt( rzip2Number );  //changed from writeDouble
            }

            // clear the TextFields
            senderField.setText( "" );
            weightField.setText( "" );
            heightField.setText( "" );
            lengthField.setText( "" );
		widthField.setText( "" );
		zip2Field.setText ( "" );
		senderAddressField.setText ( "" );
		senderCityStateZipField.setText ( "" );
		receiveField.setText( "" );
		receiveAddressField.setText( "" );
		receiveCityStateZipField.setText( "" );
		receiveZip2Field.setText( "" );
         }
         catch ( NumberFormatException nfe ) {
            System.err.println(
               "Entry Error---recheck for proper entries!" );
         }
         catch ( IOException io ) {
            System.err.println(
               "Error during write to file\n" +
               io.toString() );
            System.exit( 1 );
         }
      }
   }

public void actionPerformed( ActionEvent e )
   {
      addRecord();

      if ( e.getSource() == done ) {
         try {
            output.close();
         }
         catch ( IOException io ) {
            System.err.println( "File not closed properly\n" +
                                io.toString() );
         }

         System.exit( 0 );
      }
   }
}//End CreateInput
//---------------------------------------------------------------------------------

class ReadOutput extends Frame
             implements ActionListener {

   // TextFields to display account number, first name,
   // last name and balance.
   private TextField senderField, senderAddressField,
		senderCityStateZipField, weightField,
                     heightField, widthField,
			lengthField, zip2Field,
			receiveField,	receiveAddressField,
			receiveCityStateZipField, receiveZip2Field;

   private Button next,   // get next record in file
                  done;   // quit program

   // Application other pieces
   private DataInputStream input;

   // Constructor -- initialize the Frame 
   public ReadOutput()
   {
      super( "Read Client File" );

      // Open the file
      try {
         input = new DataInputStream(
                     new FileInputStream( "sender.dat" ) );
      }
      catch ( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }      

      setSize( 500, 350 );
      setLayout( new GridLayout( 13, 2 ) );

      // create the components of the Frame

     add( new Label( "Sender Name" ) );
      senderField = new TextField(25);
	senderField.setEditable( false );
      add( senderField );

      add( new Label( "Sender Address" ) );
      senderAddressField = new TextField(25);
	senderAddressField.setEditable( false );
      add( senderAddressField );

      add( new Label( "Sender City,State & Zip" ) );
      senderCityStateZipField = new TextField(25);
	senderCityStateZipField.setEditable( false );
      add( senderCityStateZipField );

      add( new Label( "Package Weight" ) );
      weightField = new TextField( 20 );
	weightField.setEditable( false );
      add( weightField );      

      add( new Label( "Package Height" ) );
      heightField = new TextField( 20 );
	heightField.setEditable( false );
      add( heightField );

      add( new Label( "Package Width" ) );
      widthField = new TextField( 20 );
	widthField.setEditable( false );
      add( widthField );

       add( new Label( "Package Length" ) );
      lengthField = new TextField( 20 );
	lengthField.setEditable( false );
      add( lengthField );

      add( new Label( "1st 2 digits of zip code" ) );
      zip2Field = new TextField( 4 );
	zip2Field.setEditable( false );
      add( zip2Field );

       add( new Label( "Receiver's Name" ) );
      receiveField = new TextField( 25 );
	receiveField.setEditable( false );
      add( receiveField );

       add( new Label( "Receiver's Address" ) );
      receiveAddressField = new TextField( 25 );
	receiveAddressField.setEditable( false );
      add( receiveAddressField );

       add( new Label( "Receiver's City, State & Zip" ) );
      receiveCityStateZipField = new TextField( 25 );
	receiveCityStateZipField.setEditable( false );
      add( receiveCityStateZipField );

       add( new Label( "Receivers 1st 2 digits of Zip" ) );
      receiveZip2Field = new TextField( 20 );
	receiveZip2Field.setEditable( false );
      add( receiveZip2Field );

      next = new Button( "Next" );
     next.addActionListener( this );
      add( next );      

      done = new Button( "Done" );
      done.addActionListener( this );
      add( done );       

      setVisible( true );  
   }

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == next )
         readRecord();
      else
         closeFile();
   }

   public void readRecord()
   {
      int zip2,rzip2;
      String sName,sAddress,sCityStateZip,rName,rAddress,rCityStateZip;
      double weight,height,length,width;

      // input the values from the file
      try {

         sName = input.readUTF();
         sAddress = input.readUTF();
	sCityStateZip = input.readUTF();
	weight = input.readDouble();
	height = input.readDouble();
	width = input.readDouble();
	length = input.readDouble();
	zip2 = input.readInt();
	
	rName = input.readUTF();
	rAddress = input.readUTF();
	rCityStateZip = input.readUTF();
	rzip2 = input.readInt();


	senderField.setText(sName );
	senderAddressField.setText( sAddress) ;
	senderCityStateZipField.setText( sCityStateZip) ;
	weightField.setText( String.valueOf( weight ) );
	heightField.setText( String.valueOf( height ) );
	widthField.setText( String.valueOf( width ) );
	lengthField.setText( String.valueOf( length ) );
	zip2Field.setText( String.valueOf( zip2) );
	receiveField.setText( rName ) ;
	receiveAddressField.setText(rAddress );
	receiveCityStateZipField.setText( rCityStateZip) ;
	receiveZip2Field.setText( String.valueOf (rzip2));
	

      }
      catch ( EOFException eof ) {
         closeFile();
      }
      catch ( IOException e ) {
         System.err.println( "Error during read from file\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }

   private void closeFile()
   {
      try {
         input.close();
         System.exit( 0 );
      }
      catch ( IOException e ) {
         System.err.println( "Error closing file\n" +
                             e.toString() );
         System.exit( 1 );
      }
   }


}//End ReadOutput class


//---------------------------------------------------------------------------------
// Start with Box.
class Box {
    double width;
    double height;
    double depth;

// construct clone of an object
  Box(Box ob) { // pass object to constructor
    width = ob.width;
    height = ob.height;
    depth = ob.depth;
  }

// constructor used when all dimensions specified
  Box(double w, double h, double d) {
    width = w;
    height = h;
    depth = d;
  }

// constructor used when no dimensions specified
  Box() {
    width = -1;  // use -1 to indicate
    height = -1; // an uninitialized
    depth = -1;  // box
  }

  // constructor used when cube is created
  Box(double len) {
    width = height = depth = len;
  }

    // compute and return volume
  double volume() {
    return width * height * depth;
  }
}//End Box Class

//-------------------------------------------------------------------
// BoxWeight class-->adds weight to box

class BoxWeight extends Box {
  double weight; // weight of box

  // construct clone of an object
  BoxWeight(BoxWeight ob) { // pass object to constructor
    super(ob);
    weight = ob.weight;
  }

  // constructor when all parameters are specified
  BoxWeight(double w, double h, double d, double m) {
    super(w, h, d); // call superclass constructor
    weight = m;
  }    

  // default constructor
  BoxWeight() {
    super();
    weight = -1;
  }

  // constructor used when cube is created
  BoxWeight(double len, double m) {
    super(len);
    weight = m;
  }
}//End BoxWeightClass

//------------------------------------------------------------------------------------
// Add shipping costs---Shipment Class
class Shipment extends BoxWeight {
  double cost;

  // construct clone of an object
  Shipment(Shipment ob) { // pass object to constructor
    super(ob);
    cost = ob.cost;
  }

  // constructor when all parameters are specified (cost is calculated)
  Shipment(double w, double h, double d,
            double m) {
    super(w, h, d, m); // call superclass constructor
    cost = CostCalculation(volume(),m);  //calculate cost
  }    

  // default constructor
  Shipment() {
    super();
    cost = -1;
  }

  // constructor used when cube is created
  Shipment(double len, double m) {
    super(len, m);
    cost  = CostCalculation(volume(),m);  //calculate cost;
  }

//cost calculator---only for weight and volume (see customer class to include distance) 
double CostCalculation(double volume, double weight){
	double volume_cost;
	double weight_cost;
	if (volume < 10){
	    volume_cost = 2;}
	else{
	    if((volume >= 10) || (volume <=100)){
		volume_cost = 5;}
	    else{
		volume_cost = 10;}
	}
	weight_cost = 0.253*weight;
	return(volume_cost + weight_cost);
    }
}//End Shipment Class 

//------------------------------------------------------------------------------
//Customer class
//      -incorporates name & address info (for the toString)
//	-includes a toString to return a string that is a label
//	-includes CustomerCost() which adjust shipping cost based
// 	  on distance (due to start of zip code)

class Customer extends Shipment {
    String senderName;
    String senderAddress;
    String senderCityStateZip;
    int senderBeginZip;
    String receiveName;
    String receiveAddress;
    String receiveCityStateZip;
    int receiveBeginZip;

  // construct clone of an object
  Customer(Customer ob) { // pass object to constructor
    super(ob);
    senderName = ob.senderName;
    senderAddress = ob.senderAddress;
    senderCityStateZip= ob.senderCityStateZip;
    senderBeginZip= ob.senderBeginZip;
    receiveName = ob.receiveName;
    receiveAddress =  ob. receiveAddress;
    receiveCityStateZip = ob.receiveCityStateZip;
    receiveBeginZip = ob.receiveBeginZip;
    cost = CustomerCost(weight,volume(),senderBeginZip,receiveBeginZip);
  }

  // constructor when all parameters are specified
  Customer(double w, double h, double d,
            double m, String sn, String sa, String scsz,
	   int sbz, String rn, String ra, String rcsz, int rbz ) {
    super(w, h, d, m); // call superclass constructor
    this.senderName = sn;
    this.senderAddress = sa;
    this.senderCityStateZip = scsz;
    this.senderBeginZip = sbz;
    this.receiveName = rn;
    this.receiveAddress = ra;
    this.receiveCityStateZip = rcsz;
    this.receiveBeginZip = rbz;
    cost = CustomerCost(weight,volume(),senderBeginZip,receiveBeginZip);
 }  

  // default constructor
  Customer() {
    super();    
    this.senderName = "";
    this.senderAddress = "";
    this.senderCityStateZip = "";
    this.senderBeginZip = -1;
    this.receiveName = "";
    this.receiveAddress = "";
    this.receiveCityStateZip = "";
    this.receiveBeginZip = -1;
    cost = 0.0;
    
  }

  // constructor used when cube is created
  Customer(double len, double m, String sn, String sa, String scsz,
	   int sbz, String rn, String ra, String rcsz, int rbz ) {
    super(len, m);
    this.senderName = sn;
    this.senderAddress = sa;
    this.senderCityStateZip = scsz;
    this.senderBeginZip = sbz;
    this.receiveName = rn;
    this.receiveAddress = ra;
    this.receiveCityStateZip = rcsz;
    this.receiveBeginZip = rbz;
    cost = CustomerCost(weight,volume(),senderBeginZip,receiveBeginZip);
  }

    //toString:  purpose:  print out label
 public   String toString(){
	//insure that cost has been calculated before label is created.
	double cost = CustomerCost(volume(), weight, senderBeginZip, receiveBeginZip);   
	String formatted_cost;
	String Line1;
	String Line2;
	String Line3;
	String Receive_spacer;
	String Line4;
	String Line5;
	String Line6;
	int item1_length;
	int item2_length;
	int item3_length;
	
	//create Line1
	item1_length = senderName.length();  //calculate sender name length
	DecimalFormat item = new DecimalFormat("#,###.##");  //declare DecimalFormat
	cost += 0.004999;   //round for truncation (will bring anything over .005 to next penny)	
	formatted_cost = item.format(cost);      //convert to proper size
	item3_length = formatted_cost.length();   
	//make each printed line 66 spaces long
	item2_length = 65 - (item1_length + item3_length);
	int i;
	Line1 = new String(senderName);
	for(i = 0; i < item2_length; i++){    //loop to add appropriate number of spaces
		Line1 = AddSpace(Line1);}     //access AddSpace() method
	Line1 = Line1.concat("$");
	Line1 = Line1.concat(formatted_cost);
	Line1 = Line1.concat("\n");
	
	//create Line2
	Line2 = senderAddress;
	Line2 = Line2.concat("\n");

	//create Line3
	Line3 = senderCityStateZip;
	Line3 = Line3.concat("\n");

	//want to center the address based on the longest item
	if((receiveName.length())>(receiveAddress.length())){
		item2_length = receiveName.length();}
	else{
		item2_length = receiveName.length();}
	if((receiveCityStateZip.length())>(receiveName.length())){
		item2_length = receiveCityStateZip.length();}
	

	//create Line4
	item1_length = 33 - ((int)(item2_length/2));
	Receive_spacer = new String();
	for(i = 0; i < item1_length; i++){
		Receive_spacer = AddSpace(Receive_spacer);}
	Line4 = Receive_spacer.concat(receiveName);
	Line4 = Line4.concat("\n");

	//create Line5
	Line5 = Receive_spacer.concat(receiveAddress);
	Line5 = Line5.concat("\n");

	//create Line6
	Line6 = Receive_spacer.concat(receiveCityStateZip);
	Line6 = Line6.concat("\n");

	String Outstring = Line1.concat(Line2.concat(Line3.concat("\n\n")));
	Outstring = Outstring.concat(Line4.concat(Line5.concat(Line6)));
	Outstring = (Outstring + "\n\n-----------------------------------------");
	Outstring = (Outstring + "-------------------------");
	return Outstring;
	    }//end toString

//Method to add spaces to a string, returning new string with added space
public String AddSpace(String x){
	String q = x.concat(" ");
	return q;
	}


    //new Calculation of Cost including distance (zip)
public  double CustomerCost(double volume, double weight,int senderBeginZip, int receiveBeginZip){
	double v = volume;
	double w = weight;
	double zip_multiplier = 0.0;
	int zip_distance = 0;
	double original_cost = CostCalculation(v,w);
	//add in cost for areas....
	zip_distance = senderBeginZip - receiveBeginZip;
	if(zip_distance < 0){    //change sign if < 0
		zip_distance *= -1;}
	
	if(zip_distance < 25){
		zip_multiplier = 0.95;}
	else
		if(zip_distance < 50){
			zip_multiplier = 1.10;}
		else
			if(zip_distance < 75){
				zip_multiplier = 1.25;}
			else{
				zip_multiplier = 1.45;}
	return(zip_multiplier*(original_cost));
    }
}//end Customer Class

//----------------------------------------------------------------------------------------
//class to read file and print out items in label format from the Customer toString
class PrintOutput
	{
   // TextFields to display account number, first name,
   // last name and balance.

   private DataInputStream input;

//constructor --in this case includes a loop to process and print all items
//in the file that is opened
   public PrintOutput()
   {
 

     // Open the file
      try {
         input = new DataInputStream(
                     new FileInputStream( "sender.dat" ) );
      }
      catch ( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }      

   for(;;){
      int zip2,rzip2;
      String sName,sAddress,sCityStateZip,rName,rAddress,rCityStateZip;
      double weight,height,length,width;

      // input the values from the file
      try {

         sName = input.readUTF();
         sAddress = input.readUTF();
	sCityStateZip = input.readUTF();
	weight = input.readDouble();
	height = input.readDouble();
	width = input.readDouble();
	length = input.readDouble();
	zip2 = input.readInt();
	
	rName = input.readUTF();
	rAddress = input.readUTF();
	rCityStateZip = input.readUTF();
	rzip2 = input.readInt();

	
	//Create a new Customer Object!!!
	Customer customer1 = new Customer(width,height,length,weight,sName,sAddress,sCityStateZip,zip2,rName,rAddress,rCityStateZip,rzip2);
	System.out.println( customer1 );   //Print the customer object shipping label
	
     }
      catch ( EOFException eof ) {
       
	closeFile();
      }
      catch ( IOException e ) {
         System.err.println( "Error during read from file\n" +
                             e.toString() );
         System.exit( 1 );
      }
	}//end Loop
   }//end Constructor

   private void closeFile()
   {
      try {     
	input.close();
        System.exit( 0 );
      }
      catch ( IOException e ) {
         System.err.println( "Error closing file\n" +
                             e.toString() );
         System.exit( 1 );
      }
  
}
}//end class


//-----------------------------------------------------------------------------------------

class Shipper extends Frame implements ActionListener {
   Button creates,reads,prints,exits;
public Shipper(){


	
	super("Customer-Package Tracking System");


      setSize( 500, 150 );
      setLayout( new GridLayout( 1, 4 ) );

     creates = new Button( "Create Customers" );
      creates.addActionListener( this );
      add( creates );      

     reads = new Button( "View Customers" );
      reads.addActionListener( this );
      add( reads );      

     prints = new Button( "Print Labels" );
      prints.addActionListener( this );
      add( prints );      

     exits = new Button( "Exit" );
      exits.addActionListener( this );
      add( exits );      

      setVisible( true );  
}//end Shipper constructor

     public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == creates )
         new CreateInput();
else if ( e.getSource() == reads )
	new ReadOutput();
else if ( e.getSource() == prints )
	new PrintOutput();      
else
	       System.exit( 0 );
   }


public static void main( String args[] )
{
      new Shipper();
   }
   
}//end class Shipper



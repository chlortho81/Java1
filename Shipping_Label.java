import java.io.*;         //input output
import java.awt.*;        //bottons, textfields
import java.text.*;       //shipping cost decimal place
import java.awt.event.*;  //action listener

class box  //constructs height, width, depth, and has method to calculate volume
{
	
int height, width, depth; 
	
box()
	{
		height = width = depth = 0;
	}


box(int height, int width, int depth)
	{
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

double calc_volume()
	{
		return height * width * depth;
	}
	
}

 

class boxweight extends box //inherits the box class's attributes, calls super to box for contructor, and contructs weight 
{

double weight;

boxweight()
	{
		super();
		weight = 0;
	}

boxweight(int height, int width, int depth, double weight)
	{
		super(height, width, depth); 
		this.weight = weight; 
	}

}


class cost extends boxweight //inherits the box_weight classes attributes (which inherits box), calls super to box_weight for contructor,
							 //contructs shipping_region, and has method to calculate shipping cost 
{

int shipping_region;

cost()
	{
		super();
		shipping_region = 0;
	}

cost (int shipping_region, int height, int width, int depth, double weight)
	{
		super(height, width, depth, weight);
		this.shipping_region = shipping_region;
	}

double calc_shipping_cost(double volume, double weight, int shipping_region)
	{
		double size = (volume * .2) * (weight * .2);
		
        switch (shipping_region) 
			{
				case 1:
					return size * 2.25;
				case 2:
					return size * 3.75;
				case 3:
					return size * 5.50;
				case 4:
					return size * 7.50;
				case 5:
					return size * 10.25;
				default:
					return 999999;
			}
	
	}

}

class customer extends cost //inherits the cost classes attributes, which in turn inherits box_weight, which in turn inherits box, so now all data is linked.
							//calls super to cost for constructor, constructs string variables, volume and cost
							//contains toString (for printing label) 
{

String sender;
String sender_street;
String sender_zip;
String receiver; 
String receiver_street;
String receiver_zip; 
double volume = 0;
double cost = 0;

customer()
	{
		super();
		receiver = "";
		receiver_street = "";
		receiver_zip = "";
		sender = "";
		sender_street = "";
		sender_zip = "";
	}

customer (String send, String send_street, String send_zip, String receive, String receive_street, String receive_zip, int ship_region, int h, int w, int d, double box_weight)
	{ 
		super(ship_region, h, w, d, box_weight);
		
		this.sender = send;
		sender_street = send_street;
		sender_zip = send_zip;
		receiver = receive;
		receiver_street = receive_street;
		receiver_zip = receive_zip;
		shipping_region = ship_region;
		height = h;
		width = w;
		depth = d;
		weight = box_weight;
		
		volume = calc_volume();
		
		cost = calc_shipping_cost(volume, weight, shipping_region);
	}

public String toString()
	{
		return 
		(
			"\n" +sender+"                                         Shipping: $" +cost+
			"\n" +sender_street+
			"\n" +sender_zip+
			"\n\n\n"+
			"\n                           " +receiver+
			"\n                           " +receiver_street+
			"\n                           " +receiver_zip	
		);
	}

}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Shipping_Information extends Frame implements ActionListener

//This class extends Frame allowing us to create a frame and label it, and implements action listenener to listen for a click of the button
//Creates various text fields for entering data, opens a file, and writes data to file. 

{

   private TextField sender, sender_street, sender_zip, receiver, receiver_street, receiver_zip, 
		   shipping_region, height, width, depth, weight;

   private Button enter;

   private DataOutputStream output;  

   public Shipping_Information()
   {
      super( "Shipping Information" );

      try {
         output = new DataOutputStream(
                      new FileOutputStream( "shipping.dat" ) );
      }
      catch ( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }      

      setSize( 400, 450 );
      setLayout( new GridLayout( 16, 2 ) );

      add( new Label( "Sender's Name" ) );
      sender = new TextField();
      add( sender );

      add( new Label( "Street Address"));
      sender_street = new TextField( 230 );
      add(  sender_street );      

      add( new Label( "State, City, and Zip") );
      sender_zip = new TextField( 30 );
      add(  sender_zip );

      add (new Label(""));
	  add (new Label(""));
	  
	  add( new Label( "Receiver's Name" ) );
      receiver = new TextField( 30 );
      add( receiver );

      add( new Label( "Street Address" ) );
      receiver_street = new TextField( 30 );
      add( receiver_street );
	  
	  add( new Label( "State, City, and Zip") );
      receiver_zip = new TextField( 30 );
      add(  receiver_zip );
	  
	  add (new Label(""));
	  add (new Label(""));
	  
	  add( new Label( "Shipping Region 1-5") );
	  shipping_region = new TextField( 1 );
      add(  shipping_region );
	  
	  add (new Label(""));
	  add (new Label(""));
	  
	  add(new Label("Box Height"));
      height = new TextField( 30 );
      add( height );

      add( new Label( "Width"));
      width = new TextField( 30 );
      add( width );

      add( new Label( "Depth" ) );
      depth = new TextField( 30 );
      add( depth );
	  
	  add( new Label( "Weight") );
      weight = new TextField( 30 );
      add( weight );
	  
	  add (new Label(""));
	  add (new Label(""));
      add (new Label(""));
	  
	  enter = new Button( "Enter" );
      enter.addActionListener( this );
      add( enter );

      setVisible( true );  
   }



   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == enter ) addRecord();
   }




   public void addRecord()
    {
      int ship_region = 0, h = 0, w = 0, d = 0;
      Double box_weight;

		if ( ! sender.getText().equals( "" ) ) 
		{			
			try
			{
				ship_region = Integer.parseInt( shipping_region.getText() );
				h = Integer.parseInt( height.getText() );
				w = Integer.parseInt( width.getText() );
				d = Integer.parseInt( depth.getText() ); 
			
			//??try catch for double w?
				output.writeUTF( sender.getText() );
				output.writeUTF(  sender_street.getText() );
				output.writeUTF(  sender_zip.getText() );
				output.writeUTF( receiver.getText() );
				output.writeUTF(  receiver_street.getText() );
				output.writeUTF(  receiver_zip.getText() );
				output.writeInt( ship_region );
				output.writeInt( h );
				output.writeInt( w );
				output.writeInt( d );
				box_weight = new Double ( weight.getText() );
				output.writeDouble( box_weight.doubleValue() );
				
				sender.setEditable( false );   
				sender_street.setEditable( false );
				sender_zip.setEditable( false );
				receiver.setEditable( false );
				receiver_street.setEditable( false );
				receiver_zip.setEditable( false );
				shipping_region.setEditable( false );
				height.setEditable( false );
				width.setEditable( false );
				depth.setEditable( false );
				weight.setEditable( false );

			}
			
			catch ( NumberFormatException nfe ) 
			{
				System.err.println("You must enter an integer value for shipping region, height, width, and depth." );
			}
			
			catch ( IOException io ) 
			{
				System.err.println("Error during write to file\n" + io.toString() );
				System.exit( 1 );
			}
        }
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Display
{

//This class reads the data from the file and creates a new object of class customer for calculating shipping cost and printing label

customer shipment;

private DataInputStream input;


Display()
	{
		try 
		{
			input = new DataInputStream(new FileInputStream ( "shipping.dat" ) );
		}
		catch ( IOException e ) 
		{
			System.err.println( "File not opened properly\n" + e.toString() );
			System.exit( 1 );
		}
		
		readRecord();
	}

	public void readRecord()
	{
	String send, send_street, send_zip, receive, receive_street, receive_zip;
	int ship_region, h, w, d;
	double box_weight;

		try 
		{
			send = input.readUTF();
	        send_street = input.readUTF();
			send_zip = input.readUTF();
			receive = input.readUTF();
			receive_street = input.readUTF();
			receive_zip = input.readUTF();
			ship_region = input.readInt();
			h = input.readInt();
			w = input.readInt();
			d = input.readInt();
	        box_weight = input.readDouble();
	    
shipment = new customer (send, send_street, send_zip, receive, receive_street, receive_zip, ship_region, h, w, d, box_weight);
        
		System.out.println(shipment);
		}     
		
		catch ( EOFException eof ) 
		{
			closeFile();
		}
		catch ( IOException e ) 
		{
			System.err.println( "Error during read from file\n" + e.toString() );
			System.exit( 1 );
		}
	}

	private void closeFile()
	{
		try 
		{
			input.close();
			System.exit( 0 );
		}
		catch ( IOException e ) 
		{
			System.err.println( "Error closing file\n" +e.toString() );
			System.exit( 1 );
		}
   }
	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Shipping_Label extends Frame implements ActionListener 
{

//This class is our initial pop up window.  It allows us to choose to enter our data (which calls Shipping_Information),  and then to print the label (which calls Display).

Button creates,prints;

	public Shipping_Label()
	{
		super("United Poopy Service");

		setSize( 250, 75 );
		setLayout( new GridLayout( 1, 2 ) );

		creates = new Button( "Enter Data" );
		creates.addActionListener( this );
		add( creates );      

		prints = new Button( "Print Label" );
		prints.addActionListener( this );
		add( prints );                  

		setVisible( true );  
	}

    public void actionPerformed( ActionEvent e )
    {
		if ( e.getSource() == creates ) new Shipping_Information();
		else if ( e.getSource() == prints )
		{
			new Display();  
			System.exit( 0 );
		}
    }

public static void main(String args[]) //main
throws IOException
	{
		new Shipping_Label();
	}
}
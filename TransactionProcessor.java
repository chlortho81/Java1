//Michael Stephenson, fixed version
// Fig. 15_14: TransactionProcessor.java
// Transaction processing program using RandomAccessFiles.

// This program reads a random access file sequentially,
// updates data already written to the file, creates new
// data to be placed in the file, and deletes data
// already in the file.
//This version works, Tuesday 5/2 08:30

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;

public class TransactionProcessor extends Frame
             implements ActionListener {

   // Application window components
     Button update,    // update record
                  newRecord, // add new record
                  delete,    // delete record
                  done;      // quit program

     UpdateDialog updateDialog; // record update
     NewDialog newDialog;       // add new records
     DeleteDialog deleteDialog; // delete records

   // Application other pieces
     private RandomAccessFile file;
     private Record data;
     String fileName = "credit.dat";

   // Constructor -- intialize the Frame
   public TransactionProcessor()
   {
      super( "Transaction Processor" );

      // Open the file
      try {
         file = new RandomAccessFile( fileName, "rw" );
      }
      catch ( IOException ioe ) {
         System.err.println( ioe.toString() );
         System.exit( 1 );
      }

      System.out.println("File opened successfully for read/write.");

      data = new Record();

      setSize( 300, 80 );
      setLayout( new GridLayout( 2, 2 ) );

      update = new Button( "Update Record" );
      update.addActionListener( this );
      add( update );

      newRecord = new Button( "New Record" );
      newRecord.addActionListener( this );
      add( newRecord );

      delete = new Button( "Delete Record" );
      delete.addActionListener( this );
      add( delete );

      done = new Button( "Done" );
      done.addActionListener( this );
      add( done );

      setVisible( true );             // show the Frame

      // Create dialog boxes
      updateDialog = new UpdateDialog( this, file );
      newDialog = new NewDialog( this, file );
      deleteDialog = new DeleteDialog( this, file );
   }

   // Process actions
   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == update )
         updateDialog.setVisible( true );
      else if ( e.getSource() == newRecord )
         newDialog.setVisible( true );
      else if ( e.getSource() == delete )
         deleteDialog.setVisible( true );
      else
         closeFile();
   }

   public void closeFile()
   {
      try {
         file.close();
         System.exit( 0 );
      }
      catch ( IOException ioe ) {
         System.err.println( ioe.toString() );
         System.exit( 1 );
      }
   }

   public static void main( String args[] )
   {
      new TransactionProcessor();
   }
}

class UpdateDialog extends Dialog implements ActionListener {
     TextField account, firstName, lastName,
                     balance, transaction;
     Button cancel, save, search;

     private RandomAccessFile file;
     private Record data;
     int accountNumber;

   public UpdateDialog( TransactionProcessor t,
                        RandomAccessFile f )
   {
      super( t, "Update Record", true );

     file = f;
      data = new Record();

      setSize( 320, 180 );
      setLayout( new GridLayout( 7, 2 ) );

      add( new Label( "Account" ) );
      account = new TextField();
      account.addActionListener( this );
      add( account );

      add( new Label( "First name" ) );
      firstName = new TextField();
      add( firstName );

      add( new Label( "Last name" ) );
      lastName = new TextField();
      add( lastName );

      add( new Label( "Balance name" ) );
      balance = new TextField();
      balance.setEditable(false);
      add( balance );

      add( new Label( "Transaction amount" ) );
      transaction = new TextField();
      transaction.addActionListener( this );
      add( transaction );

      search = new Button( "Search" );
	  search.addActionListener( this );
      add( search );

      save = new Button( "Save Changes" );
      save.addActionListener( this );
      add( save );

      cancel = new Button( "Cancel" );
      cancel.addActionListener( this );
      add( cancel );
   }

   public void actionPerformed( ActionEvent e )
   {
      String errMsg = "Error from actionPerformed(): ";

      if ( e.getSource() == search ) {
         try{
         accountNumber = Integer.parseInt( account.getText() );
	     }catch(NumberFormatException n){
		  System.out.println(errMsg + n);
		  account.setText(errMsg + n);
		  return;
	     }

         readAccountInformation();
      }
      else if ( e.getSource() == save )  {
         accountNumber = Integer.parseInt( account.getText() );
         updateAccountInformation();
      }
      else if ( e.getSource() == cancel ) {
         setVisible( false );
         clear();
      }
      else if ( e.getSource() == transaction ) {
         DecimalFormat twoDigits = new DecimalFormat( "0.00" );
         Double transactionAmount =
                   Double.valueOf( transaction.getText() );
         data.setBalance(
            data.getBalance() + transactionAmount.doubleValue() );
         balance.setText( twoDigits.format( data.getBalance() ) );
      }
   }

     void readAccountInformation()
   {

      refresh();

      DecimalFormat twoDigits = new DecimalFormat( "0.00" );

      if ( accountNumber < 1 || accountNumber > 100 ) {
         account.setText( "Invalid account" );
         return;
      }

      try {
         file.seek( ( accountNumber - 1 ) * Record.size() );
         data.read( file );

         if ( data.getAccount() != 0 ) {
            account.setText( String.valueOf( data.getAccount() ) );
            firstName.setText( data.getFirstName() );
            lastName.setText( data.getLastName() );
            balance.setText( twoDigits.format(
                                data.getBalance() ) );
            transaction.setText( "charge(+) or payment(-)" );
         }
         else
            account.setText( String.valueOf( accountNumber ) +
                          " does not exist" );
         }
      catch ( IOException ioe ) {
         account.setText( "Error reading file" );
      }
   }

     void updateAccountInformation(){


	  double transactionAmt;

      //validate information for transaction amount;

      try{
		  transactionAmt = new Double(transaction.getText()).doubleValue();


  	   }catch(NumberFormatException nfe){

			account.setText("Error: Not a valid transaction amount!");
			return;
	  }


      System.out.println("Updating account # " + accountNumber);
      String confirmMsg = "Account updated:";

	  data.setFirstName(firstName.getText());
	  data.setLastName(lastName.getText());
	  data.setBalance(data.getBalance() + transactionAmt );

      try {
         file.seek( ( accountNumber - 1 ) * Record.size() );
         data.write( file );
      }
      catch ( IOException ioe ) {
         account.setText( "Error writing file" );
         return;
      }

	  DecimalFormat twoDigits = new DecimalFormat( "$0.00" );


      balance.setText(confirmMsg + "Current balance: " + twoDigits.format(data.getBalance()));


      //setVisible( false );
      //clear();

   }

     void clear()
   {
      account.setText( "" );
      firstName.setText( "" );
      lastName.setText( "" );
      balance.setText( "" );
      transaction.setText( "" );
   }

   void refresh()
      {
         //account.setText( "" );
         firstName.setText( "" );
         lastName.setText( "" );
         balance.setText( "" );
         transaction.setText( "" );
   }

}

class NewDialog extends Dialog implements ActionListener {
     private RandomAccessFile file;
     TextField account, firstName, lastName, balance;
     Button cancel, save;

     private Record data;
     int accountNumber;

   public NewDialog( TransactionProcessor t,
                     RandomAccessFile f )
   {
      super( t, "New Record", true );
      file = f;
      data = new Record();

      setSize( 300, 150 );
      setLayout( new GridLayout( 5, 2 ) );

      add( new Label( "Account" ) );
      account = new TextField();
      account.addActionListener( this );
      add( account );

      add( new Label( "First name" ) );
      firstName = new TextField();
      add( firstName );

      add( new Label( "Last name" ) );
      lastName = new TextField();
      add( lastName );

      add( new Label( "Balance" ) );
      balance = new TextField();
      add( balance );

      save = new Button( "Save Changes" );
      save.addActionListener( this );
      add( save );

      cancel = new Button( "Done" );
      cancel.addActionListener( this );
      add( cancel );
   }

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == account )
         checkIfAccountExists();
      else if ( e.getSource() == save )
         addRecord();
      else if ( e.getSource() == cancel ) {
         setVisible( false );
         clear();
      }
   }




     public void checkIfAccountExists()
   {
      accountNumber = Integer.parseInt( account.getText() );

      if ( accountNumber < 1 || accountNumber > 100 ) {
         account.setText( "Invalid account" );
         return;
      }

      try {
         file.seek( ( accountNumber - 1 ) * Record.size() );
         data.read( file );
      }
      catch ( IOException ioe ) {
         account.setText( "Error reading file" );
      }

      if ( data.getAccount() == 0 ) {
         firstName.setText( "Enter first name" );
         lastName.setText( "Enter last name" );
         balance.setText( "Enter balance" );
      }
      else {
         account.setText( data.getAccount() +
                          " already exists" );
         firstName.setText( "" );
         lastName.setText( "" );
         balance.setText( "" );
      }
   }

     public void addRecord(){
		String errMsg = "Validation error from addRecord: ";
		String confirmMsg = ": New record added";

      try{
      accountNumber = Integer.parseInt( account.getText() );
      }catch (NumberFormatException n){
	  System.out.println(errMsg + n);
	  account.setText(errMsg + n);
	  return;
   	  }


      try {
         data.setAccount( accountNumber );
         data.setLastName( lastName.getText() );
         data.setFirstName( firstName.getText() );
         data.setBalance( ( new Double (
            balance.getText() ) ).doubleValue() );
         file.seek( ( accountNumber - 1 ) * Record.size() );
         data.write( file );
      }
      catch ( IOException ioe ) {
         account.setText( "Error writing file" );
         return;
      }


      account.setText("Acct#" + accountNumber + confirmMsg);

      //setVisible( false );
      //clear();
   }

     public void clear()
   {
      account.setText( "" );
      firstName.setText( "" );
      lastName.setText( "" );
      balance.setText( "" );
   }
}

class DeleteDialog extends Dialog implements ActionListener {
     private RandomAccessFile file;
     TextField account;
     Button cancel, delete;

     private Record data;
     int accountNumber;
     private String errMsg="";

   public DeleteDialog( TransactionProcessor t,
                        RandomAccessFile f )
   {
      super( t, "Delete Record", true );


      file = f;
      data = new Record();

      setSize( 300, 80 );
      setLayout( new GridLayout( 2, 2 ) );

      add( new Label( "Account" ) );
      account = new TextField();
      account.addActionListener( this );
      add( account );

      delete = new Button( "Delete Record" );
      delete.addActionListener( this );
      add( delete );

      cancel = new Button( "Cancel" );
      cancel.addActionListener( this );
      add( cancel );
   }

   public void actionPerformed( ActionEvent e )
   {
      String errSource = " :Error from actionPerformed, DeleteDialog";
	  String msg = "";

      if ( e.getSource() == account )  {

         if ( accountNumber < 1 || accountNumber > 100 ) {
            account.setText( "Invalid account" );
            return;
         }

         try {
            file.seek( ( accountNumber - 1 ) * Record.size() );
            data.read( file );
         }
         catch ( IOException ioe ) {
            account.setText( "Error reading file" );
         }

         if ( data.getAccount() == 0 )
            account.setText( accountNumber + "does not exist" );
      }
      else if ( e.getSource() == delete ) {

         try{
			accountNumber = Integer.parseInt(account.getText());
		 }catch(NumberFormatException n){
		  	account.setText( "Error: Account number must be whole number greater than zero!" );
		  	System.out.println("Error: Account number must be whole number greater than zero!" );
		  	return;
	     }
         //accountNumber is int, check to see if it exists

		 if(validateAccountNumber(accountNumber)){

			 try {
				file.seek( ( accountNumber - 1 ) * Record.size() );


				data.setAccount( 0 );
				data.setFirstName( "" );
				data.setLastName( "" );
				data.setBalance( 0.0 );
				data.write( file );
			 }catch ( IOException ioe ) {
				account.setText( "Error writing file: " + errSource );
				System.out.println("Error writing file: " + errSource );
			 }

         	//success
         	msg = "Account number " + accountNumber + " deleted.";
         	account.setText(msg);

      	 }else{ //validate failed
			System.out.println(errMsg + errSource);
			account.setText(errMsg);
		}

  		}

      	else if ( e.getSource() == cancel ) {
         setVisible( false );
         account.setText( "" );
      }
   }

   boolean validateAccountNumber(int checkMe){
		//returns: true: account exists, false account doesn't exist
		errMsg = ""; //reset class variable

		if ( checkMe < 1 ) {
		 errMsg = "Number must be greater than zero!";
		return false;
		}

		try {
			file.seek( ( checkMe - 1 ) * Record.size() );
			data.read( file );
		}catch ( IOException ioe ) {
			//account.setText( "Error reading file." );
			errMsg = "Error reading file.";
			System.out.println("File read error " + ioe);
			return false;
		}

		if ( data.getAccount() == 0 ){
			errMsg = "Account # " + accountNumber + " not found";
			return false;

		}else{ //account found
			return true;
		}
   }



}//class DeleteDialog

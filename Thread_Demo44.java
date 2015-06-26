// Save this a Thread_Demo4.java

class Make_Thread implements Runnable {


  String New_Threads_Name; // New_Threads_Name of thread

  Thread temp_thread;

  Make_Thread(String New_Threads_Name) {
    this.New_Threads_Name = New_Threads_Name;
    temp_thread = new Thread(this, New_Threads_Name);
    System.out.println("the new thread's name is " + temp_thread);
    temp_thread.start(); // this will call the run procedure
                         // that is defined in the class Runnable
  }

  // temp_thread.start() has now called run()
  public void run() {
    int i;

    int j;

    int selection;



      switch(Integer.parseInt(New_Threads_Name)) {
      case 1:

      try {
      for(i=1;i<=4;++i) {

      System.out.println(" the thread running is " + New_Threads_Name + " " + i );

        Thread.sleep(1500);// snooze for 1500 milliseconds = one and a half seconds 
                           
      } // for loop
     }// try block
     catch (InterruptedException errmsg)
     {
     System.out.println("Interupt Exception Thrown ");
     }//catch block

    System.out.println(New_Threads_Name + "   is all done now !!!");

      break;

      case 2:

      try {

      for(j=10;j<=25;++j) {

      System.out.println(" the thread running is " + New_Threads_Name + " " + j );

        Thread.sleep(1000);// snooze for 1000 milliseconds = one second
                           
      } // for loop

         }// try block

     catch (InterruptedException errmsg)
     {
     System.out.println("Interupt Exception Thrown ");
     }//catch block


    System.out.println(New_Threads_Name + "   is all done now !!!");

      break;

      default:break;

    }//switch



}// public void run

} //Make_Thread


class Thread_Demo44 {

  public static void main(String args[]) {

    Make_Thread object1 = new Make_Thread("1"); // this create the first new thread here !!!

    Make_Thread object2 = new Make_Thread("2");// and here's the second one !!!

    try {
      // the MAIN thread sleeps for 8 seconds !!!!
      // this is to let the other threads finish first
      // the MAIN must always finish last.
      // in the next example we will see a more cost-efficient way
      // of having the MAIN finish last

    //  Thread.sleep(12000);// 12000 milliseconds = 12 seconds

      object1.temp_thread.join();
      object2.temp_thread.join();


    } // try block ends here !!!

    catch (InterruptedException e) {

      System.out.println("Main thread Interrupted");

    }// catch block ends here !!!


    System.out.println("Once again, that's all folks !!!");

  }// main

} //Thread_Demo4

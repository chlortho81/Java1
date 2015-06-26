// Save this a TwoThreads.java

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

    try {

      for(i=1;i<=4;++i) {

      System.out.println(" the thread running is " + New_Threads_Name + " " + i );

        Thread.sleep(1500);// snooze for 1500 milliseconds = one and a half seconds 
                           
      } // for loop

    } catch (InterruptedException e) {

      System.out.println(" for " + New_Threads_Name + " you pressed CTRL-BREAK huh?");

    } // catch block

    System.out.println(New_Threads_Name + "   is all done now !!!");

  }// try block

}// public void run


class TwoThread {

  public static void main(String args[]) {

    new Make_Thread("First_Thread"); // this create the first new thread here !!!

    new Make_Thread("Second_Thread");// and here's the second one !!!

    try {
      // the MAIN thread sleeps for 8 seconds !!!!
      // this is to let the other threads finish first
      // the MAIN must always finish last.
      // in the next example we will see a more cost-efficient way
      // of having the MAIN finish last

      Thread.sleep(12000);// 12000 milliseconds = 12 seconds

    } // try block ends here !!!

    catch (InterruptedException e) {

      System.out.println("Main thread Interrupted");

    }// catch block ends here !!!


    System.out.println("Once again, that's all folks !!!");

  }// main

} //TwoThread 

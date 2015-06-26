// save as Thread_Priorities.java

class New_Thread implements Runnable {

  String Thread_Name;

   int sum=0;
 
  Thread temp_thread;

  int run_the_thread = 1;  // on-off switch !!!

  public New_Thread(String name,int thread_priority) {

    temp_thread = new Thread(this);

    Thread_Name=name;

    temp_thread.setPriority(thread_priority);
  }

  public void run() {

    while (run_the_thread != 0) {

     ++sum;
    System.out.println();
 
   }   //run_the_thread
  }

  public void end_it() {

    run_the_thread = 0;

  }

  public void get_going() {

    temp_thread.start();
  }
}

class Thread_Priorities {
  public static void main(String args[]) {
    
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

    New_Thread thread_object1 = new New_Thread("Thread_Num_1",Thread.NORM_PRIORITY );

    New_Thread thread_object2 = new New_Thread("Thread_Num_2",Thread.NORM_PRIORITY);

    // let's start the threads running

   thread_object2.get_going();

    thread_object1.get_going();

    try {

      Thread.sleep(2000);// Main thread sleeps 2 seconds !!!

    }// try

    catch (InterruptedException errmsg) {

        System.out.println("you pressed ctrl_break !!!");

    }//catch

    thread_object2.end_it();

    thread_object1.end_it();

    // Wait for threads to complete their cycles !!!

    try {

       System.out.println("\n The status of object1's thread is "+thread_object1.temp_thread.isAlive());
    System.out.println("\n The status of object2's thread is "+thread_object2.temp_thread.isAlive());
	 
	 thread_object1.temp_thread.join();

      thread_object2.temp_thread.join();

    }//try

     catch (InterruptedException errmsg) {

      System.out.println("you pressed ctrl-break !!!");

    }//catch

    // let's see w\which thread got the most time !!!

    System.out.println("\n thread_object2  " + thread_object2.sum);

    System.out.println("\n thread_object1  " + thread_object1.sum);
 System.out.println("\n The status of object1's thread is "+thread_object1.temp_thread.isAlive());
    System.out.println("\n The status of object2's thread is "+thread_object2.temp_thread.isAlive());
  } //main

} // Thread_Priorities



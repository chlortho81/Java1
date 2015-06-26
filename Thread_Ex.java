// name this program Thread_Ex.java

class Thread_Ex {

  public static void main(String args[]) {

    Thread thread = Thread.currentThread();
    int i;

    System.out.println("The current thread running is : " + thread);

    // now let's change the name of our thread
    thread.setName("New name for the main thread");
    System.out.println("here's the renamed thread " + thread);

    try {

      for(i= 1; i<=10;++i) {
        System.out.println(i);
        Thread.sleep(750); // the thread will sleep 3/4 seconds
                            // between print statements

      }//try block

    } catch (InterruptedException e) {
      System.out.println("you trying to break out of the loop ???");
    }

    // now let's change the name of our thread one more time !!!

    thread.setName("another name for the same thread ");
    System.out.println("here's the renamed thread once again" + thread);

    try {

      for(i= 1; i<=5;++i) {
        System.out.println(i);
        Thread.sleep(2000); // the thread will sleep 2 seconds
                            // between print statements

      }//try block

    } catch (InterruptedException e) {
      System.out.println("you trying to break out of the loop again ???");
    }


  System.out.println("That's all folks !!!");
  }//main

} // Thread_Ex

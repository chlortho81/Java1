class Callme {
  void call(String msg) {
    System.out.print("[" + msg);
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
    System.out.println("]");
  }
}

class Caller implements Runnable {
  String msg;
  Callme target;
  Thread t;

  public Caller(Callme target, String msg) {
    this.target = target;
    this.msg = msg;
    t = new Thread(this);
    t.start();
  }

  // synchronize calls to call()
  public void run() {
  synchronized(target)
    { // synchronized block
      target.call(msg);
    }
  }
}

class Synch1 {
  public static void main(String args[]) {
    Callme target = new Callme();
    Caller ob1 = new Caller(target, "Hello");
    Caller ob2 = new Caller(target, "Synchronized");
    Caller ob3 = new Caller(target, "World");
	Caller ob4 = new Caller(target, "Again");

    // wait for threads to end
    try {
      ob1.t.join();
      ob2.t.join();
      ob3.t.join();
	  ob4.t.join();
    } catch(InterruptedException e) {
      System.out.println("Interrupted");
    }
  }
}

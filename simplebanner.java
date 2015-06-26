
import java.awt.*;
import java.applet.*;
/*
  <applet code="SimpleBanner" width=300 height=100>
  </applet>
*/

public class SimpleBanner extends Applet implements Runnable{
  String msg = " A Simple Moving Banner.";
  Thread t = null;

  // Set colors and initialize thread.
  public void init() {
    setBackground(Color.cyan);
    setForeground(Color.red);
    t = new Thread(this);
    t.start(); // start thread running
    t.suspend(); // Suspend until applet fully initialized
  }

  // Resume thread.
  public void start() {
    t.resume();
  }

  // Entry point for the thread that runs the banner.
  public void run() {
    char ch;

    // display banner until stopped.
    for( ; ; ) {
      try {
        repaint();
        Thread.sleep(500);
        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;
      } catch(InterruptedException e) {}
    } 
  }

  // Pause the banner.
  public void stop() {
    t.suspend();
  }

  // Stop thread when applet is terminted.
  public void destroy() {
    if(t != null) {
      t.stop();
      t = null;
     }
  }
  
  // Display the banner.
  public void paint(Graphics g) {
    g.drawString(msg, 50, 30);
  }    
}


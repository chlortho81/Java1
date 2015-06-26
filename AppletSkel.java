
// An Applet skeleton.
import java.awt.*;
import java.applet.*;
/*
  <applet code="AppletSkel" width=300 height=100>
  </applet>
*/

public class AppletSkel extends Applet {
  // Called first.
  String msg;
  
  public void init() {
    // initialization
	setBackground(Color.cyan);
	setForeground(Color.red);
	msg = "Inside init()   ";
	
  }

  /* Called second, after init().  Also called whenever
     the applet is restarted. */
  public void start() {
    // start or resume execution
	msg += "Inside start ()    ";
  }

  // Called when the applet is stopped.
  public void stop() {
    // suspends execution
  }

  /* Called when applet is terminated.  This is the last
     method executed. */
  public void destroy() {
    // perform shutdown activities
  }

  // Called when an applet's window must be restored.
  public void paint(Graphics g) {
    // redisplay contents of window
	msg += "Inside paint()   ";
	g.DrawString(msg,10,30);
  }    

}



// An Applet skeleton.
import java.awt.*;
import java.applet.*;
/*
  <applet code="AppletSkel2" width=300 height=100>
  </applet>
*/

public class AppletSkel2 extends Applet {
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

 

  // Called when an applet's window must be restored.
  public void paint(Graphics g) {
    // redisplay contents of window
	msg += "Inside paint()   ";
	g.drawString(msg,10,30);
  }    

}


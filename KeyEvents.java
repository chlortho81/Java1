
// Demonstrate key constants.
import java.awt.*;
import java.applet.*;
/*
  <applet code="KeyEvents" width=300 height=100>
  </applet>
*/

public class KeyEvents extends Applet{
  String msg = "";

  // Handle key press events.
  public boolean keyDown(Event evtObj, int key) {
    switch(key) {
      case Event.F1: 
        msg += "<F1>";
        break;
      case Event.F2:
        msg += "<F2>";
        break;
      case Event.F3:
        msg += "<F3>";
        break;
      case Event.PGDN:
        msg += "<PgDn>";
        break;
      case Event.PGUP:
        msg += "<PgUp>";
        break;
      case Event.LEFT:
        msg += "<Left Arrow>";
        break;
      case Event.RIGHT:
        msg += "<Right Arrow>";
        break;
      default: 
        msg += (char) key;
    }

    repaint();
    showStatus("Key Down");

    return true;
  }

  // Handle key release events.
  public boolean keyUp(Event evtObj, int key) {
    showStatus("Key Up");

    return true;
  }

  // Display keystrokes.
  public void paint(Graphics g) {
    g.drawString(msg, 10, 20);
  }    
}

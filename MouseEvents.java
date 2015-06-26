
// Demonstrate the mouse event handlers.
import java.awt.*;
import java.applet.*;
/*
  <applet code="MouseEvents" width=300 height=100>
  </applet>
*/

public class MouseEvents extends Applet{
  String msg = "";
  int mouseX = 0, mouseY = 0; // coordinates of mouse

  // Handle button press.
  public boolean mouseDown(Event evtObj, int x, int y) {
    // save coordinates
    mouseX = x;
    mouseY = y;
    msg = "Down";
    repaint();

    return true;
  }

  // Handle button release.
  public boolean mouseUp(Event evtObj, int x, int y) {
    // save coordinates
    mouseX = x;
    mouseY = y;
    msg = "Up";
    repaint();

    return true;
  }

  // Handle mouse move.
  public boolean mouseMove(Event evtObj, int x, int y) {
    // save coordinates
    showStatus("Moving mouse at " + x + ", " + y);

    return true;
  }

  // Handle mouse drag.
  public boolean mouseDrag(Event evtObj, int x, int y) {
    // save coordinates
    mouseX = x;
    mouseY = y;
    msg = "*";
    showStatus("Dragging mouse at " + x + ", " + y);
    repaint();

    return true;
  }

  // Handle mouse enter.
  public boolean mouseEnter(Event evtObj, int x, int y) {
    // save coordinates
    mouseX = 0;
    mouseY = 10;
    msg = "Mouse just entered.";
    repaint();

    return true;
  }

  // Handle mouse exit.
  public boolean mouseExit(Event evtObj, int x, int y) {
    // save coordinates
    mouseX = 0;
    mouseY = 10;
    msg = "Mouse just left.";
    repaint();

    return true;
  }

  // Display msg in applet window at current X,Y location.
  public void paint(Graphics g) {
    g.drawString(msg, mouseX, mouseY);
  }    
}

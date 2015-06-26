// Create an AWT-based application.
import java.awt.*;
import java.applet.*;

// Create a frame window.
public class AppWindow extends Frame {
  String keymsg = "";
  String mousemsg = "";
  int mouseX=0, mouseY=0;

  // Handle key press events.
  public boolean keyDown(Event evtObj, int key) {
    keymsg += (char) key;
    repaint();

    return true;
  }

  // Handle mouse down events.
  public boolean mouseDown(Event evtObj, int x, int y) {
    mouseX = x;
    mouseY = y;
    mousemsg = "Mouse Down at " + x + ", " + y;
    repaint();

    return true;
  }

  // Close window.
  public boolean handleEvent(Event evtObj) {
    if(evtObj.id == Event.WINDOW_DESTROY)
      System.exit(0);
    return super.handleEvent(evtObj);
  }

  // Display keystrokes and mouse messages.
  public void paint(Graphics g) {
    g.drawString(keymsg, 0, 10);
    g.drawString(mousemsg, mouseX, mouseY);
  }    

  // Create the window.
  public static void main(String args[]) {
    AppWindow appwin = new AppWindow();

    appwin.resize(300, 200);
    appwin.setTitle("An AWT-Based Application");
    appwin.show();
  }
}


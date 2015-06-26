
// Demonstrate check boxes. 
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
  <applet code="CheckboxDemo" width=250 height=200>
  </applet>
*/

public class CheckboxDemo extends Applet implements ItemListener {
  String msg = "";
  Checkbox WinXP, winNT, solaris, mac;

  public void init() {
    WinXP = new Checkbox("Windows XP", null, true);
    winNT = new Checkbox("Windows NT");
    solaris = new Checkbox("Solaris");
    mac = new Checkbox("MacOS");

    add(WinXP);
    add(winNT);
    add(solaris);
    add(mac);

    WinXP.addItemListener(this);
    winNT.addItemListener(this);
    solaris.addItemListener(this);
    mac.addItemListener(this);
  }

  public void itemStateChanged(ItemEvent ie) {
    repaint();
  }

  // Display current state of the check boxes.
  public void paint(Graphics g) {
    msg = "Current state: ";
    g.drawString(msg, 6, 80);
    msg = "  Windows XP: " + WinXP.getState();
    g.drawString(msg, 6, 100);
    msg = "  Windows NT: " + winNT.getState();
    g.drawString(msg, 6, 120);
    msg = "  Solaris: " + solaris.getState();
    g.drawString(msg, 6, 140);
    msg = "  MacOS: " + mac.getState();
    g.drawString(msg, 6, 160);
  }
}

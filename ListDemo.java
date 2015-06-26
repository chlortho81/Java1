
// Demonstrate Lists. 
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
  <applet code="ListDemo" width=300 height=180>
  </applet>
*/

public class ListDemo extends Applet implements ActionListener {
  
  List os, browser;
  String msg = "";

  public void init() {
    os = new List(4, true);
    browser = new List(4, false);

    // add items to os list
    os.add("Windows XP");
    os.add("Windows XP Pro");
	 os.add("Windows Hasta La Vista");
    os.add("Solaris 10");
    os.add("MacOS Leopard");

    // add items to browser list
    browser.add("Mozilla 1.1");
    browser.add("Mozilla 2.x");
    browser.add("Netscape 3.x");
    browser.add("Netscape 4.x");

    browser.add("Internet Explorer 2.0");
    browser.add("Internet Explorer 3.0");
    browser.add("Internet Explorer 4.0");

    browser.add("Lynx 2.4");

    browser.select(1);

    // add lists to window
    add(os);
    add(browser);

    // register to receive action events
    os.addActionListener(this);
    browser.addActionListener(this);
  }

  public void actionPerformed(ActionEvent ae) {
    repaint();
  }

  // Display current selections.
  public void paint(Graphics g) {
    int idx[];

    msg = "Current OS: ";
    idx = os.getSelectedIndexes();
    for(int i=0; i<idx.length; i++)
      msg += os.getItem(idx[i]) + "  ";
    g.drawString(msg, 6, 120);
    msg = "Current Browser: ";
    msg += browser.getSelectedItem();
    g.drawString(msg, 6, 140);
  }
}



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
  <applet code="JButtonDemo" width=250 height=300>
  </applet>
*/
  
public class JButtonDemo extends JApplet 
implements ActionListener {
  JTextField jtf;

  public void init() {

    // Get content pane
    Container contentPane = getContentPane();
    contentPane.setLayout(new FlowLayout());

    // Add buttons to content pane
    ImageIcon france = new ImageIcon("france.gif");
    JButton jb = new JButton(france);
    jb.setActionCommand("France");
    jb.addActionListener(this);
    contentPane.add(jb);

    ImageIcon germany = new ImageIcon("germany.gif");
    jb = new JButton(germany);
    jb.setActionCommand("Germany");
    jb.addActionListener(this);
    contentPane.add(jb);

    ImageIcon italy = new ImageIcon("italy.gif");
    jb = new JButton(italy);
    jb.setActionCommand("Italy");
    jb.addActionListener(this);
    contentPane.add(jb);

    ImageIcon japan = new ImageIcon("japan.gif");
    jb = new JButton(japan);
    jb.setActionCommand("Japan");
    jb.addActionListener(this);
    contentPane.add(jb);

    // Add text field to content pane
    jtf = new JTextField(15);
    contentPane.add(jtf);
  }

  public void actionPerformed(ActionEvent ae) {
    jtf.setText(ae.getActionCommand());
  }
}

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ShortCutKeys extends JApplet
{
   JButton button;
   JCheckBox checkBox;
   JMenuBar menuBar;
   JMenu fileMenu;
   JMenuItem exitMenuItem;
   JPanel panel;
 public void init()
 {
    Container container = this.getContentPane();
 
    Handler eventHandler = new Handler();
 
    checkBox = new JCheckBox("Hello Mom!");
    checkBox.setMnemonic(java.awt.event.KeyEvent.VK_M);
       checkBox.addActionListener(eventHandler);
    button = new JButton("Hello Dad!");
    button.setMnemonic(java.awt.event.KeyEvent.VK_D);
       button.addActionListener(eventHandler);
    panel = new JPanel();
    panel.setLayout(new FlowLayout());
    panel.add(checkBox);
    panel.add(button);
       exitMenuItem = new JMenuItem("Exit");
       exitMenuItem.setMnemonic('x');
       exitMenuItem.addActionListener(eventHandler);
    fileMenu = new JMenu("File");
    fileMenu.setMnemonic('f');
    fileMenu.add(exitMenuItem);
    menuBar = new JMenuBar();
    menuBar.add(fileMenu);
    container.add(menuBar, BorderLayout.NORTH);
  container.add(panel, BorderLayout.CENTER);
 }
 class Handler implements ActionListener
 {
    public void actionPerformed(ActionEvent ae)
    {
       if (ae.getSource() == checkBox)
       {
          System.err.println("Action Performed on CHECKBOX");
       }
       else if (ae.getSource() == button)
	   {

         
		 System.err.println("Action Performed on BUTTON");
       }
       else if (ae.getSource() == exitMenuItem)
       {
          System.exit(0);
       }
    }
 }
    
 public static void main(String[] args)
 {
    JFrame frame = new JFrame("Short Cut Keys");
    ShortCutKeys sck = new ShortCutKeys();
    sck.init();
    frame.getContentPane().add(sck);
  
//frame.setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );
  frame.addWindowListener(new WindowAdapter()
    {
       public void windowClosing(WindowEvent we)
       { System.exit(0); }
       }
       );
       frame.setSize(600, 300);
       frame.show();
    }
}







// Demonstrate Buttons 
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
  <applet code="ButtonChoiceDemo1" width=250 height=150>
  </applet>
*/

public class ButtonChoiceDemo1 extends Applet implements ActionListener,ItemListener {
  String msg1 = "";
  Button vegbut, fruitbut;
  Choice veg,fruit;
  String msg2 = "";
  String msg3="";

  public void init() {
    vegbut = new Button("veg");
    fruitbut = new Button("fruit");
    
    veg= new Choice();
    fruit = new Choice();
    // add items to veg list
    veg.add("Tomatoes");
    veg.add("Potatoes");
    veg.add("Eggplant");
    veg.add("Squash");

    // add items to fruit list
    fruit.add("Apple");
    fruit.add("Banana");
    fruit.add("Strawberries");
    fruit.add("Cherries");

    fruit.add("Melons");
   fruit.add("Kiwi");
   fruit.add("Oranges");

	fruit.add("Guava");

   fruit.select("Papaya");
   
    add(vegbut);
    add(fruitbut);
    add(veg);
    add(fruit);
    
    vegbut.addActionListener(this);
    fruitbut.addActionListener(this);
    

  
    veg.addItemListener(this);
    fruit.addItemListener(this);
 
     
     
  
    
  }

  public void actionPerformed(ActionEvent ae) {
    String str = ae.getActionCommand();
   
    if(str.equals("veg")) {
      msg1 = "You pressed veg.";
      fruit.setVisible(false);
      veg.setVisible(true);
    }
    else if(str.equals("fruit")) {
      msg1 = "You pressed fruit.";
      veg.setVisible(false);
      fruit.setVisible(true);
    }
    
    msg2=" ";
    msg3="";

    repaint();
  }

public void itemStateChanged(ItemEvent ie) {
    msg1=" ";
if(veg.isVisible()){
   msg2 = "Current veg: ";
    msg2 += veg.getSelectedItem();
   msg3="";
}
if(fruit.isVisible()){
   msg3 = "Current Fruit: ";
    msg3 += fruit.getSelectedItem();
   msg2="";
}
    repaint();
  }
  public void paint(Graphics g) {

     g.drawString(msg1, 6, 100);
    
    
    g.drawString(msg2, 6, 120);
    
    g.drawString(msg3, 6, 140);
  }
}

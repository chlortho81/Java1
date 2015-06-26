
// Demonstrate Dialog box.
import java.awt.*;
import java.applet.*;
/*
  <applet code="DialogDemo" width=250 height=150>
  </applet>
*/

// Create a subclass of Dialog.
class SampleDialog extends Dialog {
  SampleDialog(Frame parent, String title) {
    super(parent, title, false);
    setLayout(new FlowLayout());
    resize(300, 200);

    add(new Label("Press this button:"));
    add(new Button("Cancel"));
  }

  // Remove dialog box when terminated by user.
  public boolean handleEvent(Event evtObj) {
    if(evtObj.id == Event.WINDOW_DESTROY) {
      dispose();
      return true;
    }      
    return super.handleEvent(evtObj);
  }

  // Watch for cancel button.
  public boolean action(Event evtObj, Object arg) {
    if(evtObj.target instanceof Button) {
      if(arg.equals("Cancel")) {
        dispose();
      }
      return true;
    }
    return false;
  }

  public void paint(Graphics g) {
    g.drawString("This is in the dialog box", 10, 50);
  }    
}

// Create a subclass of Frame.
class MenuFrame extends Frame {
  String msg = "";
  CheckboxMenuItem debug, test;

  MenuFrame(String title) {
    super(title);

    // create menu bar and add it to frame
    MenuBar mbar = new MenuBar();
    setMenuBar(mbar);

    // create the menu items
    Menu file = new Menu("File");
    file.add(new MenuItem("New..."));
    file.add(new MenuItem("Open..."));
    file.add(new MenuItem("Close"));
    file.add(new MenuItem("-"));
    file.add(new MenuItem("Quit..."));
    mbar.add(file);

    Menu edit = new Menu("Edit");
    edit.add(new MenuItem("Cut"));
    edit.add(new MenuItem("Copy"));
    edit.add(new MenuItem("Paste"));
    edit.add(new MenuItem("-"));

    Menu sub = new Menu("Special", true);
    sub.add(new MenuItem("First"));
    sub.add(new MenuItem("Second"));
    sub.add(new MenuItem("Third"));
    edit.add(sub);

    // these are checkable menu items
    debug = new CheckboxMenuItem("Debug");
    edit.add(debug);
    test = new CheckboxMenuItem("Testing");
    edit.add(test);

    mbar.add(edit);
  }

  // Hide window when terminated by user.
  public boolean handleEvent(Event evtObj) {
    if(evtObj.id == Event.WINDOW_DESTROY) {
      hide();
      return true;
    }      
    return super.handleEvent(evtObj);
  }

  // Display menu choices.
  public boolean action(Event evtObj, Object arg) {
    if(evtObj.target instanceof MenuItem) {
      msg = "You selected ";

     // Activate a dialog box when New is selected. 
     if(arg.equals("New...")) {
        msg += "New.";
        SampleDialog d = new 
          SampleDialog(this, "New Dialog Box");
        d.show();
      }     

      // Try defining other dialog boxes for these options.   
      else if(arg.equals("Open..."))
        msg += "Open.";
      else if(arg.equals("Close"))
        msg += "Close.";
      else if(arg.equals("Quit..."))
        msg += "Quit.";
      else if(arg.equals("Edit"))
        msg += "Edit.";
      else if(arg.equals("Cut"))
        msg += "Cut.";
      else if(arg.equals("Copy"))
        msg += "Copy.";
      else if(arg.equals("Paste"))
        msg += "Paste.";
      else if(arg.equals("First"))
        msg += "First.";
      else if(arg.equals("Second"))
        msg += "Second.";
      else if(arg.equals("Third"))
        msg += "Third.";
      else if(arg.equals("Debug"))
        msg += "Debug.";
      else if(arg.equals("Testing"))
        msg += "Testing.";

      repaint();
      return true;
    }
    return false;
  }

  public void paint(Graphics g) {
    g.drawString(msg, 10, 140);

    if(debug.getState()) 
      g.drawString("Debug is on.", 10, 160);
    else
      g.drawString("Debug is off.", 10, 160);

    if(test.getState()) 
      g.drawString("Testing is on.", 10, 180);
    else
      g.drawString("Testing is off.", 10, 180);
  }    
}

// Create frame window.
public class DialogDemo extends Applet {
  Frame f;

  public void init() {
    f = new MenuFrame("Menu Demo");
    int width = Integer.parseInt(getParameter("width"));
    int height = Integer.parseInt(getParameter("height"));
 
    resize(width, height);

    f.show();
  }

  public void start() {
    f.show();
  }

  public void stop() {
    f.hide();
  }    
}

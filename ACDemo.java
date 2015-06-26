

import java.awt.*;
import java.applet.*;
import java.net.*;
/*
  <applet code="ACDemo" width=300 height=50>
  </applet>
*/

public class ACDemo extends Applet {
  
   /* Called second, after init().  Also called whenever
     the applet is restarted. */
  public void start() {
    // start or resume execution
	AppletContext ac = getAppletContext();
	URL url = getCodeBase();
	try {
	ac.showDocument(new URL(url+"Test.html"));
	} catch (MalformedURLException e) {
	showStatus("URL not found ");
	}
	}
 }

 


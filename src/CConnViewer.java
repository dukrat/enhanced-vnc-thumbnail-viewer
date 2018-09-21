import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.*;
import java.net.URL;

import com.tigervnc.network.Socket;
import com.tigervnc.vncviewer.CConn;
import com.tigervnc.vncviewer.DesktopWindow;

import static com.tigervnc.vncviewer.Parameters.embed;

public class CConnViewer extends CConn implements Runnable{

  private Thread t;
  boolean inAnApplet = true;
  boolean inSeparateFrame = false;
  Frame vncFrame = super.desktop;
  private transient AppletStub stub;
  String host = super.getServerName();
  int port = super.getServerPort();
  String[] mainArgs;
  String passwordParam;
  String usernameParam;
  String compname = super.getServerName();
  DesktopWindow desktop = super.desktop;
  String userdomain = "";

  String socketFactory = null;

  public CConnViewer(String vncServerName, Socket socket) {
    super(vncServerName, socket);
  }

  public AppletContext getAppletContext() {
    return stub.getAppletContext();
  }

  public URL getDocumentBase() {
    return stub.getDocumentBase();
  }

  public void disconnect(){
    super.close();
  }

  public void run() {
      while (true) {
        super.desktop = (DesktopWindow) vncFrame;
        processMsg();
      }
  }

  public void start() {
    if (t == null) {
      t = new Thread (this);
      t.start ();
    }
  }
}

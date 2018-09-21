//
//  Copyright (C) 2007-2008 David Czechowski  All Rights Reserved.
//
//  This is free software; you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation; either version 2 of the License, or
//  (at your option) any later version.
//
//  This software is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this software; if not, write to the Free Software
//  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307,
//  USA.
//

/* *
 * Enhanced VNC Thumbnail Viewer 1.003
 *  - Added method about screen capture feature
 *
 * Enhanced VNC Thumbnail Viewer 1.001
 *  - Called proxy setting from Setting class
 * 
 * Enhanced VNC Thumbnail Viewer 1.0
 *  - New methods -> launchViewer()
 */

import com.tigervnc.rfb.CSecurity;

import java.awt.*;
import java.util.*;

//
// This Vector-based List is used to maintain of a list of VncViewers
//
// This also contains the ability to load/save it's list of VncViewers to/from
//    an external xml file.
//

public class VncViewersList extends Vector {
    
  private EnhancedVncThumbnailViewer tnViewer;
  
  //
  // Constructor.
  //
  public VncViewersList(EnhancedVncThumbnailViewer v)
  {
    super();
    tnViewer = v;
  }

  //
  // If a host is loaded in first time, this method will be called
  //
  public CConnViewer launchViewer(String host, int port, String password, String user, String userdomain, String compname) {
    CConnViewer v = launchViewer(tnViewer, host, port, password, user, userdomain, compname);
    add(v);
    tnViewer.addViewer(v.desktop);

    return v;
  }
  
  //
  // Added on evnctv 1.000
  //    When want to reconnect, this will be called
  //
  public CConnViewer launchViewerReconnect(String host, int port, String password, String user, String userdomain, String compname) {
    CConnViewer v = launchViewer(tnViewer, host, port, password, user, userdomain, compname);
    tnViewer.addViewer(v.desktop);
    
    return v;
  }
  
  public CConnViewer launchViewerReconnect(String host, int port, String password, String user, String userdomain, String compname, int order) {
    CConnViewer v = launchViewer(tnViewer, host, port, password, user, userdomain, compname);
    tnViewer.addViewer(v.desktop, order);
    
    return v;
  }
  
  /* Added on evnctv 1.003 */
  public CConnViewer launchViewerScreenCapture(String host, int port, String password, String user, String userdomain, String compname) {
    CConnViewer v = launchViewer(tnViewer, host, port, password, user, userdomain, compname);
    tnViewer.addViewerScreenCapture(v);
    
    return v;
  }
  
  public static CConnViewer launchViewer(EnhancedVncThumbnailViewer tnviewer, String host, int port, String password, String user, String userdomain, String compname) {
    String args[] = new String[4];
    args[0] = "host";
    args[1] = host;
    args[2] = "port";
    args[3] = Integer.toString(port);

    if(password != null && password.length() != 0) {
      int newlen = args.length + 2;
      String[] newargs = new String[newlen];
      System.arraycopy(args, 0, newargs, 0, newlen-2);
      newargs[newlen-2] = "password";
      newargs[newlen-1] = password;
      args = newargs;
    }

    if(user != null && user.length() != 0) {
      int newlen = args.length + 2;
      String[] newargs = new String[newlen];
      System.arraycopy(args, 0, newargs, 0, newlen-2);
      newargs[newlen-2] = "username";
      newargs[newlen-1] = user;
      args = newargs;
    }

    if(userdomain != null && userdomain.length() != 0) {
      int newlen = args.length + 2;
      String[] newargs = new String[newlen];
      System.arraycopy(args, 0, newargs, 0, newlen-2);
      newargs[newlen-2] = "userdomain";
      newargs[newlen-1] = userdomain;
      args = newargs;
    }
    
    if(compname != null && compname.length() != 0) {
      int newlen = args.length + 2;
      String[] newargs = new String[newlen];
      System.arraycopy(args, 0, newargs, 0, newlen-2);
      newargs[newlen-2] = "compname";
      newargs[newlen-1] = compname;
      args = newargs;
    }

    // launch a new viewer
    System.out.println("Launch Host: " + host + ":" + port);
    TigerPassword dlg = new TigerPassword(password);
    CConnViewer v = new CConnViewer(host+":"+port, null);
    v.csecurity.upg = dlg;
    v.mainArgs = args;
    v.inAnApplet = false;
    v.inSeparateFrame = false;
//    v.showControls = true;
//    v.showOfflineDesktop = true;
    v.vncFrame = tnviewer;
//    v.init();
//    v.options.viewOnly = true;
//    v.options.autoScale = true; // false, because ThumbnailViewer maintains the scaling
//    v.options.scalingFactor = 10;
//    v.addContainerListener(tnviewer);
    v.start();
    while (v.desktop == null){
      try {
        Thread.sleep(500);
      } catch(InterruptedException e) {
        continue;
      }
    }
    
    return v;
  }

  public CConnViewer getViewer(String hostname, int port) {
    CConnViewer v = null;

    ListIterator l = listIterator();
    while(l.hasNext()) {
      v = (CConnViewer)l.next();
      if(v.host == hostname && v.port == port) {
        return v;
      }
    }

    return null;
  }

  public CConnViewer getViewer(Container c) {
    CConnViewer v = null;

    ListIterator l = listIterator();
    while(l.hasNext()) {
      v = (CConnViewer)l.next();
      if(c.isAncestorOf(v.desktop)) {
        return v;
      }
    }

    return null;
  }

  public CConnViewer getViewer(Button b) {
    CConnViewer v;

    ListIterator l = listIterator();
    while(l.hasNext()) {
      v = (CConnViewer)l.next();
      if(v.desktop.getParent().isAncestorOf(b)) {
        return v;
      }
    }

    return null;
  }

}
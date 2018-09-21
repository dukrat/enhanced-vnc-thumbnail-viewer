# enhanced-vnc-thumbnail-viewer

An enhanced version of the VNC Thumbnail Viewer written in Java.

## original author

The original author is:

> https://thetechnologyteacher.wordpress.com/vncthumbnailviewer/

The source code from the original author can be found here:

> https://code.google.com/archive/p/vncthumbnailviewer/

## story

This fork adds support for TigerVNC encrytion (VnNCrypt).  

## Requirements

- tested with: jdk-10.0.1

## How to compile

change directory to `src` and run with command:

```
javac -encoding utf8 --add-modules java.se.ee *.java
jar -cvfe ../EnhancedVncThumbnailViewer.jar EnhancedVncThumbnailViewer *.class org/json/*.class net/n3/nanoxml/*.class
```

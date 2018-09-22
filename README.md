# enhanced-vnc-thumbnail-viewer

An enhanced version of the VNC Thumbnail Viewer written in Java.

## original author

The original author is:

> https://thetechnologyteacher.wordpress.com/vncthumbnailviewer/

The source code from the original author can be found here:

> https://code.google.com/archive/p/vncthumbnailviewer/

## story

In September 26, 2011, a client asked us to find a VNC viewer which
could view multiple targets at the same time.  We googled and came
across the VNC Thumbnail Viewer of the original author.  It's great.
But, like many people, we needed certain features which didn't exist yet
so we decided to enhance it.  Thanks to the original author which made
it available through open source license!

Our version is named, Enhanced VNC Thumbnail Viewer, which has the
following extra features:

- display 4 screens at a time with navigator and slideshow mode
- can set title of each screen
- can search for screen by title
- support proxy through SOCKS version 5
- password protection when opening the application (optional)
- can reconnect to any specified screen

We published our source code and its binary version on sourceforge:

> https://sourceforge.net/projects/evnctv/

We stopped working on it for a few years.  But we notice that there
are still many people who download it (and, supposedly, use it).  Now
that the timing is right, we are back on it once again!  And we also
move the source code repository from SourceForge to GitHub too.

Hello World.

## Requirements

- tested with: [jdk 1.8u121](http://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html)

## How to compile

for linux
```
javac -cp "src:lib/json-20080701" -d build src/*.java src/net/n3/nanoxml/*.java
cp -r lib/json-20080701/* build
jar cvfme EnhancedVncThumbnailViewer.jar src/manifest.mf EnhancedVncThumbnailViewer -C build .
rm -rf build
```

for windows (powershell)
```
javac -cp "src;lib/json-20080701" -d build src/*.java src/net/n3/nanoxml/*.java
cp -r lib/json-20080701/* build
jar cvfme EnhancedVncThumbnailViewer.jar src/manifest.mf EnhancedVncThumbnailViewer -C build .
rm -r build
```

## How to run

for linux and windows
```
java -jar EnhancedVncThumbnailViewer.jar
```


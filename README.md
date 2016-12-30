# Wurm Clojure nREPL

This is a Wurm Unlimited client mod that adds Clojure nREPL.

## But... What does it do?

It may be really dull to create a mod for a game. The feedback loop is just too long!
You have to write the code, compile and package it. Install new version in mods directory
and run the game. Then wait for the game to load. Oh snap! You've made a mistake, got
NullPointerException and crashed the game. Let's start everything over!

What if you could just execute code inside running instance of the game?

Well that's exactly what Clojure REPL is for.

I've created this to connect to running WU instance from my editor to write some
utility scripts and automate some tasks within the game. And also because I can :)

## Required stuff

For this mod to work you need to have client mod loader installed.
For instructions visit: http://forum.wurmonline.com/index.php?/topic/134945-released-client-mod-loader/

## Build and Installation

To build this mod simply run

    lein jar

Then copy `target/clojurerepl.jar` to `WurmLauncher/mods/clojurerepl/` directory in your
Wurm Unlimited installation directory.

Finally copy `clojurerepl.properties` to `WurmLauncher/mods/` directory.

## Simple Usage

You've just built this mod so you have leiningen installed. Just run:

    lein repl :connect 7888

This will connect to nREPL server inside running WU game.

I've created some convinience objects to get you started. For example you can investigate
your player's current position with:

    > (-> wurm/player .getPos .getX)

There are also `wurm/world` and `wurm/client` defined.

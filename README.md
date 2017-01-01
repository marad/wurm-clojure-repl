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

    boot dist

This will compile the mod and create `target/clojurerepl.zip` file. To install simply 
unzip the file in `[...]/WurmLauncher/mods` directory.

## Simple Usage

You can connect to the remote repl using boot:

    boot repl -c -p 7888

This will connect to nREPL server inside running WU game.

I've created some convinience objects to get you started. For example you can investigate
your player's current position with:

    > (-> wurm/player .getPos .getX)

There are also `wurm/world` and `wurm/client` defined.

## Intended Usage

Get yourself some VIM with fireplace or EMACS with cider, connect to this nREPL session
and start coding your life in Wurm :)


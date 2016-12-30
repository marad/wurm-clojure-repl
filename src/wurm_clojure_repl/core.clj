(ns wurm-clojure-repl.core
  (:require [clojure.tools.nrepl.server :refer [start-server]]
            wurm)
  (:import [org.gotti.wurmunlimited.modloader.interfaces WurmClientMod Initable]
           [org.gotti.wurmunlimited.modloader.classhooks HookManager]
           )
  (:gen-class
    :name "io.github.marad.wurmunlimited.ClojureREPL"
    :implements [org.gotti.wurmunlimited.modloader.interfaces.WurmClientMod
                 org.gotti.wurmunlimited.modloader.interfaces.Initable]))

(defn define-wurm-namespace []
  (eval '(do
           (import '[com.wurmonline.client WurmClientBase])
           (let [clientObjectField (doto (.getDeclaredField WurmClientBase "clientObject")
                                     (.setAccessible true))
                 clientObject (.get clientObjectField nil)
                 worldField (doto (.getDeclaredField WurmClientBase "world")
                              (.setAccessible true))]
             (intern 'wurm 'client clientObject)
             (intern 'wurm 'world (.get worldField clientObject))
             (wurm/define-helpers)
             )))
  )

(defn -init [this]
  (def server (start-server :port 7888))
  (.registerHook (HookManager/getInstance)
                 "com.wurmonline.client.renderer.gui.HeadsUpDisplay"
                 "init"
                 "(II)V"
                 (reify java.lang.reflect.InvocationHandler
                   (invoke [this proxy method args]
                     (.invoke method proxy args)
                     (println ">>>> Defining usefull stuff")
                     (define-wurm-namespace)
                     nil))))


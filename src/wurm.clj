(ns wurm)

(declare client)
(declare world)

(defn define-helpers []
  (def player (.getPlayer world)))

(defn init-ns [WurmClientBase]
  (let [clientObjectField (doto (.getDeclaredField WurmClientBase "clientObject")
                            (.setAccessible true))
        clientObject (.get clientObjectField nil)
        worldField (doto (.getDeclaredField WurmClientBase "world")
                     (.setAccessible true))]
    (def client clientObject)
    (def world (.get worldField clientObject))
    (wurm/define-helpers)
    ))

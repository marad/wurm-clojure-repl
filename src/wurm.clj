(ns wurm)

(declare client)
(declare world)

(defn define-helpers []
  (def player (.getPlayer world))
  (def hud (.getHud world)))

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


(def current-action (atom nil))

(defn update-action [action-message action-time]
  (if (and (= action-message "")
           (zero? action-time))
    (reset! current-action nil)
    (reset! current-action {:message action-message
                            :time action-time})
    ))

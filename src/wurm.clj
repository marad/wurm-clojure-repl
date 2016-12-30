(ns wurm)

(declare client)
(declare world)

(defn define-helpers []
  (def player (.getPlayer world)))

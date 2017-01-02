(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojure "1.8.0"]
                  [org.clojure/tools.nrepl "0.2.12"]
                  [org.clojure/core.async "0.2.395"]
                  [org.gotti.wurmunlimited/client-modlauncher "0.4" :scope "provided"]]
  :repositories #(conj % ["gotti" {:url "http://gotti.no-ip.org/maven/repository"}])
  )

(task-options!
  aot {:namespace #{'wurm-clojure-repl.core}}
  jar {:file "clojurerepl/clojurerepl.jar"}
  zip {:file "clojurerepl.zip"}
  pom {:project 'io.github.marad.wurm/clojurerepl
       :version "0.1"}
  uber {:exclude-scope #{"provided"}}
  )

(deftask dist []
  (comp (aot)
        (pom)
        (uber)
        (jar)
	(sift :include #{#"clojurerepl/clojurerepl.jar"
	                 #"clojurerepl.properties"})
	(zip)
	(target)
	))

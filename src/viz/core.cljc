(ns viz.core
  #?(:clj
     (:require
       [clojure.java.io :as io]))
  #?(:cljs
     (:require
       [vizjs]))
  #?(:clj
     (:import
       (javax.script ScriptEngineManager))))

#?(:clj
   (do
     (defn get-engine*
       []
       (let [engine (.getEngineByMimeType (ScriptEngineManager.)
                                          "application/javascript")]
         (.eval engine (slurp (io/resource "viz.js")))
         engine))

     (def get-engine (memoize get-engine*))

     (defn image
       [dot-string]
       (.eval (get-engine) (str "Viz(\"" dot-string "\");")))))

#?(:cljs
  (defn image
    [dot-string]
    (js/Viz dot-string)))

(comment (image "digraph { c --> b };"))

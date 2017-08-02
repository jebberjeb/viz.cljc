(ns viz.image
  (:require
    [clojure.java.io :as io])
  (:import
    (javax.script ScriptEngineManager)))

(defn get-engine*
  []
  (let [engine (.getEngineByMimeType (ScriptEngineManager.)
                                     "application/javascript")]
    (.eval engine (slurp (io/resource "vizjs/viz.js")))
    engine))

(def get-engine (memoize get-engine*))

(defn image
  [dot-string]
  (.eval (get-engine) (str "Viz('" dot-string "');")))

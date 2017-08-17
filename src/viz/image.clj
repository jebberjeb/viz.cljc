(ns viz.image
  (:require
    [clojure.java.io :as io]
    [clojure.string :as string])
  (:import
    (javax.script ScriptEngineManager)))

(defn get-engine*
  []
  (let [engine (.getEngineByMimeType (ScriptEngineManager.)
                                     "application/javascript")]
    (.eval engine (slurp (io/resource "vizjs/viz.js")))
    engine))

(def get-engine (memoize get-engine*))

(defn sanitize [s]
  "Escape multi line strings for Nashorn."
  (string/replace s "\n" "\\n"))

(defn image
  [dot-string]
  (.eval (get-engine) (str "Viz('" (sanitize dot-string) "');")))

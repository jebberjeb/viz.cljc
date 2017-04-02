(ns viz.example
  (:import (goog.dom query))
  (:require
    [viz.core :as viz]
    [goog.dom :as gdom]))

(enable-console-print!)

(let [body (aget (query "body") 0)]
  (set! (.-innerHTML body) (viz/image "digraph { FOO -> BAR; }")))

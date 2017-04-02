(ns viz.image
  (:require [vizjs]))

(defn image
    [dot-string]
    (js/Viz dot-string))

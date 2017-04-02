(ns viz.core
  (:require [viz.image]))

(def image viz.image/image)

(comment (image "digraph { c --> b };"))

# viz.clc

Generate images from [Graphviz]() dot strings using [Viz.js]() in both
Clojure and Clojurescript.

## Release

### Leiningen dependency

```clojure
[viz-cljc "0.1.0"]
```

##  Why?

* One interface for both Clojure and Clojurescript.

* To provide externs for ClojureScript.

* Remove the dependency on Graphviz `dot` binary from Clojure.

## Usage

```clojure
(require '[viz.core :as viz])
(viz/image "digraph { FOO -> BAR; }")
```

From cljs, you can set the `.-innerHTML` of a DOM element, or from clj, `spit`
the result out to a svg file.

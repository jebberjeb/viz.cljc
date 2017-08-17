# viz.cljc

Generate images from [Graphviz](http://graphviz.org) dot strings using
[Viz.js](https://github.com/mdaines/viz.js/) in both
Clojure and Clojurescript.

## Release

### Leiningen dependency

```clojure
[viz-cljc "0.1.3"]
```

##  Why?

This library provides one interface `viz.core/image` for both Clojure and
Clojurescript. For Clojure, the dependency on the Graphviz `dot` binary is
not necessary (as it is with other libraries). For Clojurescript, this 
library eliminates the need to separately include Viz.js.

Everything in this library is self contained, as it includes and uses Viz.js.
This also ensures complete consistency (formatting nuances, etc) between
Clojure and Clojurescript.

## Usage

```clojure
(require '[viz.core :as viz])
(viz/image "digraph { FOO -> BAR; }")
```

The `image` function returns an SVG string.

```html
<svg width="70pt" height="116pt" viewBox="0.00 0.00 69.78 116.00" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
<g id="graph0" class="graph" transform="scale(1 1) rotate(0) translate(4 112)">
<title>%0</title>
<polygon fill="#ffffff" stroke="transparent" points="-4,4 -4,-112 65.7766,-112 65.7766,4 -4,4"></polygon>
<!-- FOO -->
<g id="node1" class="node">
<title>FOO</title>
<ellipse fill="none" stroke="#000000" cx="30.8883" cy="-90" rx="30.1958" ry="18"></ellipse>
<text text-anchor="middle" x="30.8883" y="-85.8" font-family="Times,serif" font-size="14.00" fill="#000000">FOO</text>
</g>
...
```

From cljs, you can use the SVG result to set the `.-innerHTML` of a DOM
element, or from clj, `spit` the result out to a SVG file.


## TODO

Right now, only SVG is supported. Add other image formats.

(defproject viz-cljc "0.1.3"
  :description "Clojure and Clojurescript support for Viz.js"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.854"]]

  :plugins [[lein-cljsbuild "1.1.5"]]

  :source-paths ["src"]

  :cljsbuild
  {:builds
   [{:id "release"
     :source-paths ["src"]
     :compiler {:optimizations :advanced
                :output-to "resources/out/main.js"
                :asset-path "out"
                :output-dir "resources/out"
                :main "viz.example"}}]})

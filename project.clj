(defproject hyraxweb "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.5.0"
            :dependencies [[org.clojure/clojure "1.7.0-alpha5"]
                           [org.clojure/tools.reader "0.8.4"]
                           [compojure "1.3.2"]
                           [ring/ring-core "1.3.2"]
                           [ring/ring-json "0.3.1"]
                           [org.clojure/clojurescript "0.0-2850"]
                           [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                           [cljs-http "0.1.21"]
                           [om "0.7.3"]
                           [ring/ring-defaults "0.1.4"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.13"]
            [lein-pdo "0.1.1"]]
  :ring {:handler hyraxweb.handler/app}

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js/out"
                                   :optimizations :none
                                   :source-map true}}]}
  :aliases {"up" ["pdo" "cljsbuild" "auto" "dev," "ring" "server-headless"]}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :source-paths ["src/clj"])

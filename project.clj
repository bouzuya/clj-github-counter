(defproject github-counter "0.1.0"
  :description "GitHub Counter counts commits and repositories, and output *.csv files."
  :url "http://github.com/bouzuya/clj-github-counter"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [tentacles "0.2.4"]
                 [clj-time "0.4.4"]]
  :main github-counter.core)


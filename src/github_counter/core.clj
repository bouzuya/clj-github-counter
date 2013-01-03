(ns github-counter.core
  (:require [clojure.java.io :as jio]
            [clj-time.local :as tl]
            [clj-time.format :as tf]
            [tentacles.core :as github]
            [tentacles.users :as users])
  (:gen-class))

(defn- props
  [n]
  (let [u (jio/resource n)]
    (with-open [r (jio/reader u)]
      (doto
        (java.util.Properties.)
        (.load r)))))

(defn- props->map
  [^java.util.Properties props]
  (let [names (enumeration-seq (.propertyNames props))
        pairs (map (juxt keyword #(.getProperty props %)) names)]
    (into {} pairs)))

(defn -main
  [& args]
  (let [props (props->map (props "github-counter.properties"))
        file (jio/file (props :filename))
        user (users/user (props :username))
        line (clojure.string/join
               ","
               [(tf/unparse (tf/formatter "yyyy-MM-dd") (tl/local-now))
                (:followers user)
                (:following user)
                (:public_repos user)
                (:public_gists user)])]
    (with-open [w (jio/writer file :append true)]
      (.write w line)
      (.newLine w))))


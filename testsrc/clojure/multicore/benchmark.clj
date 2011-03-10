(ns multicore.pnehm.benchmark
  (:require [multicore.pnehm.clojure-porderer :as p]
    [withcontrib.pnehm.clojure-orderer :as s]))

(def charspace "abcdefghijklmnopqrstuvwxyz")

(defn data-set []
  "Create a lazy data set with characters from 'charspace'"
  (repeatedly
    #(nth charspace (rand-int (dec (count charspace))))))

(defn run [data-length]
  (println "Running test with " data-length " chars")
  (let [data (doall (take data-length (data-set)))]
    (time (println "single " (s/-orderByFreq "a" data)))
    (time (println "parallel " (p/-orderByFreq "a" data)))
    ))


(run 10000000)
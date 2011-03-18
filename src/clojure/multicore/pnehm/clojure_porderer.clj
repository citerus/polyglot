(ns multicore.pnehm.clojure-porderer
  (:use [clojure.contrib.math :only (ceil)])
  (:gen-class
    :name multicore.pnehm.ClojureOrderer
    :implements [pnehm.Orderer]))

(def cores (.. Runtime getRuntime availableProcessors))

(defn vec-part [n coll]
  "Partition the given column into chunks of size n. Last chunk may contain less than n items"
  (let [size-ix (count coll)]
    (loop [result [] i 0]
      (cond
        (= i size-ix) result
        (> (+ i n) size-ix) (conj result (subvec coll i size-ix))
        :else (recur (conj result (subvec coll i (+ i n))) (+ i n))))))

(defn part-size [coll]
  "Calculate the chunck size based on number of available cores"
  (ceil (/ (count coll) cores)))

(defn cmpr [[val1 freq1] [val2 freq2]]
  (let [freq (compare freq2 freq1)]
    (if-not (zero? freq) freq (compare val1 val2))))

(defn pfrequency-map [coll]
  (let [partitioned-coll (vec-part (part-size coll) coll)
        parts (pmap frequencies partitioned-coll)]
    (sort cmpr
      (apply merge-with + parts))))

(defn -orderByFreq [_ coll]
  (if (empty? coll) () (keys (pfrequency-map (vec coll)))))
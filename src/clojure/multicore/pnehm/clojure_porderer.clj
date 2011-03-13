(ns multicore.pnehm.clojure-porderer
  (:gen-class
    :name multicore.pnehm.ClojureOrderer
    :implements [pnehm.Orderer]))

(def cores (.. Runtime getRuntime availableProcessors))

(defn vec-part [n coll]
  (let [size-ix (- (count coll) 1)]
    (loop [result [] i 0]
      (if (>= i size-ix)
        result
        (recur (conj result (subvec coll i (+ i n))) (+ i n))))))

(defn cmpr [[val1 freq1] [val2 freq2]]
  (let [freq (compare freq2 freq1)]
    (if-not (zero? freq) freq (compare val1 val2))))

(defn pfrequency-map [coll]
  (let [partitioned-coll (time (doall (-> (count coll) (quot cores) (vec-part coll))))
        parts (time (doall (pmap frequencies partitioned-coll)))]
    (time (sort cmpr
      (apply merge-with + parts)))))

(defn -orderByFreq [_ coll]
  (if (empty? coll) () (keys (pfrequency-map coll))))

(defn partition-in [parts coll]
  (let [part-size (/ (count coll) parts)]
    (loop [e [] c coll]
      (if (empty? c)
        e
        (recur (conj e (take part-size c)) (drop part-size c))))))

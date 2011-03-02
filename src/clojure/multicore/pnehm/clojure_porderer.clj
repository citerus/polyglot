(ns multicore.pnehm.clojure-porderer
  (:gen-class
    :name multicore.pnehm.ClojureOrderer
    :implements [pnehm.Orderer]
    )
  )

(def cores (.. Runtime getRuntime availableProcessors))

(defn cmpr [[val1 freq1] [val2 freq2]]
  (let [freq (compare freq2 freq1)]
    (if-not (zero? freq) freq (compare val1 val2))))

(defn pfrequency-map [coll]
  (let [l (count coll)
        partitioned-coll (partition-all (quot l cores) coll)
        fs (for [part partitioned-coll] (future (frequencies part)))]
    (sort cmpr
      (apply merge-with +
        (for [f fs] @f)))))

(defn -orderByFreq [_ coll]
  (if (empty? coll) () (keys (pfrequency-map coll))))
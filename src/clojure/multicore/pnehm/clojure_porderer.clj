(ns multicore.pnehm.clojure-porderer
  (:gen-class
    :name multicore.pnehm.ClojureOrderer
    :implements [pnehm.Orderer]
    )
  )

(defn cmpr [[val1 freq1] [val2 freq2]]
  (let [freq (compare freq2 freq1)]
    (if-not (zero? freq) freq (compare val1 val2))))

(defn order-by-freq [coll]
  (if (empty? coll) () (keys (sort cmpr (frequencies coll)))))

(defn -orderByFreq [_ coll]
  (order-by-freq coll))
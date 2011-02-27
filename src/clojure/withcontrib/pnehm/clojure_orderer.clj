(ns withcontrib.pnehm.clojure-orderer
  (:gen-class
    :name withcontrib.pnehm.ClojureOrderer
    :implements [pnehm.Orderer]
    )
  )

(defn cmpr [[val1 freq1] [val2 freq2]]
  (let [freq (compare freq2 freq1)]
    (if-not (zero? freq) freq (compare val1 val2))))

(defn -orderByFreq [_ coll]
  (if (empty? coll) () (keys (sort cmpr (frequencies coll)))))
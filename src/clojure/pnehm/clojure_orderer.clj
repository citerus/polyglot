(ns pnehm.clojure-orderer
  (:gen-class
    :name pnehm.ClojureOrderer
    :init init
    :implements [pnehm.Orderer]
    ))

(defn -init []
  [[] (atom [])])


(defn count-words [coll]
  (reduce #(merge-with + %1 {%2 1}) {} coll))

(defn cmpr [[val1 freq1] [val2 freq2]]
  (let [freq (compare freq2 freq1)]
    (if (not= freq 0) freq (compare val1 val2))))

(defn -orderByFreq [_ coll]
  (if (empty? coll) () (keys (sort cmpr (count-words coll)))))

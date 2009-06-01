(ns pnehm.clojure-orderer
  (:gen-class
    :name pnehm.ClojureOrderer
    :init init
    :implements [pnehm.Orderer]
    ))

(defn -init []
  [[] (atom [])])

(defn count-words
  [coll]
  (reduce #(merge-with + %1 {%2 1}) {} coll))

(defn cmpr [a b]
  (let [freq (compare (val b) (val a))]
    (cond (not= freq 0) freq
      :else (compare (key a) (key b)))))

(defn -orderByFreq [_ arg]

  (map #(key %) (sort cmpr
    (count-words arg))))

;(println (-orderByFreq :a ["b", "d", "b", "b", "a", "c", "a"]))
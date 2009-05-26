(ns pnehm.clojure-orderer
  (:gen-class
    :name pnehm.ClojureOrderer
    :state state
    :init init
    :implements [pnehm.Orderer]
    )
  (:import [org.apache.commons.collections Bag]
    [org.apache.commons.collections.bag HashBag]
    [java.util List]
    [java.util Comparator]
    [java.util Collections]
    [java.util ArrayList]))

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
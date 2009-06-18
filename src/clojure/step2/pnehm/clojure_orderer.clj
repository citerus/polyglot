(ns step2.pnehm.clojure-orderer
  (:gen-class
    :name step2.pnehm.ClojureOrderer
    :implements [pnehm.Orderer]
    )
  (:import [org.apache.commons.collections Bag]
    [org.apache.commons.collections.bag HashBag]
    [java.util List]
    [java.util Comparator]
    [java.util Collections]
    [java.util ArrayList]))


(defn count-words [coll]
  (reduce #(merge-with + %1 {%2 1}) {} coll))

(def cmpr
  (proxy [Comparator] []
    (compare [a b]
      (let [freq (.compareTo (.val b) (.val a))]
        (if (not= freq 0) freq (.compareTo (.key a) (.key b)))))))

(defn -orderByFreq [_ arg]
  (let [out (count-words arg)]
    (if (empty? out) () (keys (sort cmpr out)))))
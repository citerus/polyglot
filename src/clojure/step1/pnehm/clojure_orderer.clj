(ns step1.pnehm.clojure-orderer
  (:gen-class
    :name step1.pnehm.ClojureOrderer
    :implements [pnehm.Orderer]
    )
  (:import [org.apache.commons.collections Bag]
    [org.apache.commons.collections.bag HashBag]
    [java.util List]
    [java.util Comparator]
    [java.util Collections]
    [java.util ArrayList]))


(defn -orderByFreq [_ arg]

  (let [bag (HashBag. arg)
        out (ArrayList. (.uniqueSet bag))
        cmpr (proxy [Comparator] []
      (compare [a b]
        (let [freq (.compareTo (.getCount bag b) (.getCount bag a))]
          (if-not (zero? freq) freq (.compareTo a b)))))]

    (do
      (Collections/sort out, cmpr)
        out)))
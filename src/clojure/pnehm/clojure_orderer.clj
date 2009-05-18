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


(defn -orderByFreq [_ arg]

  (let [bag (HashBag. arg)
        out (ArrayList. (.uniqueSet bag))
        cpr (proxy [Comparator] []
      (compare [a b]
        (let [freq (.compareTo (Integer/valueOf (.getCount bag b)) (.getCount bag a))]
          (cond (not= freq 0) freq
            :else (.compareTo a b)))))]

    (do
      (Collections/sort out, cpr)
      out)))
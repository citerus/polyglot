(ns multicore.pnehm.clojure-porderer-test
  (:use multicore.pnehm.clojure-porderer clojure.test))

(def charspace "abcdefghijklmnopqrstuvwxyz")

(defn data-set []
  "Create a lazy data set with characters from 'charspace'"
  (repeatedly
    #(nth charspace (rand-int (dec (count chars))))))

(deftest test-order-by-freq-1
  (is (= ["b","a","c","d"] (-orderByFreq :a ["b", "d", "b", "b", "a", "c", "a"]))))

(deftest test-order-by-freq-2
  (is (= ["a","b","d","c", "e"] (-orderByFreq :a ["b", "d", "d", "e", "b", "a", "c", "a"]))))

(deftest test-order-by-freq-empty-list
  (is (empty? (-orderByFreq :a []))))

(run-tests 'multicore.pnehm.clojure-porderer-test)

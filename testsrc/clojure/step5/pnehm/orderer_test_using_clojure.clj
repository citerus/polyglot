(ns step5.pnehm.orderer-test-using-clojure
  (:use step4.pnehm.clojure-orderer clojure.contrib.test-is)
  (:import [pnehm JavaOrderer]))

(deftest test-order-by-freq-1
  (is (= ["b","a","c","d"] (order-by-freq ["b", "d", "b", "b", "a", "c", "a"]))))

(deftest test-order-by-freq-2
  (is (= ["a","b","d","c", "e"] (order-by-freq ["b", "d", "d", "e", "b", "a", "c", "a"]))))

(deftest test-order-by-freq-empty-list
  (is (empty? (order-by-freq []))))

(deftest test-order-by-freq-java-1
  (is (= ["b","a","c","d"] (.orderByFreq (JavaOrderer.) ["b", "d", "b", "b", "a", "c", "a"]))))

(run-tests 'step5.pnehm.orderer-test-using-clojure)
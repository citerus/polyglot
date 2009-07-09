(ns step4.pnehm.orderer-test-using-clojure
  (:use step4.pnehm.clojure-orderer clojure.contrib.test-is))

(deftest test-order-by-freq-1
  (is (= ["b","a","c","d"] (order-by-freq ["b", "d", "b", "b", "a", "c", "a"]))))

(deftest test-order-by-freq-2
  (is (= ["a","b","d","c", "e"] (order-by-freq ["b", "d", "d", "e", "b", "a", "c", "a"]))))

(deftest test-order-by-freq-empty-list
  (is (empty? (order-by-freq []))))

(run-tests 'step4.pnehm.orderer-test-using-clojure)
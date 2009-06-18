(ns step3.pnehm.clojure-orderer-test
  (:use step3.pnehm.clojure-orderer clojure.contrib.test-is))

(deftest test-order-by-freq-1
  (is (= ["b","a","c","d"] (-orderByFreq :a ["b", "d", "b", "b", "a", "c", "a"]))))

(deftest test-order-by-freq-2
  (is (= ["a","b","d","c", "e"] (-orderByFreq :a ["b", "d", "d", "e", "b", "a", "c", "a"]))))

(deftest test-order-by-freq-empty-list
  (is (empty? (-orderByFreq :a []))))

(run-tests 'step3.pnehm.clojure-orderer-test)
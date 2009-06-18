(ns step5.pnehm.java-orderer-test
  (:use clojure.contrib.test-is)
  (:import [pnehm JavaOrderer]))


(deftest test-order-by-freq-1
  (is (= ["b","a","c","d"] (.orderByFreq (JavaOrderer.) ["b", "d", "b", "b", "a", "c", "a"]))))

(run-tests 'step5.pnehm.java-orderer-test)
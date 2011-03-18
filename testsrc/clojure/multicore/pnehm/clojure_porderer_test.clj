(ns multicore.pnehm.clojure-porderer-test
  (:use multicore.pnehm.clojure-porderer clojure.test))

(deftest test-order-by-freq-1
 (is (= ["b","a","c","d"] (-orderByFreq :a ["b", "d", "b", "b", "a", "c", "a"]))))

(deftest test-order-by-freq-2
  (is (= ["a","b","d","c", "e"] (-orderByFreq :a ["b", "d", "d", "e", "b", "a", "c", "a"]))))

(deftest test-order-by-freq-empty-list
  (is (empty? (-orderByFreq :a []))))

(deftest test-vec-part
  (is (= [["a", "b", "c"], ["d", "e", "f"], ["g", "h", "i"]] (vec-part 3 ["a", "b", "c", "d", "e", "f", "g", "h", "i"])))
  (is (= [["a", "b", "c", "d"], ["e", "f", "g", "h"], ["i"]] (vec-part 4 ["a", "b", "c", "d", "e", "f", "g", "h", "i"])))
  (is (= [["a", "b", "c", "d", "e", "f", "g", "h", "i"]] (vec-part 9 ["a", "b", "c", "d", "e", "f", "g", "h", "i"])))
  (is (= [["b"], ["d"], ["d"], ["e"], ["b"], ["a"], ["c"], ["a"]] (vec-part 1 ["b", "d", "d", "e", "b", "a", "c", "a"]))))

(run-tests 'multicore.pnehm.clojure-porderer-test)

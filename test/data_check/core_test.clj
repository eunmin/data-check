(ns data-check.core-test
  (:require [clojure.test :refer :all]
            [data-check.core :refer [valid?]]))

(deftest valid?-test
  (testing "number"
    (is (valid? 1 1)))
  (testing "map"
    (is (valid? {:a 1 :b 1} {:a 1})))
  (testing "nested map"
    (is (valid? {:a {:x 1 :y 2} :b 1} {:a {:x 1}})))
  (testing "vector"
    (is (valid? [1 1 1] [1])))
  (testing "set"
    (is (valid? 1 #{1 2 3}))))

(ns clojure-playground.core-test
  (:require [clojure.test :refer :all]
            [clojure-playground.core :refer :all]))

(deftest greetings-test
  (testing "Greetings with no param"
    (is (= (greetings) "Hello there!")))

  (testing "Greetings with no param"
    (is (= (greetings "Hi") "Hi there!"))))

(deftest values-test
  (testing "All Values function"
    (is (= (values 1 2 3 4) "1, 2, 3, 4" ))))

(deftest check-card-flag-test
  (testing "Check card flag"
    (is (= (check-card-flag 12348790) "Master Card"))
    (is (= (check-card-flag 34599994) "Visa"))
    (is (= (check-card-flag 567991293) "AMEX"))
    (is (= (check-card-flag 96986986) "Invalid number"))))

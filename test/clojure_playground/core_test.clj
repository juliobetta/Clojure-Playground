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
    (are [number flag] (= (check-card-flag number) flag)
      12348790 "Master Card"
      34599994 "Visa"
      567991293 "AMEX"
      96986986 "Invalid number"
    )))

;; declaring multiple lexical scopes:
;; (let [var1 "value"
;;       var2 "value"]
;;   ... code
;; )
;; https://stackoverflow.com/a/21915601/561610
(deftest build-character-test-2
  (testing "Build character with composition"
    (let [expected {"appearsIn" ["New Hope"
                                 "Empire"
                                 "Jedi"]
                    "firstName" "Anakin"
                    "lastName"  "Skywalker"
                    "planet"    "Tatooine"
                    "sector"    "Arkanis"}
          ;; composing functions with ->
          ;; -> (initial-value, ...fns)
          actual   (-> base-character with-apparitions with-address)]
      (is (= actual expected)))))

(deftest set-values-test
  (testing "Set values without optionals"
    (let [expected ["file path: /root/my-file.txt"
                          "author: root"]
          actual (set-values "my-file.txt" "/root")]
      (is (= actual expected))))

  (testing "Set values with named params"
    (let [expected ["file path: /root/my-file.txt"
                          "author: me"
                          "comments: ahoy!"
                          "tags: ready, done"]

          actual (set-values "my-file.txt" "/root"
                                   :author "me"
                                   :comments "ahoy!"
                                   :tags ["ready" "done"])]
      (is (= actual expected)))))

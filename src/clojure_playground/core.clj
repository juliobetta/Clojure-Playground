(ns clojure-playground.core
  (:require [clojure.string :as str]))

; an example of multi-arity function
(defn greetings
  "Say hi!"
  ([]       (greetings "Hello"))
  ([prefix] (str prefix " there!")))

; an example of multi param function
(defn values [first & rest]
  (str/join ", " (conj rest first)))

; conditional example
(defn check-card-flag
  [first-numbers]
  (cond
    (str/starts-with? first-numbers "123") "Master Card"
    (str/starts-with? first-numbers "345") "Visa"
    (str/starts-with? first-numbers "567") "AMEX"
    :else "Invalid number"
  ))

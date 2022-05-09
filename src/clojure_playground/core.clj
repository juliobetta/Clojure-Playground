(ns clojure-playground.core
  (:gen-class)
  (:require [clojure.string :as str]))

; an example of multi-arity function
(defn greetings
  "Say hi!"
  ([]       (greetings "Hello"))
  ([prefix] (str prefix " there!")))

; an example of multi param function
(defn values [first & rest]
  (str/join ", " (conj rest first)))

;; conditional example
;; similar to lodash `cond`
(defn check-card-flag
  [first-numbers]
  (cond
    (str/starts-with? first-numbers "123") "Master Card"
    (str/starts-with? first-numbers "345") "Visa"
    (str/starts-with? first-numbers "567") "AMEX"
    :else "Invalid number"
  ))

; similar to `const` in JavaScript
(def base-character {:firstName "Anakin"
                     :lastName  "Skywalker"})

(defn with-address
  [options]
  (merge options {:planet "Tatooine"
                  :sector "Arkanis"}))

(defn with-apparitions
  [options]
  (merge options {:appearsIn ["New Hope", "Empire", "Jedi"]}))

;; named params and default values
(defn set-values
  [filename path                    ; required params
    & {:keys [author comments tags] ; optional params
       :or {author "root"           ; default values
            tags []}}]

  (->>
    [[true                    (format "file path: %s/%s" path filename)]
     [true                    (str "author: " author)]
     [(not (nil? comments))   (str "comments: " comments)]
     [(not (nil? (seq tags))) (str "tags: " (str/join ", " tags))]] ; (seq tags) returns nil if empty

    ;;(filter (fn [x]
    ;;  (= (first x) true)))
    (filter #(= (first %) true))

    ;;(map (fn [x]
    ;;  (second x)))
    (map #(second %))))

(defn -main
  []
  (println (greetings))
  (println (values 1 2 3 4 5))
  (println (check-card-flag 123884))
  (println (-> base-character with-address))
  (println (str/join "\n" (set-values "my-file.txt"
                                      "/root"
                                      :tags ["foo" "bar"]
                                      :comments "it works!"))))

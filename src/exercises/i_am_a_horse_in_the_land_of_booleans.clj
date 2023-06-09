(ns exercises.i-am-a-horse-in-the-land-of-booleans)


;;;;;;;;;
;;; TRAINING DAY
;;;;;;;;;

; Exercise 1
; Write the following expression in the Clojure prefix syntax: (2∗3)+4. The result should be 10.
;
;(+ (* 2 3) 4)
;
; Exercise 2
; Write the expression 3+4+5+6 in Clojure syntax.
;
;(+ 3 4 5 6)
;
; Exercise 3
; Write a Clojure expression in the REPL that, using get, gets the first character in the string "abrakadabra".
;
;(get "abrakadabra" 0)
;
; Exercise 4
; Call the following function in the REPL with your name.
; (fn [name] (str "Welcome to Rivendell mr " name))
;
;(fn [name] (str "Welcome to Rivendell mr " name) "tracy")

;;;;;;;;; 
;;; I AM A HORSE IN THE LAND OF BOOLEANS
;;;;;;;;;

;;;
; Exercise 1
; Implement (boolean x), which works like the built-in boolean function: for nil and false, it returns false, and for all other values it returns true. You can use if in its implementation, but not the build-in boolean.
;;;

(defn my-bool
  "This is a different version of the boolean function"
  [x]
  (if x
    true
    false))

;;;
; Exercise 2
; Write the function (teen? age), which returns truthy if age is at least 13 and at most 19. Use only one comparison operator and give it three arguments.
;;;

(defn teen? [age]
  (if (<= 13 age 19)
    true
    false))

;;;
; Exercise 3
; Write the function (abs n), which returns the absolute value of n, i.e. if n<0, the value of (abs n) is −n, and otherwise n.
;;;

(defn abs [x]
 (if (> x 0)
   x
   (- x)))

;;;
; Exercise 4
; Write the function (divides? divisor n), which returns true if divisor divides n and false otherwise.
;   (mod num div) returns 0 if div divides num exactly
;;;

(defn divides? [divisor n]
  (if (== (mod n divisor) 0)
    true
    false))

;;;
; Exercise 5
; Write the function (fizzbuzz n) that returns
;
;    "fizz" when n is divisible by 3,
;    "buzz" when n is divisible by 5,
;    "gotcha!" when n is divisible by 15, and
;    the empty string "" otherwise.
;
; Use the divides? function from the previous exercise 
;;;

(defn fizzbuzz [n]
 (cond
   (divides? 15 n) "gotcha!"
   (divides? 3 n) "fizz"
   (divides? 5 n) "buzz"
   :else ""))

;;;
; Exercise 6
; Write a function (generic-doublificate x) that takes one argument and
;    doubles it if it is a number,
;    returns nil if it is an empty collection,
;    if it is a list or a vector, returns two times the length of it
;    returns true otherwise.
; You can use the following functions:
;    (number? n) returns true if n is a number.
;    (empty? coll) returns true if coll is empty.
;    (list? coll) and (vector? coll) test if coll is a list or a vector.
;    (count coll) returns the length of a list or a vector.
;;;

(defn generic-doublificate [x]
  (cond
    (number? x) (* 2 x)
    (empty? x) nil
    (list? x) (* 2 (count x))
    (vector? x) (* 2 (count x))
    :else true
))

;;;
; Exercise 7
; Write the function (not-teen? age), which returns true when teen? returns false and false otherwise.
;;;

(defn not-teen? [x]
  (if (not (teen? x))
  true
  false))

;;;
; Exercise 8
;Write the function (leap-year? year), which returns true if year is a leap year, otherwise false. A year is a leap year if it is divisible by 4, except if it is divisible by 100, in which case it still is a leap year if it is divisible by 400.
;;;

; This works, but is missing the 100 yr form
;(defn leap-year? [yr]
;(if 
;  (or
;    (== (mod yr 400) 0)
;    (== (mod yr 4) 0) 
;  )
;  true
;  false))
;
; AND this works
;(defn leap-year? [yr]
;  (if (not= (mod yr 100) 0)
;  true 
;  false
;  ))
;
;AND this works
;(defn leap-year? [yr]
;  (if 
;    (and 
;      (== (mod yr 4) 0)
;      (not= (mod yr 100) 0)
;    )
;    true
;    false))

(defn leap-year? [yr]
(if 
  (or
    (== (mod yr 400) 0)
    (and
      (== (mod yr 4) 0)
      (not= (mod yr 100) 0)
    )
  )
  true
  false))



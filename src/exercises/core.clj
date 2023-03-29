(ns exercises.core
; was trying to seperate tests into diff files but guess I should wait until I get to those chapters!!!
;  (:require [exercises.i-am-a-horse-in-the-land-of-booleans])
)


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
;
;;;
; Exercise 5
; Give a name answer to the answer to life the universe and everything.
;;;
;
;(def answer 42)
;


;;;
; Exercise 6
; Write the function (square x) that takes a number as a parameter and multiplies it with itself.
;;;

(defn square [x]
  (* x x))

;;;
; Exercise 7
; Write the function (average a b), which returns the average of its two parameters
;;;

(defn average 
  "returns the mean average of 2 inputs"
  [a b]
  (/ (+ a b) 2))

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


;;;;;;;;;
;;; Structured Data
;;;;;;;;;

;;;
; Exercise 1
; The following function does a thing:
;   (defn do-a-thing [x]
;     (Math/pow (+ x x) (+ x x)))
; Change the function do-a-thing so that it uses let to give a name to the common expression (+ x x) in its body. 
;;;

(defn do-a-thing [x]
  (let [xx (+ x x)]
    (Math/pow xx xx)))

;;;
; Exercise 2
; Write the function (spiff v) that takes a vector and returns the sum of the first and third elements of the vector.
;;;

(defn spiff [v]
  (let [a (get v 0)
       b (get v 2)]
       (+ a b)))

;;;
; Exercise 3
; Write the function (cutify v) that takes a vector as a parameter and adds "<3" to its end.
;;;

(defn cutify [v]
  (conj v "<3"))

;;;
; Exercise 4
; Rewrite our earlier function spiff by destructuring its parameter. Call this new function spiff-destructuring
;;;

(defn spiff-destructuring [v]
  (let [[x y z] v]
    (+ x z)))

;;;
; Exercise 5
; Write the functions (height rectangle) and (width rectangle) that return the height and width of the given rectangle. Use destructuring.
;

(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

(defn height [rectangle] 
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- y2 y1)))

(defn width [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- x2 x1)))

;;;
; Exercise 6
; Write the function (square? rectangle) that returns true if rectangle is a square and otherwise false
;

(defn square? [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (if (== (- x2 x1) (- y2 y1))
      true
      false)))

;;;
; Exercise 7
; Write the function (area rectangle) that returns the area of the given rectangle
;;;

(defn area [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (* (- x2 x1) (- y2 y1))))

;;;
; Exercise 8
; Write the function (contains-point? rectangle point) that returns true if rectangle contains point and otherwise false.
; Remember that you can give <= multiple parameters. (<= x y z) returns true if x≤y≤z holds. Otherwise false.
; Hint: and is useful. Use destructuring.
;;;

(defn point [a b]
  [a b])

; This works
;(defn contains-point? [rectangle point]
;  (let [[[x1 y1] [x2 y2]] rectangle
;    [x3 y3] point]
;  (println x1 y1 x2 y2 x3 y3)))

(defn contains-point? [rectangle point]
  (let [[[x1 y1] [x2 y2]] rectangle
    [x3 y3] point]
      (if (and (<= x1 x3 x2) (<= y1 y3 y2))
        true
        false)))

;;;
; Exercise 9
; Write the function (contains-rectangle? outer inner) that returns true if the rectangle inner is inside the rectangle outer and otherwise false.
;;;

; This works
;(defn contains-rectangle? [outer inner]
;  (let [[[outer-x1 outer-y1] [outer-x2 outer-y2]] outer
;        [[inner-x1 inner-y1] [inner-x2 inner-y2]] inner]
;  (println [outer-x1 outer-y1] [outer-x2 outer-y2] 
;           inner-x1 inner-y1 inner-x2 inner-y2)))

(defn contains-rectangle? [outer inner]
  (let [[[outer-x1 outer-y1] [outer-x2 outer-y2]] outer
        [[inner-x1 inner-y1] [inner-x2 inner-y2]] inner]
    (if (and (contains-point? (rectangle [outer-x1 outer-y1] [outer-x2 outer-y2]) (point inner-x1 inner-y1))
           (contains-point? (rectangle [outer-x1 outer-y1] [outer-x2 outer-y2]) (point inner-x2 inner-y2)))
    true
    false)))



(ns exercises.core-test
   (:use midje.sweet
   [exercises.core]))

;;;
; Training Day
;;;

(facts "square"
  (square 2) => 4
  (square 3) => 9)

(facts "average"
  (average 2 4) => 3
  (average 1 2) => 3/2)

;;;
; I am a horse in the land of booleans
;;;

(facts "my-bool"
  (my-bool "blah") => true
  (my-bool nil) => false
  (my-bool (+ 2 3)) => true
  (my-bool true) => true
  (my-bool false) => false)

(facts "teen?"
  (teen? 12) => false
  (teen? 13) => true
  (teen? 15) => true
  (teen? 19) => true
  (teen? 20) => false
  (teen? 27) => false)

(facts "abs"
  (abs -2) => 2
  (abs 42) => 42)

(facts "divides?"
  (divides? 2 4) => true
  (divides? 4 2) => false
  (divides? 5 10) => true
  (divides? 2 5) => false)

(facts "fizzbuzz"
  (fizzbuzz 2)  => ""
  (fizzbuzz 45) => "gotcha!"
  (fizzbuzz 48) => "fizz"
  (fizzbuzz 70) => "buzz" )

(facts "generic-doublificate"
  (generic-doublificate 1)        => 2
  (generic-doublificate [1 2])    => 4
  (generic-doublificate '(65 21)) => 4
  (generic-doublificate {})       => nil
  (generic-doublificate [])       => nil
  (generic-doublificate {:a 1})   => true) 

(facts "not-teen?"
  (not-teen? 13) => false
  (not-teen? 25) => true
  (not-teen? 12) => true
  (not-teen? 19) => false
  (not-teen? 20) => true)

(facts "leap-year?"
  (leap-year? 100) => false
  (leap-year? 200) => false
  (leap-year? 400) => true
  (leap-year? 12)  => true
  (leap-year? 20)  => true
  (leap-year? 15)  => false)

;;;
; Structured Data
;;;

(facts "do-a-thing"
  (do-a-thing 3) => 46656.0
  (do-a-thing 1) => 4.0
  (do-a-thing 0) => 1.0)

(facts "spiff"
  (spiff [1 2 3]) => 4
  (spiff [1 2 -34 4 5 6]) => -33)

(facts "cutify"
  (cutify []) => ["<3"]
  (cutify [1 2 3]) => [1 2 3 "<3"]
  (cutify ["a" "b"]) => ["a" "b" "<3"])

(facts "spiff-destructuring"
  (spiff-destructuring [1 2 3]) => 4
  (spiff-destructuring [1 2 -34 4 5 6]) => -33)

(facts "height rectangle"
  (height (rectangle [1 1] [5 1])) => 0
  (height (rectangle [1 1] [5 5])) => 4
  (height (rectangle [0 0] [2 3])) => 3)

(facts "width rectangle"
  (width (rectangle [1 1] [5 1]))  => 4
  (width (rectangle [1 1] [1 1]))  => 0
  (width (rectangle [3 1] [10 4])) => 7)

(facts "square? rectsngle"
  (square? (rectangle [1 1] [2 2])) => true
  (square? (rectangle [1 1] [2 3])) => false
  (square? (rectangle [1 1] [1 1])) => true
  (square? (rectangle [3 2] [1 0])) => true
  (square? (rectangle [3 2] [1 1])) => false)

(facts "area rectangle"
  (area (rectangle [1 1] [5 1])) => 0
  (area (rectangle [0 0] [1 1]))  => 1
  (area (rectangle [0 0] [4 3]))  => 12
  (area (rectangle [3 1] [10 4])) => 21)

(facts "contains-point?"
  (contains-point? (rectangle [0 0] [2 2])
                 (point 1 1))            => true
  (contains-point? (rectangle [0 0] [2 2])
                 (point 2 1))            => true
  (contains-point? (rectangle [0 0] [2 2])
                 (point -3 1))           => false
  (contains-point? (rectangle [0 0] [2 2])
                 (point 1 3))            => false
  (contains-point? (rectangle [1 1] [2 2])
                 (point 1 1))            => true
  (contains-point? (rectangle [1 1] [1 1])
                 (point 1 1))            => true)

(facts "contains-rectangle?"
  (contains-rectangle? (rectangle [0 0] [3 3])
                     (rectangle [1 1] [2 2])) => true
  (contains-rectangle? (rectangle [0 0] [2 2])
                     (rectangle [1 1] [3 3])) => false
  (contains-rectangle? (rectangle [0 0] [1 1])
                     (rectangle [0 0] [1 1])) => true
  (contains-rectangle? (rectangle [0 0] [1 1])
                     (rectangle [1 1] [2 2])) => false)



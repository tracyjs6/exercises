(ns exercises.core-test
   (:use midje.sweet
   [exercises.core]))

(facts "square"
  (square 2) => 4
  (square 3) => 9)

(facts "average"
  (average 2 4) => 3
  (average 1 2) => 3/2)

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



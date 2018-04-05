(ns teamwork.core-test
  (:require [clojure.test :refer :all]
            [teamwork.core :refer :all]
            [teamwork.trycatch :refer :all]))

(deftest several-tests
  (testing "mathematical operations"
    (testing "addition"
      (is (= 5 (addTwoNumbers 2 3)))
      (is (= 0 (addTwoNumbers -1 1 )))
      (is (= 4 (addTwoNumbers -5 1 ))))
    (testing "notation conversion with infix macro"
      (= '(+ 1 3) (macroexpand '(infix (1 + 3))))
      (= '(/ 1 3) (macroexpand '(infix (1 / 3))))
      (= '(/ 3 1) (macroexpand '(infix (1 / 3))))
      ))
  (testing "exceptions"
    (is (thrown? ArithmeticException (/ 1 0)))
    (is (thrown? ArithmeticException (/ 1 1)))
  (is (thrown-with-msg? ArithmeticException #"Divide by zero"
                        (/ 1 0)))
  (is (thrown-with-msg? ArithmeticException #"memory"
                        (/ 1 0)))))



(run-tests 'teamwork.core 'teamwork.trycatch 'teamwork.core-test)
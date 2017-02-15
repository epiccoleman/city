(ns city.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  ; setup function returns initial state. It contains
  ; circle color and position.
  (def buildings-cnt 5)
  
  (vec (loop [ cnt buildings-cnt 
          buildings '([ 20 200 50 100])]
    (if (= 0 cnt) 
      buildings 
      (recur (dec cnt) 
             (conj buildings 
                   [(* cnt 70) 
                    200 
                    50 
                    (+ (rand 100) 100)]))))))

(defn draw [state]
  ; Clear the sketch by filling it with black color.
  (q/background 0 0 0)

  ; Set shape color.
  (q/fill 255 255 255)

  ; Draw a rectangle
  (doseq [rect state] 
    (apply q/rect rect))
)

(q/defsketch city
  :title "i feel lost in the city"
  :size [500 500]
  ; setup function called only once, during sketch initialization.
  :setup setup
  :draw draw
  :features [:keep-on-top]
  ; This sketch uses functional-mode middleware.
  ; Check quil wiki for more info about middlewares and particularly
  ; fun-mode.
  :middleware [m/fun-mode])

(ns city.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (let [ buildings-cnt 10 
         building-width (/ 500 buildings-cnt)]
         
    (loop [ buildings []
            iter 0 ] 
      (if (>= iter buildings-cnt)
       buildings 
       (recur 
         (conj buildings [ (* building-width iter) 
                           500 
                           building-width 
                           (* -1 (+ 200 (rand 200)))] )
         (inc iter))))))

(defn draw [state]
  (q/background 0 0 0)
  (q/fill 255 255 255)

  (doseq [ building state ]
    (apply q/rect building))) 

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

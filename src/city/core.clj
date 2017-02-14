(ns city.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  ; setup function returns initial state. It contains
  ; circle color and position.
  [])

(defn draw [state]
  ; Clear the sketch by filling it with black color.
  (q/background 0 0 0)
  ; Set shape color.
  (q/fill 255 255 255)
  ; Draw a rectangle
  (q/rect 250 250 70 80)
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

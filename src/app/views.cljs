(ns app.views
  (:require [app.state :refer [state]]))

(defn increment []
  (swap! state update-in [:count] inc))

(defn decrement []
  (swap! state update-in [:count] dec))

(defn app []
  [:div
   [:h1.title "Simple Webapp"]
   [:div.wrapper
    [:button.btn {:on-click #(decrement)} "-"]
    [:p.counter (get @state :count)]
    [:button.btn {:on-click #(increment)} "+"]]])

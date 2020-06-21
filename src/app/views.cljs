(ns app.views
  (:require [reagent.core :refer [atom]]))

(defonce tasks (atom '({:1 "Teszt" :2 false} {:1 "Alma" :2 false} {:1 "Körte" :2 false} {:1 "Barack" :2 false})))

(defn atom-input [value]
    [:input {:type "text"
             :value @value
             :on-change #(reset! value (-> % .-target .-value))}])

(defn add [value]
  (swap! tasks conj {:1 @value :2 false})
  (reset! value ""))


(defn clear-all []
    (reset! tasks '()))

(defn delete-task [value]
    (swap! tasks (remove (nth @tasks @value) tasks)))

;(defn done [value])


(defn app []
  (let [val (atom "")]
    (fn []
      [:div
       [:h1 "TODO WEBAPP"]
       [:p [atom-input val]]
       [:button.btn1 {:on-click #(add val)} "Add"]
       [:button.btn1 {:on-click #(clear-all)} "Clear"]
       [:p.counter "Tasks: " (count @tasks)]
       [:p @tasks]
       (for [x (range (count @tasks))]
        (let [task (nth @tasks x)]
          [:p [:input {:type "checkbox" :on-click #() }] (task :1) [:button.btn2 {:on-click #(delete-task x) } "Delete"]]))])))

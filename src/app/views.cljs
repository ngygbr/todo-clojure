(ns app.views
  (:require [reagent.core :refer [atom]]))

(def tasks (atom []))

(defn atom-input [value]
    [:input {:type "text"
             :value @value
             :on-change #(reset! value (-> % .-target .-value))}])

(defn add [value]
  (swap! tasks conj {:1 @value :2 false})
  (reset! value ""))

(defn clear-all []
    (reset! tasks []))

(defn delete-task [value]
    (reset! tasks (into [] (concat (subvec @tasks 0 value)(subvec @tasks (inc value))))))

(defn done [value]
  (swap! tasks update-in [value :2] not))

(defn app []
  (let [val (atom "")]
    (fn []
      [:div
       [:h1 "TODO WEBAPP"]
       [:p [atom-input val]]
       [:button.btn1 {:on-click (when (not (empty? @val)) #(add val))} "Add"]
       [:button.btn1 {:on-click #(clear-all)} "Clear"]
       [:p.counter "Tasks: " (count @tasks)]
       (for [x (range (count @tasks))]
        (let [task (nth @tasks x)]
          [:p.lines [:input {:type "checkbox" :checked (task :2) :on-click #(done x)}] (task :1) [:button.btn2 {:on-click #(delete-task x) :class [(when (not (task :2)) "hidden" )]} "Delete"]]))])))

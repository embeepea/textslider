(ns textslider.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(def app-state (atom {:value 9}))

(defn text-input [data owner]
  (om/component
   (dom/input #js{:type "text" :size 1 :value (:value data)
                  :onInput (fn [e]
                             (let [value (.. e -target -value)]
                               (om/update! data :value value)
                               ))})))

(defn slider-input [data owner]
  (om/component
   (dom/input #js{:type "range" :min 0 :max 10 :step 1 :value (:value data)
                  :onInput (fn [e]
                             (let [value (.. e -target -value)]
                               (om/update! data :value value)
                               ))})))

(defn text-slider [app owner]
  (let [handle-update (fn [e]
                        (let [value (.. e -target -value)]
                          (om/update! app :value value)
                          ))]
  (om/component
   (dom/div nil
            (om/build text-input app)
            (om/build slider-input app)
            ))))


(om/root
 text-slider
  app-state
  {:target (. js/document (getElementById "app"))})

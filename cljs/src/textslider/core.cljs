(ns textslider.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(def app-state (atom {:value 6}))

(defn text-slider [app owner]
  (let [handle-update (fn [e]
                        (let [value (.. e -target -value)]
                          (om/update! app :value value)
                          ))]
  (om/component
   (dom/div #js{:className "textslider"}
       (dom/input #js{:type "text" :size 1 :value (:value app) :onInput handle-update })
       (dom/input #js{:type "range" :min 0 :max 10 :step 1 :value (:value app) :onInput handle-update})
       ))))

(om/root
 text-slider
  app-state
  {:target (. js/document (getElementById "app"))})

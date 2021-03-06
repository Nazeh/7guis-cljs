(ns app.core
  "This namespace contains your application and is the entrypoint for 'yarn start'."
  (:require [reagent.core :as r]
            [app.counter :refer [counter]]
            app.temp-converter))

(def app-state 
  (r/atom 
   {:count 0}))

(defn app []
  [:main.app
   [counter (:count @app-state)]])

(defn ^:dev/after-load render
  "Render the toplevel component for this app."
  []
  (r/render [app] (.getElementById js/document "app")))

(defn ^:export main
  "Run application startup logic."
  []
  (render))

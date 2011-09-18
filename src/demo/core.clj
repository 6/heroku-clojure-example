(ns demo.core
  (:use [compojure.core :only [defroutes]])
  (:require [ring.adapter.jetty :as ring]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [demo.controllers]))

(defroutes routes
  demo.controllers/routes
  (route/resources "/"))

(def application (handler/site routes))

(defn start [port]
  (ring/run-jetty (var application) {:port (or port 8080) :join? false}))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (start port)))
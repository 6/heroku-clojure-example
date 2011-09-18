(ns demo.controllers
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]))

(defroutes routes
  (GET  "/" [] "<h2>Hello World</h2>"))
  
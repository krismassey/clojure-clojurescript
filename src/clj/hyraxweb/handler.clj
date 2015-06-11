(ns hyraxweb.handler
  (:require [compojure.route :as route]
            [compojure.core :refer [GET defroutes]]
            [ring.util.response :refer [content-type resource-response response]]
            [ring.middleware.json :as middleware]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defroutes app-routes
  (GET "/" [] (-> (resource-response "index.html" {:root "public"})(content-type "text/html")))
  (GET  "/widgets" [] (response [{:name "Widget 1"} {:name "Widget 2"} {:name "Widget 3"}]))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)
      (wrap-defaults api-defaults)))



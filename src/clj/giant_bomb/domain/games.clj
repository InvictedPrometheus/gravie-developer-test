(ns giant-bomb.domain.games
  (:require [giant-bomb.config :refer [env]]
            [clj-http.client :as http]
            [cheshire.core :as json]))

(defn host [] (-> env :gb :host))
(defn api-key []  (-> env :gb :api-key))
(defn user-agent [] (-> env :gb :user-agent))

(defn- process-response [response]
  "Process response, handling errors where appropriate."
  (-> response
      :body
      (json/parse-string true)
      :results))

(defn resource [path & [opts]]
  "Retrieves a resource from the backing HTTP API."
  (-> (str (host) path)
      (http/get {:content-type :json
                 :headers      {"User-Agent" (user-agent)}
                 :query-params (merge opts {:api_key (api-key)
                                            :format  "json"})})
      process-response))

(defn game [guid]
  "Retrieves all details for a game with the given :guid."
  (resource (str "game/" guid "/")))

(def game-type "game")

(defn game-search [query]
  "Finds a game with the given search :query."
  (resource "search" {:query         query
                      :resources     game-type
                      :resource_type game-type}))

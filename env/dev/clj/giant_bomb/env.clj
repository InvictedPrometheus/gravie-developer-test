(ns giant-bomb.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [giant-bomb.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[giant-bomb started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[giant-bomb has shut down successfully]=-"))
   :middleware wrap-dev})

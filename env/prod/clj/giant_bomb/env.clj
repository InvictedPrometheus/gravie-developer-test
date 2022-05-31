(ns giant-bomb.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[giant-bomb started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[giant-bomb has shut down successfully]=-"))
   :middleware identity})

(ns giant-bomb.routes.home
  (:require
    [giant-bomb.layout :as layout]
    [giant-bomb.middleware :as middleware]
    [giant-bomb.db.core :as db]
    [ring.util.response]
    [ring.util.http-response :as response]
    [giant-bomb.domain.games :as games]
    [giant-bomb.domain.sales :as sales]))

(defn games-page [{:keys [flash] :as request}]
  "Renders the home search page."
  (layout/render request "home.html" flash))

(defn search-page [{:keys [params] :as request}]
  "Searches for games with the given :query string and displays the results on the home page."
  (if-let [query (:query params)]
    (let [results (->> query
                       games/game-search
                       (map sales/with-pricing))]
      (-> (response/found "/")
          (assoc :flash {assoc params :games results})))
    (layout/render request "error.html")))

(defn checkout-page [{:keys [params] :as request}]
  "Request a single game for checkout."
  (if-let [game (->> params
                     :guid
                     games/game
                     sales/with-pricing)]
    (layout/render request "checkout.html" {:game game})
    (layout/render request "error.html")))

(defn rent-game! [{:keys [params]}]
  "Save a rental to the database."
  (if-let [sale (sales/rent-game params)]
    (do
      (db/create-rental! sale)
      (-> (response/found "/")
          (assoc :flash {assoc params :msg "Rental Successful!!"})))))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get games-page}]
   ["/search" {:get search-page}]
   ["/checkout" {:get checkout-page}]
   ["/rent" {:post rent-game!}]])


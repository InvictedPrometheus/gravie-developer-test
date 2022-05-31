(ns giant-bomb.domain.sales)

(def default-pricing
  {:rental {:monthly {:usd 4.99}}})

(defn with-pricing [obj]
  "Returns a static pricing object for development."
  (merge obj default-pricing))

(defn rent-game [obj]
  "TODO: needs payment implementation."
  (assoc obj :paid true))

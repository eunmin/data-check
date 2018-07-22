(ns data-check.core)

(defmulti valid? (fn [value expect]
                   (class expect)))

(defmethod valid? clojure.lang.PersistentArrayMap [value expect]
  (every? true? (map (fn [[k v]]
                       (if (contains? value k)
                         (valid? (get value k) v)
                         true))
                     expect)))

(defmethod valid? clojure.lang.PersistentVector [value expect]
  (every? true? (map #(valid? % (first expect)) value)))

(defmethod valid? clojure.lang.PersistentHashSet [value expect]
  (not (nil? (expect value))))

(defmethod valid? :default [value expect]
  (= value expect))

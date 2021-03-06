(ns recursion)

(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll) (product (rest coll)))))

(defn singleton? [coll]
  (if (empty? coll)
        false
        (empty? (rest coll))))

(defn my-last [coll]
  (if (or (empty? coll) (singleton? coll))
    (first coll)
    (my-last (rest coll))))

(defn max-element [a-seq]
  (cond
    (empty? a-seq)
    nil
    (singleton? a-seq)
    (first a-seq)
    :else
    (max (first a-seq) (max-element (rest a-seq)))))

(defn seq-max [seq-1 seq-2]
  (if (= (count seq-1) (max (count seq-1) (count seq-2)))
         seq-1
         seq-2))

(defn longest-sequence [a-seq]
  (cond
    (empty? a-seq)
    nil
    (singleton? a-seq)
    (first a-seq)
    :else
    (seq-max (first a-seq) (longest-sequence (rest a-seq)))))

(defn my-filter [pred? a-seq]
  (cond
    (empty? a-seq)
    a-seq
    (pred? (first a-seq))
    (cons (first a-seq) (my-filter pred? (rest a-seq)))
    :else
    (my-filter pred? (rest a-seq))))

(defn sequence-contains? [elem a-seq]
  (cond
    (empty? a-seq) false
    (= elem (first a-seq)) true
    :else
    (sequence-contains? elem (rest a-seq))))

(defn my-take-while [pred? a-seq]
  (cond
    (empty? a-seq) ()
    (pred? (first a-seq)) (cons (first a-seq) (my-take-while pred? (rest a-seq)))
    :else
    ()))

(defn my-drop-while [pred? a-seq]
  (cond
    (empty? a-seq) ()
    (pred? (first a-seq)) (my-drop-while pred? (rest a-seq))
    :else (seq a-seq)))

(defn seq= [a-seq b-seq]
  (cond
    (and (empty? a-seq) (empty? b-seq))
    true
    (or (empty? a-seq) (empty? b-seq))
    false
    :else
    (= (= (first a-seq) (first b-seq))
       (seq= (rest a-seq) (rest b-seq)))))

(defn my-map [f seq-1 seq-2]
  (if (or (empty? seq-1) (empty? seq-2))
    ()
    (cons (f (first seq-1) (first seq-2))
          (my-map f (rest seq-1) ( rest seq-2)))))

(defn power [n k]
  (if (zero? k)
    1
    (* n (power n (dec k)))))

(defn fib [n]
  (if (< n 2)
    n
    (+ (fib (- n 1))
       (fib (- n 2)))))

(defn my-repeat [how-many-times what-to-repeat]
  (if (<= how-many-times 0)
    ()
    (cons what-to-repeat (my-repeat (dec how-many-times)
                                    what-to-repeat))))

(defn my-range [up-to]
  (if (zero? up-to)
    ()
    (cons (dec up-to) (my-range (dec up-to)))))

(defn tails [a-seq]
  (if (empty? a-seq)
    (cons () ())
    (cons (seq a-seq) (tails (rest a-seq)))))

(defn inits [a-seq]
  (let [a-seq (reverse a-seq)]
    (map reverse (tails a-seq))))

(defn rotations [a-seq]
  (let [rot-count (count a-seq)
        rotation #(concat (rest %) [(first %)])
        rec (fn rec [n s] (if (zero? n)
                            ()
                            (cons (rotation s) (rec (dec n) (rotation s))))) ]
    (if (empty? a-seq)
      (list ())
      (rec rot-count a-seq))))

(defn my-frequencies-helper [freqs a-seq]
  (if (empty? a-seq)
    freqs
    (let [k (first a-seq)
          n (freqs k 0)
          freqs (assoc freqs k (inc n))]
      (my-frequencies-helper freqs (rest a-seq)))))

(defn my-frequencies [a-seq]
  (my-frequencies-helper {} a-seq))

(defn un-frequencies [a-map]
  (if (empty? a-map)
    ()
    (let [[k n] (first a-map)]
      (concat (repeat n k) (un-frequencies (rest a-map))))))

(defn my-take [n coll]
  (cond
    (empty? coll) ()
    (zero? n) ()
    :else
    (cons (first coll) (my-take (dec n) (rest coll)))))

(defn my-drop [n coll]
  (cond
    (empty? coll) ()
    (zero? n) coll
    :else
    (my-drop (dec n) (rest coll))))

(defn halve [a-seq]
  (let [half (int (/ (count a-seq) 2))]
    [(my-take half a-seq) (my-drop half a-seq)]))

(defn seq-merge [a-seq b-seq]
  (let [[long-seq short-seq] (if (= a-seq (seq-max a-seq b-seq))
                               [a-seq b-seq]
                               [b-seq a-seq])]
    (if (empty? short-seq)
      long-seq
      (let [[min-elem same-seq rest-seq] (if (= (first a-seq) (min (first a-seq) (first b-seq)))
                                           [(first a-seq) b-seq (rest a-seq)]
                                           [(first b-seq) a-seq (rest b-seq)]) ]
        (cons min-elem (seq-merge same-seq rest-seq))))))

(defn merge-sort [a-seq]
  [:-])

(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])


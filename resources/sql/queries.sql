-- :name create-rental! :! :n
-- :doc creates a new rental record
INSERT INTO rentals
(game_guid, email, phone, name, address_line_1, address_line_2, city, state, postal_code)
VALUES (:game_guid, :email, :phone, :name, :address_line_1, :address_line_2, :city, :state, :postal_code)

-- :name get-rental :? :1
-- :doc retrieves a rental record given the id
SELECT * FROM rentals
WHERE id = :id

-- :name delete-rental! :! :n
-- :doc deletes a rental record given the id
DELETE FROM rentals
WHERE id = :id

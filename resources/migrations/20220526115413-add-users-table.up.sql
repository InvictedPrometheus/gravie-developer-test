CREATE TABLE rentals
(id BIGSERIAL PRIMARY KEY,
 game_guid TEXT,
 email TEXT NOT NULL,
 phone TEXT,
 name TEXT NOT NULL,
 address_line_1 TEXT NOT NULL,
 address_line_2 TEXT,
 city TEXT NOT NULL,
 state TEXT NOT NULL,
 postal_code TEXT,
 paid BOOLEAN NOT NULL DEFAULT FALSE);

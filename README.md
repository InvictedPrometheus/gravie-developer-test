# Gravie Software Engineer Challenge

## Game Rentals 'R Us

This is a web application built on the [Luminus](https://luminusweb.com/) web framework for Clojure. For the MVP, users can:

- _Search_ => `/` => for games by title
- _Rent_ => `/checkout?game_guid=<guid>` => single games for $4.99 / month by supplying contact, payment, and shipping information

The development application is backed by an embedded [H2](http://h2database.com/html/main.html) database engine.

### Execution

Run the application with the following steps:

- Install [Leiningen](https://leiningen.org/)
- Supply a valid `:gb-api-key` in the [dev-config.edn](dev-config.edn) file
- Run these commands in a shell: `lein run migrate && lein run -Dconf=dev-config.edn`

### Navigating the Application

The main application files and directories are:

- `giant-bomb.domain.games`=> API wrapper to search games and retrieve game details
- `giant-bomb.domain.sales` => a "no-op" wrapper for pricing and payments
- `giant-bomb.routs.home` => routing for web resources
- `public/html/` => The HTML assets for the search and checkout pages
- `public/migration/` => creates the `rentals` table
- `public/sql` => queries on the `rentals` table

### Possible Improvements

- _Testing_ => unit, integration, and automated tests
- _Rental Management_ => cancel rentals, marked as lost, etc
- _Users_ => add a user management table so that users can save personal information and manage rentals
- _Payments_ => implement a payments system, including a payment integration API (e.g. [PayPal](https://developer.paypal.com/docs/api/payments/v2/))
- _Pricing_ => implement a dynamic pricing system, e.g. subscription accounts

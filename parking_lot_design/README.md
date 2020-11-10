A person/machine is traveling, and its night or battery discharged so car parking/charging is needed.

Now APP comes into picture, app calls an API with some booking details. API replies back with the address where car can be parked.

__Happy Parking/Charging for a night 🚗__

In the morning car is safe and the person/machine leaves happily.

__Thanks to your design that this happened 😎__


## Chaos

* Story
* Problem Statement
* Requirement Gathering
* HLD
* LLD
* Selecting the tech-stack
* Database Schema
* API
* Design patterns
* War does the code
* Testing
* Logging
* Deployment
* Monitoring
* Maintainability and extension
* Randomness, humans, chaos

## Board
https://xerotohero.atlassian.net/wiki/spaces/DES/pages/294927/Parking+Lot

## Resources

* https://www.vertabelo.com/blog/constructing-a-data-model-for-a-parking-lot-management-system/
* https://www.vertabelo.com/blog/tap-and-park-a-parking-app-data-model/
* https://www.parkme.com/
* https://github.com/mgruben/Kd-Trees
* https://www.baeldung.com/java-range-search


## Apis
```
Curator:
	/addParkingLot (Use strategy pattern)

Customer:
	/addCustomer(Use strategy pattern)
	/getParkingLot
	/addParkingReservation(Use strategy pattern)
	/getParkingCost (Use strategy pattern)

Gate of parking lot:
	/addCustomer (Use strategy pattern)
	/addParkingReservation
	/getParkingCost (Use strategy pattern)

  ```

## LLD

```
Parking Lot
--------------------------------------
	parking_lot
		id
		number_of_blocks
		is_slot_available
		navigation_address
		point
		phones
		is_reentry_allowed
		operation_hrs
		is_monthly_pass_allowed
		monthly_pass_cost
		parking_pricing
		amenities
		reviewCount
		reviews
		reviewScore
		note
		handicapSpacesTotal
		url
		isOpen
		photos

	parking_pricing
		id
		parking_lot_id
		day_of_week
		morning_hr_cost
		midday_hr_cost
		evening-hr_cost
		all_day_cost
		each_hr_cost

	offers
		id
		parking_lot_id
		issued_on
		vallid_till
		booking_date_from
		booking_date_till
		discount_in_percentage
		max_amount_offer
		discount_in_amount
		offer_code

	pricing_exception
		id
		parking_lot_id
		date
		moring_hr_cost
		midday_hr_cost
		evening_hr_cost
		all_day_cost

Customer
--------------------------------------
	customer
		id
		reg_date
		is_regular_customer
		contact_number
		first_name
		last_name
		billing_address

	payment_method
		id
		customer_id
		is_card_payment
		is_wallet_payment
		is_cash_payment
		wallet_id
		card_type
		card_number
		expiry_month
		expiry_year
		security_code

	vehicle
		id
		customer_id
		customer_vehicle_number

Parking Reservation
--------------------------------------
	parking_monthly_pass
		id
		customer_id
		parking_lot_id
		purchase_date
		start_date
		duration_in_day
		cost

	parking_one_time_reservation
		id
		customer_vehicle_id
		parking_lot_id
		start_timestamp
		end_timestamp
		booking_for_hr
		basic_parking_cost
		offer_cost
		net_cost
		is_paid
		future_reservation
		future_reservation_discount
		future_reservation_cancellation_charges

```

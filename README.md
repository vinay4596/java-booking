# java-booking

Please find the CURL command for two user stories below:

User Story 1: As a customer I want to be able to request a booking at this restaurant.

curl -X POST \
  http://localhost:8080/booking \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: a1213511-3868-1635-56d0-70418e172bfd' \
  -d '{

	"customerName":"test",
	"tableSize":4,
	"timeSlot":"8-10"
}'


User Story 2: As the restaurant owner I want to be able to see all bookings for a particular day.

curl -X GET \
  http://localhost:8080/booking/25-10-2022 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 11136cd3-f5ec-5b59-21dd-8d9c94197604'

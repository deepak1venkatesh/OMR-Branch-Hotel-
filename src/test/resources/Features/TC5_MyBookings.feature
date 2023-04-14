@MyBookings
Feature: Verify Cancel booking in OMR Branch Hotel

  Scenario Outline: Cancel the order ID
    Given User is on the OMR Branch Hotel login page
    When User login "<username>" and "<password>"
    Then User should verify Success message after login "Welcome Deepak"
    When User search hotel "<state>","<city>","<roomType>","<check-In>","<check-Out>","<nooRooms>","<noofAdults>" and "<noofChilds>"
    Then User should verify success message after search "Select Hotel"
    When User select hotel
    And accept the alert
    Then User should verify success message "Book Hotel" after accepting the alert and save the hotel name
    When User enters the Guest details "<salutation>" ,"<firstName>", "<lastName>" , "<mobileno>", "<email>"
    And User enter the GST details "<gstRegistrationNo>" ,"<companyName>", "<companyAddress>"
    And User clicks any request checkbox and Enter the requests "<requestBox>"
    And User enter the payment type and card details with "<cardType>"
      | cardName | cardNo           | nameoncar | month | year | cvv |
      | Visa     | 5555555555552222 | deepak    | April | 2024 | 325 |
    Then User should verify the success message "Booking is Confirmed" and save the booking id
    When User navigate to my bookings page
    Then User should verify booked hotel name in My bookings page
    When User cancel the booked hotel through order id
    Then User Should verify the orderID
    And User should verify cancel booking success message "Your booking cancelled successfully"

    Examples: 
      | username                   | password     | state      | city    | roomType | check-In   | check-Out  | nooRooms | noofAdults | noofChilds | salutation | firstName | lastName  | mobileno   | email                      | gstRegistrationNo | companyName            | companyAddress | requestBox     | cardType   |
      | deepak1venkatesh@gmail.com | Password@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-23 | 2023-04-25 | 1-One    | 1-One      |          1 | Mr.        | Deepak    | Venkatesh | 9876543210 | deepak1venkatesh@gmail.com |        9043592058 | Greens Tech OMR Branch | Thoraipakkam   | Early check in | Debit Card |

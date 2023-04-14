@BookHotel
Feature: Booking hotel using different payment types

  @BookHotelONE
  Scenario Outline: Book hotel including GST using debit card (VISA) - with special request
    Given User is on the OMR Branch login page
    When User enter "<username>" and "<password>"
    Then User should verify Success message after login "Welcome Deepak"
    When User search hotel "<state>","<city>","<roomType>","<check-In>","<check-Out>","<nooRooms>","<noofAdults>" and "<noofChilds>"
    Then User should verify success message after search "Select Hotel"
    When User select hotel
    And User accept the alert
    Then User should verify success message "Book Hotel" after accepting the alert and save the hotel name
    When User enters Guest details "<salutation>","<firstName>","<lastName>","<mobileno>" and "<email>"
    And User enters GST details "<gstRegistrationNo>","<companyName>" and "<companyAddress>"
    And User click any checkbox request and enters special request "<requestBox>"
    And User enters payment details and select "<cardType>"
      | cardName   | cardNo           | nameoncar | month | year | cvv |
      | Visa       | 5555555555552222 | deepak    | April | 2024 | 325 |
      | MasterCard | 5555555555552222 | deepak    | April | 2024 | 325 |
      | Amex       | 5555555555552222 | deepak    | April | 2024 | 325 |
      | Discover   | 5555555555552222 | deepak    | April | 2024 | 325 |
    Then User should verify success message "Booking is Confirmed" after booking and save the order id

    Examples: 
      | username                   | password     | state      | city    | roomType | check-In   | check-Out  | nooRooms | noofAdults | noofChilds | salutation | firstName | lastName  | mobileno   | email            | gstRegistrationNo | companyName            | companyAddress | requestBox        | cardType   |
      | deepak1venkatesh@gmail.com | Password@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-23 | 2023-04-25 | 1-One    | 1-One      |          1 | Mr.        | deepak    | venkatesh | 9876543210 | deepak@gmail.com |        9043592058 | Greens Tech OMR Branch | Thoraipakkam   | Double Bed Needed | Debit Card |

  @BookHotelTWO
  Scenario Outline: Book hotel including GST using UPI with special request
    Given User is on the OMR Branch login page
    When User enter "<username>" and "<password>"
    Then User should verify Success message after login "Welcome Deepak"
    When User search hotel "<state>","<city>","<roomType>","<check-In>","<check-Out>","<nooRooms>","<noofAdults>" and "<noofChilds>"
    Then User should verify success message after search "Select Hotel"
    When User select hotel
    And User accept the alert
    Then User should verify success message "Book Hotel" after accepting the alert and save the hotel name
    When User enters Guest details "<salutation>","<firstName>","<lastName>","<mobileno>" and "<email>"
    And User enters GST details "<gstRegistrationNo>","<companyName>" and "<companyAddress>"
    And User click any checkbox request and enters special request "<requestBox>"
    And User enters payment details with UPI ID "<upiID>"
    Then User should verify success message "Booking is Confirmed" after booking and save the order id

    Examples: 
      | username                   | password     | state      | city    | roomType | check-In   | check-Out  | nooRooms | noofAdults | noofChilds | salutation | firstName | lastName  | mobileno   | email               | gstRegistrationNo | companyName            | companyAddress | requestBox | cardType   | upiID                |
      | deepak1venkatesh@gmail.com | Password@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-23 | 2023-04-25 | 1-One    | 1-One      |          1 | Mr.        | deepak    | venkatesh | 9876543211 | venkatesh@gmail.com |        9043592058 | Greens Tech OMR Branch | Thoraipakkam   | Double Bed | Debit Card | seleniumtraining@vbc |

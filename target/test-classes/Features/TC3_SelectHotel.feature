@SelectHotel
Feature: Verifying OMR Branch Hotel Login Automation
@first
  Scenario Outline: Select hotel and verifying navigate to book hotel upon accepting the alert
    Given User is on OMR branch hotel page
    When User login "<username>" and "<password>"
    Then User should verify success message "Welcome Deepak"
    When User search hotel "<state>","<city>","<roomType>","<check-In>","<check-Out>","<nooRooms>","<noofAdults>" and "<noofChilds>"
    Then User should verify success message after search "Select Hotel"
    When User select hotel and accepting the alert
    Then User should verify success message "Book Hotel" after accepting the alert message and save the hotel name

    Examples: 
      | username                   | password     | state      | city    | roomType | check-In   | check-Out  | nooRooms | noofAdults | noofChilds |
      | deepak1venkatesh@gmail.com | Password@123 | Tamil Nadu | Chennai | Deluxe   | 2023-03-29 | 2023-03-30 | 1-One    | 1-One      |          0 |
@second
  Scenario Outline: Select hotel and verify Navigating the in the same page after dismissing the alert
    Given User is on OMR branch hotel page
    When User login "<username>" and "<password>"
    Then User should verify success message "Welcome Deepak"
    When User select hotel "<state>","<city>","<roomType>","<check-In>","<check-Out>","<nooRooms>","<noofAdults>" and "<noofChilds>"
    Then User should verify success message after search "Select Hotel"
    When User select hotel 
    And User Dismiss the alert
    Then User should verify success message after search "Select Hotel"

    Examples: 
      | username                   | password     | state      | city    | roomType | check-In   | check-Out  | nooRooms | noofAdults | noofChilds |
      | deepak1venkatesh@gmail.com | Password@123 | Tamil Nadu | Chennai | Deluxe   | 2023-03-29 | 2023-03-30 | 1-One    | 1-One      |          0 |
@three
  Scenario Outline: Verify Sorting functionality hotel price from high to low
    Given User is on OMR branch hotel page
    When User login "<username>" and "<password>"
    Then User should verify success message "Welcome Deepak"
    When User select hotel "<state>","<city>","<roomType>","<check-In>","<check-Out>","<nooRooms>","<noofAdults>" and "<noofChilds>"
    Then User should verify success message after search "Select Hotel"
    When User select the radio button sort price High to Low
    Then User should verify the sorted prices of the hotel listed from high to low

    Examples: 
      | username                   | password     | state      | city    | roomType | check-In   | check-Out  | nooRooms | noofAdults | noofChilds |
      | deepak1venkatesh@gmail.com | Password@123 | Tamil Nadu | Chennai | Deluxe   | 2023-03-29 | 2023-03-30 | 1-One    | 1-One      |          0 |
@fourth
  Scenario Outline: Pass the room type and verify Filter is listed
    Given User is on OMR branch hotel page
    When User login "<username>" and "<password>"
    Then User should verify success message "Welcome Deepak"
    When User select hotel "<state>","<city>","<roomType>","<check-In>","<check-Out>","<nooRooms>","<noofAdults>","<noofChilds>"
    Then User should verify success message "Select Hotel" after search 
    And User should verify filtered room type ends with "<roomType>"
    
    Examples: 
      | username                   | password     | state      | city    | roomType | check-In   | check-Out  | nooRooms | noofAdults | noofChilds |
      | deepak1venkatesh@gmail.com | Password@123 | Tamil Nadu | Chennai | Deluxe   | 2023-03-29 | 2023-03-30 | 1-One    | 1-One      |          0 |

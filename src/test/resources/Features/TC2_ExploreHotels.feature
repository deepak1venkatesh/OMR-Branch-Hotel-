@Explorehotels
Feature: Verifying OMR branch Hotel Automation

  Scenario Outline: Enter all field and verify select hotel(including options)
    Given User is on the OMR Branch Hotel Page
    When User login "<username>" and "<password>"
    Then User should verify success message "Welcome Deepak"
    When User search hotel "<state>","<city>","<roomType>","<check-In>","<check-Out>","<noofRooms>","<noofAdults>" and "<noofChilds>"
    Then User should verify success message after search "Select Hotel"

    Examples: 
      | username                   | password     | state      | city    | roomType | check-In   | check-Out  | noofRooms | noofAdults | noofChilds |
      | deepak1venkatesh@gmail.com | Password@123 | Tamil Nadu | Chennai | Deluxe   | 2023-03-26 | 2023-03-28 | 1-One     | 1-One      |          0 |

  Scenario Outline: Enter Only mandatory fields and verify select hotel
    Given User is on OMR branch hotel page
    When User login "<username>" and "<password>"
    Then User should verify success message "Welcome Deepak"
    When User search hotel "<state>","<city>","<check-In>","<check-Out>","<noofRooms>" and "<noofAdults>"
    Then User should verify success message after search "Select Hotel"

    Examples: 
      | username                   | password     | state      | city    | check-In   | check-Out  | noofRooms | noofAdults |
      | deepak1venkatesh@gmail.com | Password@123 | Tamil Nadu | Chennai | 2023-03-26 | 2023-03-28 | 1-One     | 1-One      |

  Scenario Outline: Without Entering all fields and verify all six error messages
    Given User is on OMR branch hotel page
    When User login "<username>" and "<password>"
    Then User should verify success message "Welcome Deepak"
    When User click search button
    Then User should verify six error message "Please select state","Please select city","Please select Check-in date","Please select Check-out date","Please select no. of rooms" and "Please select no. of adults"

    Examples: 
      | username                   | password     |
      | deepak1venkatesh@gmail.com | Password@123 |

  
  Scenario Outline: Enter all field and verify Filter room type & select hotel(including options)
    Given User is on OMR branch hotel page
    When User login "<username>" and "<password>"
    Then User should verify success message "Welcome Deepak"
    When User search hotel "<state>","<city>","<roomType>","<roomType1>","<roomType2>","<check-In>","<check-Out>","<noofRooms>","<noofAdults>" and "<noofChilds>"
    Then User should verify success message after search "Select Hotel"
    And User should verify the success message filter room type "Standard/Deluxe/Suite"

    Examples: 
      | username                   | password     | state      | city    | roomType | roomType1 | roomType2 | check-In   | check-Out  | noofRooms | noofAdults | noofChilds |
      | deepak1venkatesh@gmail.com | Password@123 | Tamil Nadu | Chennai | Deluxe   | Standard  | Suite     | 2023-03-28 | 2023-03-30 | 1-One     | 1-One      |          0 |

Feature: Contacts page

  Scenario: Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Customers" "Contacts"
    Then default page number should be 1

  Scenario: Verify Create Calendar Event
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendar"

  Scenario: Menu Options
    Given the user logged in as "driver"
    Then the user should see following options
      | Fleet      |
      | Customers  |
      | Activities |
      | Syste     |

  Scenario: Menu Options
    Given the user logged in as "salesmanager"
    Then the user should see following options
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |


  Scenario Outline: login as a given user <user>
    Given the user is on the login page
    Then the user logs in using following credentials
    | username   | <user>       |
    | password   | UserUser123  |
    | firstname  | <firstName>  |
    | lastname   | <lastName>   |
    Then the user should be able to login

    Examples:
    | user           | firstName | lastName |
    | user10         | John      | Doe      |
    | storemanager85 | John      | Doe      |

Feature: Account Types
  @wip @smoke
  Scenario: Driver user
    Given the user logged in as "driver"
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendar Events - Activities"
  @wip
  Scenario: Sales manager user
    Given the user logged in as "salesmanager"
    When the user navigates to "Customers" "Accounts"
    Then the title contains "Accounts - Customers"
  @wip @smoke
  Scenario: Store manager user
    Given the user logged in as "storemanager"
    When the user navigates to "Customers" "Contacts"
    Then the title contains "Contacts - Customers"

  #DDT: DataDrivenTesting. 4 test case will be executed seperate.
  Scenario Outline: Different user types
    Given the user logged in as "<userType>"

    Examples:
    |userType|
    |driver|
    |storemanager|
    |salesmanager|
    |admin|


  Scenario Outline: Login with different accounts <userType>
    Given the user logged in as "<userType>"
    When the user navigates to "<tab>" "<module>"
    Then the title contains "<title>"

    Examples:
      | userType     | tab        | module         | title                       |
      | driver       | Activities | Calendar Events| Calendar Events - Activities|
      | storemanager | Customers  | Accounts       | Accounts - Customers        |
      | salesmanager | Customers  | Contacts       | Contacts - Customers        |

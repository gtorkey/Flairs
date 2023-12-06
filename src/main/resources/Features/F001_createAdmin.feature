Feature: Admin Records
  Scenario: Check Records in admin panel when add or remove new admin
    Given Navigate to Dashboard URL
    When login to the system with username:"Adminn" and password:"admin123"
    And go to admin panel
    And Get number of records
    When crete new admin
    Then admin added successfully and number of records should increased by 1
    When Search with the new username
    And Delete the admin
    Then admin deleted successfully and number of records should decrease by 1

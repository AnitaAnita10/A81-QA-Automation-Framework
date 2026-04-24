Feature: Login Tests

  Scenario: Login Valid Email Password
    #Given I open the browser
    Given I am in the Koel login page
    When I input email "anita.surewicz@testpro.io"
    When I input password "AnitaAnita1029"
    And I click Log in
    Then I am logged in
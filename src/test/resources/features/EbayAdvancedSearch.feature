Feature: Ebay Advanced Search Page

  @regression
  Scenario: Ebay Logo on Advanced Search Page
    Given User is on ebay advanced search page
    When User click on ebay logo
    Then Page navigated to ebay home page

  @regression @smoke
  Scenario: Advanced search an item
    Given User is on ebay advanced search page
    When User did advanced search
      | keyword   | exclude     | min | max |
      | iPhone 11 | refurbished | 300 | 900 |
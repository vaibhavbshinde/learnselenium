Feature: ebay home page scenarios

  @regression @smoke
  Scenario: Navigate Advanced Search Link
    Given User visit ebay home page
    When User click on advance link
    Then User navigate to advanced search page


  @regression @functional
  Scenario Outline: Search items count
    Given User visit ebay home page
    When User search '<product_name>'
    Then Verify that search result count more than <expected_count> item search

  Examples:
  | product_name | expected_count |
  | iPhone 11    | 1000           |
  | Toy Cars     | 100            |

  @regression @smoke
  Scenario Outline: Search an item with category
    Given User visit ebay home page
    When User search '<product_name>' in '<product_category>'
    Then Verify that search result count more than <expected_count> item search

  Examples:
  | product_name | product_category | expected_count |
  | soap         | baby             | 50             |


  @regression @menulinks
  Scenario Outline: Verify home page links
    Given User visit ebay home page
    When User click on '<link>'
    Then Verify that page navigates to '<url>' and title contains '<title>'

    Examples:
  | link    | url                                                                | title       |
  | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334     | eBay Motors |
  | Fashion | https://www.ebay.com/b/Clothing-Shoes-Accessories/11450/bn_1852545 | Clothing    |
  | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497                 | Toys        |

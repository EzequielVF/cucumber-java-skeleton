Feature:Mobile operations

  Scenario: Successfully send a message when battery is enough
    Given Mobile with a porcentage of 100 battery
    When Trying to texting
    Then Mobile battery charge should be 99

  Scenario: Successfully do a call when battery is enough
    Given Mobile with a porcentage of 100 battery
    When Trying to call 10 minutes
    Then Mobile battery charge should be 70

  Scenario: Cannot send a message when battery is not enough
    Given Mobile with a porcentage of 0 battery
    When Trying to texting
    Then Message should be denied due to insufficient battery
    And Mobile battery shoud remain 0

  Scenario: Cannot do a call with a negative duration
    Given Mobile with a porcentage of 100 battery
    When Trying to call -10 minutes
    Then Call should be denied due to negative duration
    And Mobile battery shoud remain 100

  Scenario: Cannot finish a long call if u have not enough battery
    Given Mobile with a porcentage of 30 battery
    When Trying to call 11 minutes
    Then Call should be cut down due to insufficient battery
    Then Mobile battery charge should be 0
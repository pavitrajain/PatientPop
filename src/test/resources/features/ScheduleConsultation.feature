Feature: Schedule Consultation
  Description: This feature allows user to schedule consultation

  @Regression @Positive @Pending @SectionB
  Scenario Outline: User provide correct practician details and able to schedule consultation
    Given User access PatientPop
    When User enter practician details as Practice Name: <practiceName> , Street Address: <streetAddress> , City: <city>, State: <state>, ZipCode: <zipCode>, Website: <website>, Specialty: <specialty>
    And User click Compare Now
    And User is able to view Practice Growth Results
    And User is provide correct details <"Full Name"> , <"Practice Name"> , <"Email"> , <"Phone Number"> , <"Zip"> , <"Number of Providers">
    Then User is able to schedule consultation

    Examples:
      | practiceName   | streetAddress               | city         | state      | zipCode | website                    | specialty                     |
      | Shamsah Amersi | 2825 Santa Monica Boulevard | Santa Monica | California | 90404   | https://www.dramersi.com/  | Obstetrician and Gynecologist |

  @Regression @Negative @Pending @SectionB
  Scenario Outline: User try to schedule consultation without providing practician details
    Given User access PatientPop
    When User enter practician details as Practice Name: <practiceName> , Street Address: <streetAddress> , City: <city>, State: <state>, ZipCode: <zipCode>, Website: <website>, Specialty: <specialty>
    And User click Compare Now
    And User is able to view Practice Growth Results
    And User is provide correct details <""> , <""> , <""> , <""> , <""> , <"">
    Then User get schedule consultation required field error message

    Examples:
      | practiceName   | streetAddress               | city         | state      | zipCode | website                    | specialty                     |
      | Shamsah Amersi | 2825 Santa Monica Boulevard | Santa Monica | California | 90404   | https://www.dramersi.com/  | Obstetrician and Gynecologist |

  @Regression @Negative @Pending @SectionB
  Scenario Outline: User try to schedule consultation with incorrect practician details
    Given User access PatientPop
    When User enter practician details as Practice Name: <practiceName> , Street Address: <streetAddress> , City: <city>, State: <state>, ZipCode: <zipCode>, Website: <website>, Specialty: <specialty>
    And User click Compare Now
    And User is able to view Practice Growth Results
    And User is provide correct details <"!@#!@#!@# ASDF"> , <"asfdsdf"> , <"asf"> , <"asdf"> , <"asdf"> , <"asdf">
    Then User get schedule consultation incorrect field error message

    Examples:
      | practiceName   | streetAddress               | city         | state      | zipCode | website                    | specialty                     |
      | Shamsah Amersi | 2825 Santa Monica Boulevard | Santa Monica | California | 90404   | https://www.dramersi.com/  | Obstetrician and Gynecologist |



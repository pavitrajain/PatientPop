Feature: Practice Growth Result
  Description: This feature allows user to view practice growth results

  @Regression @Positive @SectionA1 @SectionA2
  Scenario Outline: User provide correct practician details and able to view practice growth results
    Given User access PatientPop
    When User enter practician details as Practice Name: <practiceName> , Street Address: <streetAddress> , City: <city>, State: <state>, ZipCode: <zipCode>, Website: <website>, Specialty: <specialty>
    And User click Compare Now
    Then User is able to view Practice Growth Results
    And Each Section score matches scores on Overall Summary

    Examples:
      | practiceName   | streetAddress               | city         | state      | zipCode | website                    | specialty                     |
      | Shamsah Amersi | 2825 Santa Monica Boulevard | Santa Monica | California | 90404   | https://www.dramersi.com/  | Obstetrician and Gynecologist |
      | Prakash Neal   | 1500 East Duarte Road       | Duarte       | California | 91010   | http://www.cityofhope.org/ | Neurologist                   |

 @Regression @Negative @SectionA3
  Scenario: User try to view practice growth result without providing practician details
    Given User access PatientPop
    When User click Compare Now
    Then User get required field error message

  @Regression @Negative @Pending @SectionB
  Scenario: User provide incorrect practician details and get error message on trying to view practice growth result
    Given User access PatientPop
    When User enter practician details as Practice Name: "ABCD" , Street Address: "ABCD" , City: "ABCD", State: "ABCD", ZipCode: "ABCD", Website: "ABCD", Specialty: "ABCD"
    Then User get incorrect field value error message

  @Regression @Positive @Pending @SectionB
  Scenario Outline: User provide correct practician details and able to view practice growth results with score details
    Given User access PatientPop
    When User enter practician details as Practice Name: <practiceName> , Street Address: <streetAddress> , City: <city>, State: <state>, ZipCode: <zipCode>, Website: <website>, Specialty: <specialty>
    And User click Compare Now
    Then User is able to view Practice Growth Results
    And User is able to view score details for each section

    Examples:
      | practiceName  | streetAddress      | city        | state      | zipCode | website | specialty                     |
      | Prakash Neal  | 710 Westwood Plaza | Los Angeles | California | 90095   |         | Obstetrician and Gynecologist |
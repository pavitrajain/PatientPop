package stepDefinitions;

import actor.PatientPopActor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PracticeGrowthResultsTestSteps {

    @Steps
    private PatientPopActor patientPopUser;

    private static final Logger LOGGER = LoggerFactory.getLogger(PracticeGrowthResultsTestSteps.class);

    @Given("^User access PatientPop$")
    public void user_access_patient_pop() {
        LOGGER.info("Accessing Patient Pop");
        patientPopUser.accessPatientPopWebsite();
    }

    @When("^User enter practician details as Practice Name: (.*) , Street Address: (.*) , City: (.*), State: (.*), ZipCode: (.*), Website: (.*), Specialty: (.*)$")
    public void user_enter_practician_details(String practiceName, String streetAddress, String city, String state, String zipCode, String website, String specialty) {
        LOGGER.info("Entering Practice Name: " + practiceName + " , Street Address: " + streetAddress + " , City: " + city + " , State: " + state + " , ZipCode: " + zipCode + " , Website: " + website + " , Specialty: " + specialty);
        patientPopUser.enter_PracticianDetails(practiceName, streetAddress, city, state, zipCode, website, specialty);
    }

    @And("^User click Compare Now$")
    public void user_click_compare_now() {
        LOGGER.info("Clicking Compare Now");
        patientPopUser.click_CompareNow();
    }

    @Then("^User is able to view Practice Growth Results$")
    public void user_is_able_to_view_practice_growth_results() {
        LOGGER.info("Verifying Practice Growth Results is displayed");
        patientPopUser.verify_PracticeGrowthResult_IsDisplayed();
    }

    @And("^Each Section score matches scores on Overall Summary$")
    public void verify_each_section_score_matches_scores_on_overall_summary() {
        LOGGER.info("Verifying each section score matches scores on Overall Summary");
        patientPopUser.verify_EachSectionScore_Matches_ScoreInOverallSummary();
    }

    @Then("^User get required field error message$")
    public void verify_required_field_error_message() {
        LOGGER.info("Verifying required field error message");
        patientPopUser.verify_ErrorMessage();
    }

    @Pending
    @Then("^User get incorrect field value error message$")
    public void verify_incorrect_field_error_message() {}

}

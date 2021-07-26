package actor;

import net.thucydides.core.annotations.Step;
import pages.Checkup;
import pages.PracticeGrowthResult;
import utility.ProjectConfig;

public class PatientPopActor {
    //private static final Logger LOGGER = LoggerFactory.getLogger(PatientPopActor.class);

    Checkup checkupPage;
    PracticeGrowthResult practiceGrowthResultPage;

    @Step
    public void accessPatientPopWebsite() {
        checkupPage.openUrl(ProjectConfig.getPatientPopURL());
    }

    @Step
    public void enter_PracticianDetails(String practiceName, String streetAddress, String city, String state, String zipCode, String website, String specialty) {
        checkupPage.enterPracticeName(practiceName);
        checkupPage.selectPracticeItem();
        checkupPage.verifyAddress(streetAddress, city, state, zipCode, website);
        checkupPage.selectSpeciality(specialty);
    }

    @Step
    public void click_CompareNow() {
        checkupPage.clickCompareNow();
    }

    @Step
    public void verify_ErrorMessage() {
        checkupPage.verifyRequiredPracticeNameErrorMessages();
    }

    @Step
    public void verify_PracticeGrowthResult_IsDisplayed() {
        practiceGrowthResultPage.verifyPracticeGrowthResultIsDisplayed();
    }

    @Step
    public void verify_EachSectionScore_Matches_ScoreInOverallSummary() {
        practiceGrowthResultPage.verifySectionScoresMatchesSummaryScores();
    }

}

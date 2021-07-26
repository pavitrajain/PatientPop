package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.ProjectConfig;

import java.time.Duration;

public class PracticeGrowthResult extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(PracticeGrowthResult.class);

    /*
    @FindBy(xpath = "//h2[text()='Competitors']//following-sibling::div/descendant::li[@class='row your-practice']/descendant::div[@class='score-value']//*[name()='text' and @class='score-value']")
    WebElementFacade competitorsScore;
     */

    private final String scoreXPATH = "//section[contains(@class,'hide-print result row $SECTION$ active')]/descendant::li[@class='row your-practice']/descendant::div[@class='score-value']//*[name()='text' and @class='score-value']";

    public void verifyPracticeGrowthResultIsDisplayed() {
        LOGGER.info("Verifying Practice Growth Result is displayed");
        String practiceGrowthResultHeader = "//div[text()='Practice Growth Results']";
        withTimeoutOf(Duration.ofSeconds(20)).waitForPresenceOf(By.xpath(practiceGrowthResultHeader));
    }

    private String getGoogleRankScore() {
        return $(By.xpath(scoreXPATH.replace("$SECTION$", "google_rank"))).getText();
    }

    private String getWebsiteScore() {
        return $(By.xpath(scoreXPATH.replace("$SECTION$", "website"))).getText();
    }

    private String getWebPresenceScore() {
        return  $(By.xpath(scoreXPATH.replace("$SECTION$", "website_presence"))).getText();
    }

    private String getReputationScore() {
        return $(By.xpath(scoreXPATH.replace("$SECTION$", "reputation"))).getText();
    }

    public void verifySectionScoresMatchesSummaryScores() {
        String scoreSectionLinkXPATH = "//div[@class='quicklinks']/ul/li[text()='$SECTION$']";

        $(By.xpath(scoreSectionLinkXPATH.replace("$SECTION$", "Google Ranking"))).click();
        String expectedGoogleRankScore = getGoogleRankScore();

        $(By.xpath("//ul[@class='steps']/li[contains(text(),'Web presence')]")).click();
        String expectedWebPresenceScore = getWebPresenceScore();

        $(By.xpath("//ul[@class='steps']/li[contains(text(),'Website')]")).click();
        String expectedWebsiteScore = getWebsiteScore();

        $(By.xpath("//ul[@class='steps']/li[contains(text(),'Reputation')]")).click();
        String expectedReputationScore = getReputationScore();

        $(By.xpath("//ul[@class='steps']/li[contains(text(),'Overall')]")).click();

        String summaryScoreXpath = "//div[@class='summary-desktop']/div[@class='score-item summary-$SECTION$']/div//*[name()='text' and @class='score-value']";

        String actualGoogleRankScore = $(By.xpath(summaryScoreXpath.replace("$SECTION$", "google_rank"))).getText();
        ProjectConfig.log.info(LOGGER, "Google Rank Score Verification ",expectedGoogleRankScore, actualGoogleRankScore);
        ProjectConfig.softAssertions.assertThat(actualGoogleRankScore).as("Google Rank Score: ").isEqualTo(expectedGoogleRankScore);

        String actualWebPresenceScore = $(By.xpath(summaryScoreXpath.replace("$SECTION$", "website_presence"))).getText();
        ProjectConfig.log.info(LOGGER, "Web Presence Score Verification ", expectedWebPresenceScore, actualWebPresenceScore);
        ProjectConfig.softAssertions.assertThat(actualWebPresenceScore).as("Web Presence Score: ").isEqualTo(expectedWebPresenceScore);

        String actualWebsiteScore = $(By.xpath(summaryScoreXpath.replace("$SECTION$", "website"))).getText();
        ProjectConfig.log.info(LOGGER, "Website Score Verification", expectedWebsiteScore, expectedWebsiteScore);
        ProjectConfig.softAssertions.assertThat(actualWebsiteScore).as("Website Score: ").isEqualTo(expectedWebsiteScore);

        String actualReputationScore = $(By.xpath(summaryScoreXpath.replace("$SECTION$", "reputation"))).getText();
        ProjectConfig.log.info(LOGGER, "Reputation Score Verification", expectedReputationScore, actualReputationScore);
        ProjectConfig.softAssertions.assertThat(actualReputationScore).as("Reputation Score: ").isEqualTo(expectedReputationScore);
    }

}

package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.ProjectConfig;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Checkup extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(Checkup.class);

    @FindBy(id = "practicename")
    WebElementFacade practiceName;

    @FindBy(xpath = "//div[@class='pac-item']")
    WebElementFacade practiceItem;

    @FindBy(id = "specialty")
    WebElementFacade specialty;

    @FindBy(id = "diagnose-submit")
    WebElementFacade compareNow;

    public void enterPracticeName(String prctcName) {
        LOGGER.info("Entering Practice Name: " + prctcName);
        practiceName.type(prctcName);
    }

    public void selectPracticeItem() {
        LOGGER.info("Selecting Practice Item: " + practiceItem.getText());
        practiceItem.click();
    }

    private void verifyStreetAddress(String expectedStreetAddress) {
        String actualStreetAddress = $(By.id("streetaddress")).getValue();
        ProjectConfig.log.info(LOGGER, "Street Address Verification", expectedStreetAddress, actualStreetAddress);
        ProjectConfig.softAssertions.assertThat(actualStreetAddress).as("Street Address: ").isEqualTo(expectedStreetAddress);
    }

    private void verifyCity(String expectedCity) {
        String actualCity = $(By.id("city")).getValue();
        ProjectConfig.log.info(LOGGER, "City Verification", expectedCity, actualCity);
        ProjectConfig.softAssertions.assertThat(actualCity).as("City: ").isEqualTo(expectedCity);
    }

    private void verifyState(String expectedState) {
        String actualState = $(By.xpath("//div[@class='v-select__selection v-select__selection--comma']")).getText();
        ProjectConfig.log.info(LOGGER, "State Verification", expectedState, actualState);
        ProjectConfig.softAssertions.assertThat(actualState).as("State: ").isEqualTo(expectedState);
    }

    private void verifyZipCode(String expectedZipCode) {
        String actualZipcode = $(By.id("zipcode")).getValue();
        ProjectConfig.log.info(LOGGER, "ZipCode Verification", expectedZipCode, actualZipcode);
        ProjectConfig.softAssertions.assertThat(actualZipcode).as("Zip Code: ").isEqualTo(expectedZipCode);
    }

    private void verifyWebsite(String expectedWebsite) {
        String actualWebsite = $(By.id("website")).getValue();
        ProjectConfig.log.info(LOGGER, "Website Verification", expectedWebsite, actualWebsite);
        ProjectConfig.softAssertions.assertThat(actualWebsite).as("Website: ").isEqualTo(expectedWebsite);
    }

    public void verifyAddress(String expectedStreetAddress, String expectedCity, String expectedState, String expectedZipCode, String expectedWebsite) {
        waitABit(1000);
        verifyStreetAddress(expectedStreetAddress);
        verifyCity(expectedCity);
        verifyState(expectedState);
        verifyZipCode(expectedZipCode);
        verifyWebsite(expectedWebsite);
    }

    private void enterSpecialty(String spclty) {
        specialty.type(spclty);
    }

    public void selectSpeciality(String spclty) {
        LOGGER.info("Selecting Specialty: " + spclty);
        enterSpecialty(spclty);
        $(By.xpath("//span[contains(text(),'" + spclty + "')]")).click();
    }

    public void clickCompareNow() {
        LOGGER.info("Clicking CompareNow");
        compareNow.click();
    }

    public void verifyRequiredPracticeNameErrorMessages() {
        String actualPracticeNameErrorMessage = $(By.xpath("//div[@name='practicename']/descendant::div[@class='v-messages__message']")).getText();
        String expectedPracticeNameErrorMessage = "Practice Name Required!!!";
        ProjectConfig.log.info(LOGGER, "Practice Name Field Required Error Message Verification", expectedPracticeNameErrorMessage, actualPracticeNameErrorMessage);
        assertThat(actualPracticeNameErrorMessage).as("Practice Name Error Message").isEqualTo(expectedPracticeNameErrorMessage);
    }
}

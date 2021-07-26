package utility;

import net.serenitybdd.core.Serenity;
import org.slf4j.Logger;

public class Log {

    public void info(Logger logger, String title, String message) {
        logger.info(title + " : " + message);
        Serenity.recordReportData().withTitle(title).andContents(message);
    }

    public void info(Logger logger, String title, String expected, String actual) {
        String message = "Expected: " + expected + " , Actual: " + actual;
        logger.info(title + " : " + message);
        Serenity.recordReportData().withTitle(title).andContents(message);
    }
}

package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.assertj.core.api.SoftAssertions;
import utility.Log;
import utility.ProjectConfig;

public class Hook {
    @Before
    public void before() {
        ProjectConfig.softAssertions = new SoftAssertions();
        ProjectConfig.log = new Log();
    }

    @After
    public void after() {
        ProjectConfig.softAssertions.assertAll();
    }
}

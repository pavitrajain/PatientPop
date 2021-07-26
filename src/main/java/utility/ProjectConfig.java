package utility;

import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfig {
    public static final Logger LOGGER = LoggerFactory.getLogger(ProjectConfig.class);
    public static String ENV_SYSTEM_PROP = "env";
    public static String DEFAULT_ENV = "stg";
    public static SoftAssertions softAssertions;
    private static Properties properties;
    private static String envPropertyFilePath;
    public static Log log;

    static {
        if (System.getProperty(ENV_SYSTEM_PROP) == null)
        {
            LOGGER.warn("System property for execution environment configuration (" + ENV_SYSTEM_PROP + ") not set, using " + DEFAULT_ENV + " environment configuration");
            System.setProperty(ENV_SYSTEM_PROP, DEFAULT_ENV);
        }
        envPropertyFilePath = "src//test//resources//config//project." + System.getProperty(ENV_SYSTEM_PROP) + ".properties";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(envPropertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found at path: " + envPropertyFilePath);
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public static String getPatientPopURL() {
        String url = properties.getProperty("patientPopURL");
        if(url != null) {
            return url;
        } else {
            throw new RuntimeException("Patient Pop URL not specified in the project." + System.getProperty(ENV_SYSTEM_PROP) + ".properties file");
        }
    }
}

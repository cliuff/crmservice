package cn.edu.cqut.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    public static String PROJECT_DIR = "crm.project.dir";
    public static String DATASOURCE_UTIL_TABLES = "crm.datasource.tables";

    public static Properties getProperties() {
        String envPath = "config.properties";
        return getProperties(envPath);
    }

    public static Properties getProperties(String path) {
        try (InputStream in = ClassLoader.getSystemResourceAsStream(path)) {
            if (in == null) return null;
            Properties properties = new Properties();
            properties.load(in);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

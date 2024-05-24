package GPL.utils;

import java.util.ResourceBundle;
public class Settings {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("default_settings");
    public static String MPO_ID = System.getProperty("MPO_ID") != null ? System.getProperty("MPO_ID") : resourceBundle.getString("MPO_ID");
    public static String PASSWORD = System.getProperty("PASSWORD") != null ? System.getProperty("PASSWORD") : resourceBundle.getString("PASSWORD");
    public static String AM_ID = System.getProperty("AM_ID") != null ? System.getProperty("AM_ID") : resourceBundle.getString("AM_ID");
    public static String RSM_ID = System.getProperty("RSM_ID") != null ? System.getProperty("RSM_ID") : resourceBundle.getString("RSM_ID");
    public static String ZH_ID = System.getProperty("ZH_ID") != null ? System.getProperty("ZH_ID") : resourceBundle.getString("ZH_ID");
}

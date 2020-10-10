package co.com.ceiba.autocine.utils;

public class StringUtils {

    private StringUtils() {}

    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.trim().isEmpty());
    }

}

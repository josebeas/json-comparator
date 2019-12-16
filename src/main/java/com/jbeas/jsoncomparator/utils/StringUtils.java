package com.jbeas.jsoncomparator.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * String utilities in case Apache Commons Lang is not allowed
 */
public class StringUtils {
    private static String ENCODING_CHARSET = "utf-8";

    public static boolean equals(String str1, String str2){
        return (str1 != null) && (str2 != null) && str1.equals(str2);
    }

    public static boolean stringHaveSameLength(String str1, String str2){
        return (str1 != null) && (str2 != null) && str1.length() == str2.length();
    }

    public static String encode(String input) throws UnsupportedEncodingException {
        return Base64.getUrlEncoder().encodeToString(input.getBytes(ENCODING_CHARSET));
    }

    public static String decode(String input) throws UnsupportedEncodingException {
        byte[] asBytes = Base64.getUrlDecoder().decode(input);
        return new String(asBytes, ENCODING_CHARSET);
    }
}

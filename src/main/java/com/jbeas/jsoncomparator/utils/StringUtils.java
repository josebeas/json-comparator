package com.jbeas.jsoncomparator.utils;

/**
 * String utilities in case Apache Commons Lang is not allowed
 */
public class StringUtils {
    static boolean equals(String str1, String str2){
        return (str1 != null) && (str2 != null) && str1.equals(str2);
    }

    static boolean stringHaveSameLength(String str1, String str2){
        return (str1 != null) && (str2 != null) && str1.length() == str2.length();
    }
}

package PasswordManager;

/**
 * @author Nathan Premo
 * File: DataVaildation.java
 * this is going to hold the methods that will be used to check
 * data against a number of this.
 */
public class DataVaildation {
    /**
     * Source: https://www.demo2s.com/java/java-regex-check-if-string-value-is-susceptible-to-sql-injection-it-wi.html
     * Helper method to check if string value is susceptible to sql injection
     * It will check that the value only contains alphanumerics, -, and _. No spaces.
     * Externalized to it's own method to allow for ease of unit testing and/or modification of regex exp if needed.
     * @param value
     * @return the boolean answer if the string is alphaNumeric
     *
     */
    public static boolean isAlphaNumeric(String value) {
        if (value == null)
            return true;
        return value.matches("^[a-zA-Z0-9-_]+$");
    }
}

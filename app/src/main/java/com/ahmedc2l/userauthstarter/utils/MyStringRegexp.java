package com.ahmedc2l.userauthstarter.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>MyStringRegexp</h1>
 * <p>This class checks Strings against different regular expressions.</p>
 *
 * @author Ahmed Fathy
 * @since 2019-06-13
 * @version 1.0
 * */
public class MyStringRegexp {
    /**
     * <h3>isEmailValid</h3>
     * <p>checks whether an email is valid or not.</p>
     *
     * @param email String
     * @return boolean
     * */
    public static boolean isEmailValid(String email){
        String regExp =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        Pattern pattern = Pattern.compile(regExp,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /**
     * <h3>isTextValid</h3>
     * <p>checks whether a text is valid or not.</p>
     *
     * @param text String
     * @return boolean
     * */
    public static boolean isTextValid(String text){
        return text != null && !text.isEmpty() && !text.trim().equals("");
    }

    /**
     * <h3>isIntegerValid</h3>
     * <p>checks whether an integer is valid or not.</p>
     *
     * @param integer String
     * @return boolean
     * */
    public static boolean isIntegerValid(String integer){
        try {
            Integer.parseInt(integer);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * <h3>isPhoneNumberValid</h3>
     * <p>checks whether a phone number is valid or not.</p>
     *
     * @param phone String
     * @return boolean
     * */
    public static boolean isPhoneNumberValid(String phone){
        String regExp = "^[5]\\d{8}$";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(phone);

        return matcher.matches();
    }

    /**
     * <h3>isPasswordValid</h3>
     * <p>checks whether a password is valid or not.</p>
     *
     * @param password String
     * @return boolean
     * */
    public static boolean isPasswordValid(String password){
        // TODO complete password validation rules
        /*String regExp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,19}$";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();*/
        return password.length() >= 6;
    }

    public static boolean isNameValid(String name) {
        String regExpENG = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){2,24}$";
        String regExpAR = "(^[\u0621-\u064A]+$)";

        Pattern patternENG = Pattern.compile(regExpENG);

        Pattern patternAR = Pattern.compile(regExpAR);

        return patternENG.matcher(name).matches() || (patternAR.matcher(name).matches() && name.length() > 2);
    }

    /**
     * <h3>isEnglish</h3>
     * <p>checks whether a string is english or not.</p>
     *
     * @param text String
     * @return boolean
     * */
    public static boolean isEnglish(String text){
        String regExp = "[a-zA-Z]*";
        Pattern pattern = Pattern.compile(regExp);

        return pattern.matcher(text).matches();
    }

    /**
     * <h3>isArabic</h3>
     * <p>checks whether a string is arabic or not.</p>
     *
     * @param text String
     * @return boolean
     * */
    public static boolean isArabic(String text){
        text = text.replaceAll("\\s+","");

        String regExp = "(^[\u0621-\u064A]+$)";
        Pattern pattern = Pattern.compile(regExp);

        return pattern.matcher(text).matches();
    }
}

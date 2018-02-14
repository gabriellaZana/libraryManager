package com.threelittlepigs.codecool.libraryManager.Utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static Validator ourInstance = null;

    private Validator() {
    }

    public static Validator getInstance() {
        if (ourInstance == null) {
            ourInstance = new Validator();
        }
        return ourInstance;
    }

    public boolean validateRegistration(Map<String, String> regData, Map<String, String> res) {
        return regData != null && validateUsername(regData.get("name"), res) && validatePassword(regData.get("password"), res) && validateEMailAddress(regData.get("email"), res);
    }

    public boolean validateLogin(Map<String, String> loginData, Map<String, String> res) {
        return loginData != null && validateUsername(loginData.get("name"), res) && validatePassword(loginData.get("password"), res);
    }

    private boolean validateUsername(String username, Map<String, String> res) {
        Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher usernameMatcher = usernamePattern.matcher(username);
        if (!usernameMatcher.find()) {
            res.put("username", "Invalid username.");
            return false;
        } else {
            return true;
        }
    }

    private boolean validateEMailAddress(String eMailAddress, Map<String, String> res){
        Pattern eMailPattern = Pattern.compile("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)");
        Matcher eMailMatcher = eMailPattern.matcher(eMailAddress);
        if (!eMailMatcher.find()) {
            res.put("email", "Invalid e-mail address.");
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePhoneNumber(String phoneNumber, Map<String, String> res){
        Pattern numberPattern = Pattern.compile("^[?0-9]+[0-9]+$");
        Matcher numberMatcher = numberPattern.matcher(phoneNumber);
        if (!numberMatcher.find()) {
            res.put("phoneNumber", "Invalid phone number.");
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAddress(String address, Map<String, String> res){
        Pattern addressPattern = Pattern.compile("^[^_!?$ß*>;]+$");
        Matcher addressMatcher = addressPattern.matcher(address);
        if (!addressMatcher.find()) {
            res.put("address", "Invalid address.");
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePassword(String password, Map<String, String> res){
        Pattern passwordPattern = Pattern.compile("^[^_!?$ß*>;.]{5,}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (!passwordMatcher.find()) {
            res.put("password", "Invalid password.");
            return false;
        } else {
            return true;
        }
    }
}

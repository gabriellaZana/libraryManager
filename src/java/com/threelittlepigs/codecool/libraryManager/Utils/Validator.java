package com.threelittlepigs.codecool.libraryManager.Utils;

import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator {

    private Validator() {
    }

    public boolean validateRegistration(User regData, Map<String, String> res) {
        if (regData != null) {
            boolean validUserName = validateUsername(regData.getUserName(), res);
            boolean validPassword = validatePassword(regData.getPassword(), res);
            boolean validAddress = validateAddress(regData.getAddress(), res);
            boolean validFirstName = validateFirstName(regData.getFirstName(), res);
            boolean validLastName = validateLastName(regData.getLastName(), res);
            boolean validEmail = validateEMailAddress(regData.getEmail(), res);
            boolean validPhoneNumber = validatePhoneNumber(regData.getPhoneNumber(), res);
            return validAddress && validEmail && validFirstName && validLastName && validUserName && validPassword && validPhoneNumber;
         }
         return false;
    }

    public boolean validateLogin(User loginData, Map<String, String> res) {
        if (loginData != null) {
            boolean validUserName = validateUsername(loginData.getUserName(), res);
            boolean validPassword = validatePassword(loginData.getPassword(), res);
        }
        return false;
    }

    @Deprecated
    private boolean validateDate(String date, Map<String, String> res) {
        Pattern datePattern = Pattern.compile("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])");
        Matcher dateMatcher = datePattern.matcher(date);
        if (!dateMatcher.find()) {
            res.put("date", "Invalid date.");
            return false;
        } else {
            return true;
        }
    }

    private boolean validateFirstName(String firstName, Map<String, String> res) {
        Pattern firstNamePattern = Pattern.compile("^[A-Za-z]+$");
        Matcher firstNameMatcher = firstNamePattern.matcher(firstName);
        if (!firstNameMatcher.find()) {
            res.put("firstName", "Invalid first name.");
            return false;
        } else {
            return true;
        }
    }

    private boolean validateLastName(String lastName, Map<String, String> res) {
        Pattern lastNamePattern = Pattern.compile("^[A-Za-z]+$");
        Matcher lastNameMatcher = lastNamePattern.matcher(lastName);
        if (!lastNameMatcher.find()) {
            res.put("lastName", "Invalid last name.");
            return false;
        } else {
            return true;
        }
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

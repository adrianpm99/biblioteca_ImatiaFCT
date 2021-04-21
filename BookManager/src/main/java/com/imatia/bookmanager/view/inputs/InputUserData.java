package com.imatia.bookmanager.view.inputs;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUserData {
	static Scanner scan = new Scanner(System.in);

    /**
     * Input user data check and return the InputString
     * 
     * @param dataType "",id ,title ,description ,author ,editorial ,numberOfSheets
     *                 ,ISBN ,edition ,bookPublicationYear ,option
     * @return "" if the inputUserData is not correct and return the inputString if
     *         its correct
     */
    public static String checkUserInput(String dataType) {
        String data = scan.nextLine();
        Pattern pattern;
        Matcher matcher;
        switch (dataType) {
        case "id":
            pattern = Pattern.compile("^[\\d]{1,5}$");
            matcher = pattern.matcher(data);
            if (matcher.find()) {
                return data;
            }
            break;
        case "title":
            pattern = Pattern.compile("^.{0,50}$");
            matcher = pattern.matcher(data);
            if (matcher.find()) {
                return data;
            }
            break;
        case "description":
            pattern = Pattern.compile("^.{0,200}$");
            matcher = pattern.matcher(data);
            if (matcher.find()) {
                return data;
            }
            break;
        case "author":
        case "editorial":
            pattern = Pattern.compile("^[\\w\\s]{0,50}$");
            matcher = pattern.matcher(data);
            if (matcher.find()) {
                return data;
            }
            break;
        case "pageNumber":
            pattern = Pattern.compile("^[\\d]{0,5}$");
            matcher = pattern.matcher(data);
            if (matcher.find()) {
                return data;
            }
            break;
        case "ISBN":
            pattern = Pattern.compile("^[\\d]{13}$");
            matcher = pattern.matcher(data);
            if (matcher.find()) {
                return data;
            }
            break;
        case "edition":
            pattern = Pattern.compile("^[\\d]{0,3}$");
            matcher = pattern.matcher(data);
            if (matcher.find()) {
                return data;
            }
            break;
        case "bookPublicationYear":
            pattern = Pattern.compile("^[012]{1}+[\\d]{3}$|^[\\d]{2}$");
            matcher = pattern.matcher(data);
            if (matcher.find()) {
                return data;
            }
            break;
        case "option":
            pattern = Pattern.compile("^[\\d]$");
            matcher = pattern.matcher(data);
            if (matcher.find()) {
                return data;
            }
            break;
        default:
            return data;
        }
        pattern = Pattern.compile("0");
        matcher = pattern.matcher(data);
        if (matcher.find()) {
            return data;
        }
        System.out.println("\u001B[31m" + "Datos con el formato incorrecto." + "\u001B[0m");
        return "";
    }
}


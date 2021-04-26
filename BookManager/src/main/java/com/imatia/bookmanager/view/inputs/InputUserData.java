package com.imatia.bookmanager.view.inputs;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUserData {
	static Scanner scan = new Scanner(System.in);

	/**
	 * Input user data check and return the InputString
	 * 
	 * @param dataType
	 *            "",id ,title ,description ,author ,editorial ,numberOfSheets ,ISBN
	 *            ,edition ,bookPublicationYear ,option
	 * @return "" if the inputUserData is not correct and return the inputString if
	 *         its correct
	 */
	public static String checkUserInput(String dataType, String errorSentence) {
		Pattern pattern;
		Matcher matcher;
		String data;
		do {

			data = scan.nextLine();
			switch (dataType) {
			case "id":
				pattern = Pattern.compile("^[\\d]{0,5}$");
				matcher = pattern.matcher(data);
				break;


			case "title":
				pattern = Pattern.compile("^.{0,50}$");
				matcher = pattern.matcher(data);
				break;

			case "description":
				pattern = Pattern.compile("^.{0,200}$");
				matcher = pattern.matcher(data);
				break;

			case "author":
			case "editorial":
				pattern = Pattern.compile("^.{0,50}$");
				matcher = pattern.matcher(data);
				break;

			case "pageNumber":
				pattern = Pattern.compile("^[\\d]{0,5}$");
				matcher = pattern.matcher(data);
				break;

			case "ISBN":
				pattern = Pattern.compile("^[\\d]{13}$|^.{0}$");
				matcher = pattern.matcher(data);
				break;

			case "edition":
				pattern = Pattern.compile("^[\\d]{0,3}$");
				matcher = pattern.matcher(data);
				break;

			case "bookPublicationYear":
				pattern = Pattern.compile("^[012]{1}+[\\d]{3}$|^.{0}$");
				matcher = pattern.matcher(data);
				break;

			case "copyNumber":
				pattern = Pattern.compile("^[\\d]{0,3}$");
				matcher = pattern.matcher(data);
				break;

			case "option":
				pattern = Pattern.compile("^[\\d]{1}$");
				matcher = pattern.matcher(data);
				break;

			case "date":
				pattern = Pattern.compile("^(?:(?:31(-)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(-)(?:0?"
						+ "[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?"
						+ ":29(-)0?2\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468]"
						+ "[048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00"
						+ "))))$|^(?:0?[1-9]|1\\d|2[0-8])(-)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:\\d{4})$");
				matcher = pattern.matcher(data);
				break;
			case "name":
			case "surname":
				pattern = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{0,50}$");
				matcher = pattern.matcher(data);

			default:
				return data;
			}
			if (matcher.find()) {
				return data;
			}
			System.out.println("Datos con el formato incorrecto");
			if (!errorSentence.equals("")) {
				System.out.println(errorSentence);
			}
		} while (!data.equals(""));
		return data;
	}

	public static String checkUserInput(String dataType) {
		return checkUserInput(dataType, "");
	}
}

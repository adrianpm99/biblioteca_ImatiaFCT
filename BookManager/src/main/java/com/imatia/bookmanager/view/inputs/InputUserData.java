package com.imatia.bookmanager.view.inputs;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to implement the methods to check and return UserInputs
 * 
 * @author Grupo2FCTImatia
 * 
 */

public class InputUserData {

	static Scanner scan = new Scanner(System.in);

	/**
	 * Input user data check and return the InputString
	 * 
	 * @param dataType      "", id, title, description, author, editorial,
	 *                      pageNumber, ISBN ,edition, bookPublicationYear, option,
	 *                      name, surname, date, copyNumber, lendingNotes,
	 *                      copyNotes, shelving
	 * @param errorSentence Custom error sentence
	 * @return inputString
	 */
	public static String checkUserInput(String dataType, String errorSentence) {

		Pattern pattern;
		Matcher matcher;
		String data;

		do {

			// Print the prompt
			String prompt = "\rBookManager:\\> ";
			System.out.print(prompt);

			// Ask for data
			data = scan.nextLine();

			switch (dataType) {

			// 0 to 5 digit numbers not acepting 0
			case "id":
				pattern = Pattern.compile("^(?!0)\\d{0,5}$");
				matcher = pattern.matcher(data);
				break;
				
			// 0 to 200 of any caracter
			case "description":
			case "lendingNotes":
				pattern = Pattern.compile("^.{0,200}$");
				matcher = pattern.matcher(data);
				break;
				
			// 0 to 50 of any character
			case "title":
			case "author":
			case "editorial":
			case "copyNotes":
				pattern = Pattern.compile("^.{0,50}$");
				matcher = pattern.matcher(data);
				break;
				
			// 0 to 3 digit numbers not acepting 0
			case "edition":
			case "shelving":
			case "pageNumber":
				pattern = Pattern.compile("^(?!0)\\d{0,3}$");
				matcher = pattern.matcher(data);
				break;
				
			// 13 digit numbers
			case "ISBN":
				pattern = Pattern.compile("^[\\d]{13}$|^.{0}$");
				matcher = pattern.matcher(data);
				break;
				
			// Year format yyyy (supports form 0000 to 2999)
			case "bookPublicationYear":
				pattern = Pattern.compile("^[012]{1}+[\\d]{3}$|^.{0}$");
				matcher = pattern.matcher(data);
				break;
				
			// 0 to 3 digit numbers
			case "copyNumber":
				pattern = Pattern.compile("^[\\d]{0,3}$");
				matcher = pattern.matcher(data);
				break;
				
			// One digit number
			case "option":
				pattern = Pattern.compile("^[\\d]{1}$");
				matcher = pattern.matcher(data);
				break;
				
			// Date Format dd/mm/yyyy
			case "date":
				pattern = Pattern.compile("^(?:(?:31(-)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(-)(?:0?[13-9]"
						+ "|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(-)0?2\\3(?:(?:(?:1"
						+ "[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|"
						+ "[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(-)(?:(?:0?[1-9])|(?:1[0-2]))"
						+ "\\4(?:\\d{4})$");
				matcher = pattern.matcher(data);
				break;
				
			// Spanish letters (0,50)
			case "name":
			case "surname":
				pattern = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{0,50}$");
				matcher = pattern.matcher(data);
				break;
				
			// If not case return data
			default: return data;
				
			}

			// Compare Data with regex
			if (matcher.find()) {

				return data;

			}

			System.out.println("Datos con el formato incorrecto");

			if (!errorSentence.equals("")) {

				System.out.println(errorSentence);

			}

		} while (!data.equals(""));

		return data;

	}// checkUserInput()

	/**
	 * Input user data check and return the InputString
	 * 
	 * @param dataType "", id, title, description, author, editorial, pageNumber,
	 *                 ISBN ,edition, bookPublicationYear, option, name, surname,
	 *                 date, copyNumber, lendingNotes, copyNotes, shelving
	 * @return inputString
	 */

	public static String checkUserInput(String dataType) {

		return checkUserInput(dataType, "");

	}// checkUserInput()

}// class InputUserData

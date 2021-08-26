package com.bookbuddy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AuthorUtil {
	public static final String NOT_FOUND_MESSAGE = "I haven't found the specified author. Please try again.";
	public static final List<String> listOfAuthorsMessages = new ArrayList<>();

	public static final List<String> listOfAuthorsSelectionMessages = new ArrayList<>();
	static {
		listOfAuthorsMessages.add("Here is the list of authors: ");
		listOfAuthorsMessages.add("Sure, here is the list: ");
		listOfAuthorsMessages.add("I found the following authors: ");
		listOfAuthorsSelectionMessages.add("Which one would you like to select?");
		listOfAuthorsSelectionMessages.add("Please choose one of them to continue.");
		listOfAuthorsSelectionMessages.add("I can provide list of books if you choose an author.");
	}

	public static String getRandomListOfAuthorsMessage() {
		Integer listOfAuthorsValue = new Random().nextInt(listOfAuthorsMessages.size());

		return listOfAuthorsMessages.get(listOfAuthorsValue);
	}

	public static String getRandomAuthorSelectionMessage() {
		Integer listOfAuthorsSelectionValue = new Random().nextInt(listOfAuthorsSelectionMessages.size());

		return listOfAuthorsSelectionMessages.get(listOfAuthorsSelectionValue);
	}
}
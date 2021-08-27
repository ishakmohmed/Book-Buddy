package com.bookbuddy.service;

import java.util.List;
import java.util.StringJoiner;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookbuddy.domain.Author;
import com.bookbuddy.domain.Book;
import com.bookbuddy.repository.AuthorRepository;
import com.bookbuddy.repository.BookRepository;
import com.bookbuddy.util.AuthorUtil;
import com.bookbuddy.util.BookUtil;
import com.bookbuddy.util.IntentUtil;
import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;

@Service
@Transactional
public class BookService extends DialogflowApp {
	private Logger logger = LoggerFactory.getLogger(BookService.class);

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	@ForIntent(IntentUtil.LIST_BOOKS_BY_AUTHOR)
	public ActionResponse findAllByAuthor(ActionRequest request) {
		logger.info("Executing intent - " + IntentUtil.LIST_BOOKS_BY_AUTHOR);

		StringBuilder response = new StringBuilder();
		String givenName = request.getParameter("given-name").toString();
		String lastName = request.getParameter("last-name").toString();
		Author author = authorRepository.findByGivenNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(givenName, lastName);

		if (author != null) {
			List<Book> booksList = bookRepository.findByAuthor(author);

			response.append(BookUtil.getRandomListOfBooksMessage());

			StringJoiner sj = new StringJoiner(", ");
			
			booksList.forEach(book -> sj.add(book.toString()));
			response.append(sj);
			response.append(". ");
			response.append(BookUtil.getRandomBookSelectionMessage());
		} else response.append(AuthorUtil.NOT_FOUND_MESSAGE);
		
		ResponseBuilder responseBuilder = getResponseBuilder(request).add(response.toString());
		ActionResponse actionResponse = responseBuilder.build();
		
		logger.info(actionResponse.toJson());

		return actionResponse;
	}

	@ForIntent(IntentUtil.LIST_BOOKS_BY_GENRE)
	public ActionResponse findAllByGenre(ActionRequest request) {
		logger.info("Executing intent - " + IntentUtil.LIST_BOOKS_BY_GENRE);

		StringBuilder response = new StringBuilder();
		String genre = request.getParameter("Genre").toString();
		List<Book> bookList = bookRepository.findByGenreContainingIgnoreCase(genre);

		if (bookList != null && bookList.size() > 0) {
			response = new StringBuilder(BookUtil.getRandomListOfBooksMessage());

			StringJoiner sj = new StringJoiner(", ");
			
			bookList.forEach(book -> sj.add(book.toString()));
			response.append(sj);
			response.append(". ");
			response.append(BookUtil.getRandomBookSelectionMessage());
		} else response.append(BookUtil.BOOKS_NOT_FOUND_MESSAGE);
		
		ResponseBuilder responseBuilder = getResponseBuilder(request).add(response.toString());
		ActionResponse actionResponse = responseBuilder.build();
		
		logger.info(actionResponse.toJson());

		return actionResponse;
	}
	
	@ForIntent(IntentUtil.GET_BOOK_DETAILS_BY_AUTHOR)
	public ActionResponse getBookDetailsByAuthor(ActionRequest request) {
		logger.info("Executing intent - " + IntentUtil.GET_BOOK_DETAILS_BY_AUTHOR);

		return getBookDetails(request);
	}

	@ForIntent(IntentUtil.GET_BOOK_DETAILS_BY_GENRE)
	public ActionResponse getBookDetailsByGenre(ActionRequest request) {
		logger.info("Executing intent - " + IntentUtil.GET_BOOK_DETAILS_BY_GENRE);

		return getBookDetails(request);
	}

	public ActionResponse getBookDetails(ActionRequest request) {
		StringBuilder response = new StringBuilder();
		ResponseBuilder responseBuilder = null;
		String bookTitle = request.getParameter("bookTitle").toString();
		Book book = bookRepository.findByTitleContainingIgnoreCase(bookTitle);

		if (book != null) {
			response.append(BookUtil.getRandomBookDetailsMessage());
			response.append(book.getTitle());
			response.append(" was published in ");
			response.append(book.getPublicationYear());
			response.append(" and can be categorized as a ");
			response.append(book.getGenre());
			response.append(". Here is a short summary. ");
			response.append(book.getSummary());
			responseBuilder = getResponseBuilder(request).add(response.toString()).endConversation();
		} else {
			response.append(BookUtil.NOT_FOUND_MESSAGE);
			responseBuilder = getResponseBuilder(request).add(response.toString());
		}

		ActionResponse actionResponse = responseBuilder.build();
		
		logger.info(actionResponse.toJson());

		return actionResponse;
	}
}
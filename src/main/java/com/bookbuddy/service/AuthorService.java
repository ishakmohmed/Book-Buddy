package com.bookbuddy.service;

import java.util.List;
import java.util.StringJoiner;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookbuddy.domain.Author;
import com.bookbuddy.repository.AuthorRepository;
import com.bookbuddy.util.AuthorUtil;
import com.bookbuddy.util.IntentUtil;
import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;

@Service
@Transactional
public class AuthorService extends DialogflowApp {
	private Logger logger = LoggerFactory.getLogger(AuthorService.class);

	@Autowired
	private AuthorRepository authorRepository;

	@ForIntent(IntentUtil.LIST_AUTHORS)
	public ActionResponse findAll(ActionRequest request) {
		logger.info("Executing intent - " + IntentUtil.LIST_AUTHORS);

		List<Author> authorsList = authorRepository.findAll();
		StringBuilder response = new StringBuilder(AuthorUtil.getRandomListOfAuthorsMessage());
		StringJoiner sj = new StringJoiner(", ");
		
		authorsList.forEach(author -> sj.add(author.toString()));
		response.append(sj);
		response.append(". ");
		response.append(AuthorUtil.getRandomAuthorSelectionMessage());

		ResponseBuilder responseBuilder = getResponseBuilder(request).add(response.toString());
		
		ActionResponse actionResponse = responseBuilder.build();
		logger.info(actionResponse.toJson());

		return actionResponse;
	}
}
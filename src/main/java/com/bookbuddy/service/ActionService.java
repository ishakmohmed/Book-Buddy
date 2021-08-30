package com.bookbuddy.service;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.bookbuddy.util.IntentUtil;
import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;

@Service
public class ActionService extends DialogflowApp {
	private Logger logger = LoggerFactory.getLogger(ActionService.class);

	@ForIntent(IntentUtil.LIST_ACTIONS)
	public ActionResponse listActions(ActionRequest request) {
		logger.info("Executing intent - " + IntentUtil.LIST_ACTIONS);

		StringBuilder response = new StringBuilder();
		
		response.append("You can ask me the authors I know (e.g. \"List all the authors\") and then you can know more about the books they wrote.");
		response.append(" Ask me now! :) ");

		ResponseBuilder responseBuilder = getResponseBuilder(request).add(response.toString());
		ActionResponse actionResponse = responseBuilder.build();
		
		return actionResponse;
	}

	public String getIntentName(String body) throws Exception {
		JSONObject bodyJsonObject = new JSONObject(body);
		JSONObject queryResultObject = bodyJsonObject.getJSONObject("queryResult");
		JSONObject intentObject = queryResultObject.getJSONObject("intent");

		return intentObject.get("displayName").toString();
	}
}

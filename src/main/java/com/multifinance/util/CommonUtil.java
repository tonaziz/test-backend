package com.multifinance.util;

import org.json.JSONArray;
import org.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtil {
	public static String toTitleCase(String text) {
		if (text == null || text.isEmpty()) {
			return text;
		}
		StringBuilder converted = new StringBuilder();
		boolean convertNext = true;
		for (char ch : text.toCharArray()) {
			if (Character.isSpaceChar(ch)) {
				convertNext = true;
			} else if (convertNext) {
				ch = Character.toTitleCase(ch);
				convertNext = false;
			} else {
				ch = Character.toLowerCase(ch);
			}
			converted.append(ch);
		}
		return converted.toString().trim();
	}

	public static String modelToString(Object model) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(model).toString();
	}

	public static String removeBracket(String text) {
		StringBuilder remove = new StringBuilder(text);
		remove.setCharAt(0, ' ');
		remove.setCharAt((remove.length() - 1), ' ');
		return remove.toString();
	}

	public static String createBracket(String text) {
		StringBuilder create = new StringBuilder(text);
		create.setCharAt(0, '{');
		create.setCharAt((create.length() - 1), '}');
		return create.toString();
	}

	public static String updateResponse(String json, String response) {
		JSONObject testObject = new JSONObject(json);
		testObject.put("response", response);
		return testObject.toString();
	}

	public static String getResponse(String json) {
		JSONObject testObject = new JSONObject(json);
		return testObject.getString("response").toString();
	}

	public static String getResponseList(String json, String key) {
		StringBuilder create = new StringBuilder();
		JSONObject jsonObject = new JSONObject(json);
		JSONArray jsonArray = jsonObject.getJSONArray(key);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject anotherJsonObject = jsonArray.getJSONObject(i);
			create.append(anotherJsonObject.get("response"));
		}
		return create.toString();
	}
}
package com.ex.triple.reviewvo;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BaseObject {
	public JsonObject getConvertJsonObj(String body) {
		JsonElement root = JsonParser.parseString(body);
		JsonObject obj = root.getAsJsonObject();
		return obj;
	}
}

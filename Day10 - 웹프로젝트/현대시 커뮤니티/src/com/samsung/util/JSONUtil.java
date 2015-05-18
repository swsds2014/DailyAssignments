package com.samsung.util;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.samsung.dao.BoardDAO;
import com.samsung.vo.ReplyVO;

public class JSONUtil {

	public static JsonArray listToJsonArray(ArrayList<ReplyVO> replyList, BoardDAO dao){
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(replyList,
				new TypeToken<ArrayList<ReplyVO>>() {
				}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		return jsonArray;
	}
}

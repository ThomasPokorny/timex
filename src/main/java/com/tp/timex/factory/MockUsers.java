package com.tp.timex.factory;

public class MockUsers {

//	public static final ObjectId USER_JENS = new ObjectId("6015ed148e7bc819daa8a607");
//	public static final ObjectId USER_TOM = new ObjectId("6015ed658e7bc819daa8a608");
	
	public static final String TOKEN_JENS = "j7BMJR93TfBBbSyGbHqp3BStLPvzeSGpP8Lp";
	public static final String TOKEN_TOM = "KVZYNktgJJJ6xGSegmyeShVQU6zrkFPFtrvR";

	public static String getUser(String token) {
		token = token.replace("Bearer ", "");
		
		if(token.equals(TOKEN_JENS)) {
			return "6015ed148e7bc819daa8a607";
		} else 
		if(token.equals(TOKEN_TOM)) {
			return "6015ed658e7bc819daa8a608";
		}
		
		return null;
	}
}

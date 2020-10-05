package utils;

import java.util.LinkedHashMap;
import java.util.Map;

import pojo.CreateUser;

public class Payload {

	public Map<String, Object> addBookPayLoad()
	{
		Map<String, Object> jsonMap = new LinkedHashMap<String, Object>();
		jsonMap.put("name", "Learn selenium Automation with Java");
		jsonMap.put("isbn", "bcd");
		jsonMap.put("aisle", "230");
		jsonMap.put("author", "ravi");
		return jsonMap;
	}
	
	public CreateUser createUserPayload()
	{
		CreateUser cu=new CreateUser();
		cu.setJob("trainer");
		cu.setName("ravish");
		return cu;
	}
	
	
	
	
}

package org.bs.ws.messager.database;

import java.util.HashMap;
import java.util.Map;

import org.bs.ws.messager.model.Message;
import org.bs.ws.messager.model.Profile;


public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	
}

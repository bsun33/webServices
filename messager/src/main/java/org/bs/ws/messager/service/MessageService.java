package org.bs.ws.messager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bs.ws.messager.database.DatabaseClass;
import org.bs.ws.messager.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "hello tsuyo", "tsuyo"));
		messages.put(2L, new Message(2, "hello tsuyo", "koichi"));
	}
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(Long id) {
		return messages.remove(id);
	}
	
}

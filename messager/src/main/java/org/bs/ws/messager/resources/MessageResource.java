package org.bs.ws.messager.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bs.ws.messager.model.Message;
import org.bs.ws.messager.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	//http://localhost:8080/messager/webapi/messages
	//http://localhost:8080/messager/webapi/messages?year=2018
	
	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
			@QueryParam("start") int start, @QueryParam("size") int size) {
		if(year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		if(start >= 0 && size >= 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}
	
	//http://localhost:8080/messager/webapi/messages/1
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long id) {
		
		return messageService.getMessage(id);
	}
	
	@POST
	public Message addMessage(Message m) {
		return messageService.addMessage(m);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") Long id, Message m) {
		m.setId(id);
		return messageService.updateMessage(m);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") Long id) {
		messageService.removeMessage(id);
	}
	
	
	
}

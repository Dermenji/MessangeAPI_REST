package com.dermenji.resources;

import com.dermenji.model.Message;
import com.dermenji.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResourse {

    private MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId){
        return messageService.getMessage(messageId);
    }

    @POST
    public Message addMessage (Message message){
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long Id, Message message){
        message.setId(Id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void messageDelete(@PathParam("messageId") long Id){
        messageService.removeMessage(Id);
    }
}


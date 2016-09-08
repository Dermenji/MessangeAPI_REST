package com.dermenji.service;

import com.dermenji.database.DatabaseClass;
import com.dermenji.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fns02 on 9/7/2016.
 */
public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Message> getAllMessages(){
        return new ArrayList<Message>(messages.values());
    }

    public Message getMessage(long id){
        return messages.get(id);
    }

    public Message addMessage(Message message){
        message.setId(messages.size()+1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage (Message message){
        if (message.getId() <= 0){
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }

}

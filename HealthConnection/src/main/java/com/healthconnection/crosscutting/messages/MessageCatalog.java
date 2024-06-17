package com.healthconnection.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import com.healthconnection.crosscutting.exception.custom.CrosscuttingHealthException;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.messages.enums.MessageCategory;
import com.healthconnection.crosscutting.messages.enums.MessageCode;
import com.healthconnection.crosscutting.messages.enums.MessageType;

public class MessageCatalog {
    
    private static final Map<MessageCode, Message> MENSAJES = new HashMap<MessageCode, Message>();
    
    static  {
    	uploadMessages();
    }

    private MessageCatalog() {
        super();
    }
    
    public static void uploadMessages() {
    	
    	addMessage(Message.crear(MessageCode.M0000001, MessageType.TECHNICAL, MessageCategory.ERROR, 
    		    "It is not possible to obtain a message with an empty or null code. The process cannot continue..."));

    		addMessage(Message.crear(MessageCode.M0000002, MessageType.TECHNICAL, MessageCategory.ERROR, 
    		    "There is no message with the indicated code. The process cannot continue..."));

    		addMessage(Message.crear(MessageCode.M0000003, MessageType.USER, MessageCategory.ERROR,
    		    "An unexpected problem occurred while trying to carry out the desired operation. Please try again and if the problem persists, contact the application administrator."));

    		addMessage(Message.crear(MessageCode.M0000004, MessageType.TECHNICAL, MessageCategory.ERROR,
    		    "The message code to be created was not received. The process cannot continue."));

    		addMessage(Message.crear(MessageCode.M0000005, MessageType.USER, MessageCategory.ERROR,
    		    "A client with the same identifier already exists."));

    		addMessage(Message.crear(MessageCode.M0000006, MessageType.USER, MessageCategory.ERROR,
    		    "A client with the same identification number already exists."));

    		addMessage(Message.crear(MessageCode.M0000007, MessageType.USER, MessageCategory.ERROR,
    		    "A client with that email already exists."));

    		addMessage(Message.crear(MessageCode.M0000008, MessageType.USER, MessageCategory.ERROR,
    		    "An appointment with the same identifier already exists. Please try again."));

    		addMessage(Message.crear(MessageCode.M0000009, MessageType.USER, MessageCategory.ERROR,
    		    "An appointment with the same start date, end date, and the same room already exists."));

    		addMessage(Message.crear(MessageCode.M0000010, MessageType.USER, MessageCategory.ERROR,
    		    "An appointment with the same start date, end date, and the same healthcare professional already exists."));

    		addMessage(Message.crear(MessageCode.M0000011, MessageType.USER, MessageCategory.ERROR,
    		    "The start date cannot be later than the end date. Please try again."));

    		addMessage(Message.crear(MessageCode.M0000012, MessageType.USER, MessageCategory.CONFIRMATION,
    		    "The appointment has been successfully registered."));

    		addMessage(Message.crear(MessageCode.M0000013, MessageType.USER, MessageCategory.ERROR,
    		    "Incorrect username or password."));

    		addMessage(Message.crear(MessageCode.M0000014, MessageType.USER, MessageCategory.ERROR,
    		    "The start date is not valid because it is earlier than the current date. Please try again."));

    		addMessage(Message.crear(MessageCode.M0000015, MessageType.USER, MessageCategory.ERROR,
    		    "The request body you are sending is empty. Please try again and ensure all required fields are filled."));

    		addMessage(Message.crear(MessageCode.M0000016, MessageType.TECHNICAL, MessageCategory.ERROR,
    		    "The request body being sent is empty. Ensure all required fields are filled."));

    		addMessage(Message.crear(MessageCode.M0000017, MessageType.TECHNICAL, MessageCategory.ERROR,
    		    "An unexpected error occurred."));
    	
    }
    
    private static final void addMessage(final Message message) {
		MENSAJES.put(message.getCode(), message);
	}
    
    private static final Message getMessage(final MessageCode code) {
		if(ObjectHelper.isNull(code)) {
			var messageUser = getContentMessage(MessageCode.M0000003);
			var messageTechnical = getContentMessage(MessageCode.M0000001);
			throw new CrosscuttingHealthException(messageUser,messageTechnical);
		}
		
		if(!MENSAJES.containsKey(code)) {
			var messageUser = getContentMessage(MessageCode.M0000003);
			var messageTechnical = getContentMessage(MessageCode.M0000002);
			throw new CrosscuttingHealthException(messageTechnical,messageUser);
		}
		
		return MENSAJES.get(code);
	}
	
	public static final String getContentMessage( final MessageCode code) {
		return getMessage(code).getContained();
	}

}

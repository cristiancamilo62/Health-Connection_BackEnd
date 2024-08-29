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

    		addMessage(Message.crear(MessageCode.M0000017, MessageType.USER, MessageCategory.ERROR,
    		    "An unexpected error occurred."));

    		addMessage(Message.crear(MessageCode.M0000018, MessageType.USER, MessageCategory.ERROR,
    		    "The patient ID is the default value."));

    		addMessage(Message.crear(MessageCode.M0000019, MessageType.USER, MessageCategory.ERROR,
    		    "The patient ID must not be null."));

    		addMessage(Message.crear(MessageCode.M0000020, MessageType.USER, MessageCategory.ERROR,
    		    "It is not possible to perform the operation with a null patient."));

    		addMessage(Message.crear(MessageCode.M0000021, MessageType.USER, MessageCategory.ERROR,
    		    "The first name cannot be empty. Please provide a valid first name to proceed."));

    		addMessage(Message.crear(MessageCode.M0000022, MessageType.USER, MessageCategory.ERROR,
    		    "The last name cannot be empty. Please provide a valid last name to proceed."));

    		addMessage(Message.crear(MessageCode.M0000023, MessageType.USER, MessageCategory.ERROR,
    		    "The maximum length of the first name is 12 characters"));

    		addMessage(Message.crear(MessageCode.M0000024, MessageType.USER, MessageCategory.ERROR,
    		    "The maximum length of the second name is 12 characters"));

    		addMessage(Message.crear(MessageCode.M0000025, MessageType.USER, MessageCategory.ERROR,
    		    "The maximum length of the first surname is 12 characters"));

    		addMessage(Message.crear(MessageCode.M0000026, MessageType.USER, MessageCategory.ERROR,
    		    "The maximum length of the second surname is 12 characters"));

    		addMessage(Message.crear(MessageCode.M0000027, MessageType.USER, MessageCategory.ERROR,
    		    "The first name must contain only letters or digits"));

    		addMessage(Message.crear(MessageCode.M0000028, MessageType.USER, MessageCategory.ERROR,
    		    "The second name must contain only letters or digits"));

    		addMessage(Message.crear(MessageCode.M0000029, MessageType.USER, MessageCategory.ERROR,
    		    "The first surname must contain only letters or digits"));

    		addMessage(Message.crear(MessageCode.M0000030, MessageType.USER, MessageCategory.ERROR,
    		    "The second surname must contain only letters or digits"));

    		addMessage(Message.crear(MessageCode.M0000031, MessageType.USER, MessageCategory.ERROR,
    		    "The identification number cannot be empty"));

    		addMessage(Message.crear(MessageCode.M0000032, MessageType.USER, MessageCategory.ERROR,
    		    "The identification number must have a length of 10"));

    		addMessage(Message.crear(MessageCode.M0000033, MessageType.USER, MessageCategory.ERROR,
    		    "The identification number must contain only digits"));

    		addMessage(Message.crear(MessageCode.M0000034, MessageType.USER, MessageCategory.ERROR,
    		    "The email address cannot be empty"));

    		addMessage(Message.crear(MessageCode.M0000035, MessageType.USER, MessageCategory.ERROR,
    		    "The email address must have a length between 11 and 40 characters"));

    		addMessage(Message.crear(MessageCode.M0000036, MessageType.USER, MessageCategory.ERROR,
    		    "The email address must be in the format name@domain.com"));

    		addMessage(Message.crear(MessageCode.M0000037, MessageType.USER, MessageCategory.ERROR,
    		    "The phone number must have a length of 10"));

    		addMessage(Message.crear(MessageCode.M0000038, MessageType.USER, MessageCategory.ERROR,
    		    "The phone number must contain only digits [0-9]"));

    		addMessage(Message.crear(MessageCode.M0000039, MessageType.USER, MessageCategory.ERROR,
    		    "The password cannot be empty"));

    		addMessage(Message.crear(MessageCode.M0000040, MessageType.USER, MessageCategory.ERROR,
    		    "The password must have a length between 8 and 20 characters"));

    		addMessage(Message.crear(MessageCode.M0000041, MessageType.USER, MessageCategory.ERROR,
    		    "The password must contain at least one of ['0-9', 'A-Z', 'a-z', '@$!%*?&']"));

    		addMessage(Message.crear(MessageCode.M0000042, MessageType.USER, MessageCategory.ERROR,
    		    "The date of birth cannot be empty"));

    		addMessage(Message.crear(MessageCode.M0000043, MessageType.USER, MessageCategory.ERROR,
    		    "The date of birth must be in the format 'YYYY-MM-DD'"));

    		addMessage(Message.crear(MessageCode.M0000044, MessageType.USER, MessageCategory.ERROR,
    		    "The patient is not registered. Verify the ID."));

    		addMessage(Message.crear(MessageCode.M0000045, MessageType.USER, MessageCategory.ERROR,
    		    "The patient is not registered. Verify the data."));
    		
    		addMessage(Message.crear(MessageCode.M0000046, MessageType.USER, MessageCategory.ERROR,
        		    "El  tipo de identificacion esta vacio"));
    		
    		addMessage(Message.crear(MessageCode.M0000047, MessageType.USER, MessageCategory.ERROR,
        		    "El id del tipo de identificacion no puede ser nulo"));
    		
    		addMessage(Message.crear(MessageCode.M0000048, MessageType.USER, MessageCategory.ERROR,
        		    "El tipo de identificacion no puede ser nulo"));
    		
    		addMessage(Message.crear(MessageCode.M0000049, MessageType.USER, MessageCategory.ERROR,
        		    "El regimen de afiliación no puede estar vacio"));
    		
    		addMessage(Message.crear(MessageCode.M0000050, MessageType.USER, MessageCategory.ERROR,
        		    "El id regimen de afiliación no puede ser nulo"));
    		
    		addMessage(Message.crear(MessageCode.M0000051, MessageType.USER, MessageCategory.ERROR,
        		    "La eps no puede estar vacio"));
    		
    		addMessage(Message.crear(MessageCode.M0000052, MessageType.USER, MessageCategory.ERROR,
        		    "El id de la eps no puede ser nulo"));
    		
    		addMessage(Message.crear(MessageCode.M0000053, MessageType.USER, MessageCategory.ERROR,
        		    "El id de la cita no puede ser el valor por defecto"));
    		
    		addMessage(Message.crear(MessageCode.M0000054, MessageType.USER, MessageCategory.ERROR,
        		    "El id de la cita no puede  estar vacio"));
    		
    		addMessage(Message.crear(MessageCode.M0000055, MessageType.USER, MessageCategory.ERROR,
        		    "El id de la cita no puede ser nulo"));
    		
    		addMessage(Message.crear(MessageCode.M0000056, MessageType.USER, MessageCategory.ERROR,
        		    "La cita no puede ser nula"));
    		
    		addMessage(Message.crear(MessageCode.M0000057, MessageType.USER, MessageCategory.ERROR,
        		    "La fecha de inicio no puede estar vacia"));
    		
    		addMessage(Message.crear(MessageCode.M0000058, MessageType.USER, MessageCategory.ERROR,
        		    "La fecha de inicio no tiene el formato valido 'dd/mm/aaaa hh:mm p. m. ó a. m."));
    		
    		addMessage(Message.crear(MessageCode.M0000059, MessageType.USER, MessageCategory.ERROR,
        		    "A Health Professional with the same identifier already exists."));

        	addMessage(Message.crear(MessageCode.M0000060, MessageType.USER, MessageCategory.ERROR,
        		    "A Health Professional with the same identification number already exists."));

        	addMessage(Message.crear(MessageCode.M0000061, MessageType.USER, MessageCategory.ERROR,
        		    "A Health Professional with that email already exists."));
        	
        	addMessage(Message.crear(MessageCode.M0000062, MessageType.USER, MessageCategory.ERROR,
        		    "The Health Professional ID is the default value."));
        	
        	addMessage(Message.crear(MessageCode.M0000063, MessageType.USER, MessageCategory.ERROR,
        		    "The Health Professional ID must not be null."));
        	
        	addMessage(Message.crear(MessageCode.M0000064, MessageType.USER, MessageCategory.ERROR,
        		    "It is not possible to perform the operation with a null health professional."));
        	
        	addMessage(Message.crear(MessageCode.M0000065, MessageType.USER, MessageCategory.ERROR,
        		    "No se encontro ningun role con esa teminacion"));
        		
        		

			
	
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

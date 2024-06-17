package com.healthconnection.crosscutting.messages;

import com.healthconnection.crosscutting.exception.custom.CrosscuttingHealthException;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.messages.enums.MessageCategory;
import com.healthconnection.crosscutting.messages.enums.MessageCode;
import com.healthconnection.crosscutting.messages.enums.MessageType;

public class Message {

	private MessageCode code;
	private MessageType type;
	private MessageCategory category;
	private String contained;
	
	private Message(final MessageCode code, final MessageType type, final MessageCategory category,
			final String contained) {
		setCode(code);
		setType(type);
		setCategory(category);
		setContained(contained);
	}
	
	public static final Message crear(final MessageCode code, final MessageType type, final MessageCategory category,
			final String contained) {
		return new Message(code, type, category, contained);
	}

	private final void setCode(final MessageCode code) {
		if(ObjectHelper.isNull(code)) {
			var messageUser = MessageCatalog.getContentMessage(MessageCode.M0000003);
			var messageTechnical = MessageCatalog.getContentMessage(MessageCode.M0000004);
			throw new CrosscuttingHealthException(messageTechnical,messageUser);
			
		}
		this.code = code;
	}

	private final void setType(final MessageType type) {
		this.type = ObjectHelper.getDefault(type, MessageType.USER);
	}

	private final void setCategory(final MessageCategory category) {
		this.category = ObjectHelper.getDefault(category, MessageCategory.ERROR);
	}

	private final void setContained(final String contained) {
		this.contained = TextHelper.applyTrim(contained);
	}

	public final MessageCode getCode() {
		return code;
	}

	public final MessageType getType() {
		return type;
	}

	public final MessageCategory getCategory() {
		return category;
	}

	public final String getContained() {
		return contained;
	}
	
	
	
	
	
}

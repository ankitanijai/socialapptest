package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.TextMessage;
import com.example.demo.enums.TextStatus;
import com.example.demo.repository.TextMessageRepository;

@Service
public class TextMessageServiceImpl implements ITextMessageService {
	
	@Autowired
	private TextMessageRepository textMessageRepository;
	
	@Override
	public TextMessage postMessage(TextMessage textMessage) {
		
		return textMessageRepository.save(textMessage);
	}

	@Override
	public TextMessage editMessage(TextMessage textMessage) throws Exception {
		if(textMessage.getId()==null) {
			throw new Exception("Id is required to update");
		}
		return textMessageRepository.save(textMessage);
	}

	@Override
	public TextMessage deleteMessage(String msgId) {
		TextMessage textmessage=new TextMessage();
		textmessage=textMessageRepository.findOne(msgId);
		if(textmessage!=null) {
			if(textmessage.getStatus()!=null) {
				
			textmessage.setStatus(textmessage.getStatus().INACTIVE);
			}
		}
		return textMessageRepository.save(textmessage);
	}
	

	@Override
	public List<TextMessage> getAllMessages() {
		
		return textMessageRepository.findAll().stream().filter(a-> a.getStatus()==TextStatus.ACTIVE).collect(Collectors.toList());
	}

	



}

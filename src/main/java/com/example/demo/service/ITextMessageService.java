package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.TextMessage;

public interface ITextMessageService {

	TextMessage postMessage(TextMessage textMessage);

	TextMessage editMessage(TextMessage textMessage) throws Exception;

	TextMessage deleteMessage(String msgId);

    List<TextMessage> getAllMessages();

	

}

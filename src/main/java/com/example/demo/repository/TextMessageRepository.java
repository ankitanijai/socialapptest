package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.domain.TextMessage;

public interface TextMessageRepository  extends MongoRepository<TextMessage, String>{

	TextMessage findOne(String msgId);

}

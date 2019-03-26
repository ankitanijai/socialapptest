package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.TextMessage;
import com.example.demo.service.ITextMessageService;

@RestController
public class TextMessageController {
	private static final Logger logger=LoggerFactory.getLogger(TextMessageController.class);
	
	@Autowired
	private ITextMessageService textMessageService;
	
	@PostMapping(value="/api/text",consumes="application/json")
	public ResponseEntity<TextMessage>postMessage(@RequestBody TextMessage textMessage){
		logger.debug("in textmessage controller",textMessage);
		TextMessage message=textMessageService.postMessage(textMessage);
		if(message!= null) {
			return new ResponseEntity<TextMessage>(message,HttpStatus.OK);
		}
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value="/api/text/edit",consumes="application/json")
	public ResponseEntity<TextMessage> editMessage(@RequestBody TextMessage textMessage) throws Exception{
		TextMessage editMessage=textMessageService.editMessage(textMessage);
		if(editMessage!=null) {
			return new ResponseEntity<TextMessage>(editMessage,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value="/api/text/delete/{msgId}")
	public ResponseEntity<TextMessage> deleteMessage(@PathVariable(name="msgId")String msgId){
		TextMessage deleteMessages=textMessageService.deleteMessage(msgId);
		if(deleteMessages!=null) {
			return new ResponseEntity<TextMessage>(deleteMessages,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping(value="/api/text")
	public ResponseEntity<List<TextMessage>> getTextMessages(){
		List<TextMessage> diplayMessages=textMessageService.getAllMessages();
		if(diplayMessages!=null) {
			return new ResponseEntity<List<TextMessage>>(diplayMessages,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

}

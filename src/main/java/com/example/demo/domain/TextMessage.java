package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.enums.TextStatus;

import lombok.Data;

@Data
@Document(collection="postMessage")
public class TextMessage {
	private static final long serialVersionUID = 1L;
	
	private String message;
	private TextStatus status;
	@Id
	private String id;
}

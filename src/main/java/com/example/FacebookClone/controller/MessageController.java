package com.example.FacebookClone.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.FacebookClone.domain.Message;
import com.example.FacebookClone.exception.NotFoundException;
import com.example.FacebookClone.repo.MessageRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageRepo messageRepo;
    
    @Autowired
    public MessageController(MessageRepo messageRepo) {
    	this.messageRepo = messageRepo;
    }

    @GetMapping
    public List<Message> list() {
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    

    @PostMapping
    public Message create(@RequestBody Message message) {
        return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public Message update(
    		@PathVariable("id") Message messageFromDb, 
    		@RequestBody Message message
    		) {
        BeanUtils.copyProperties(message, messageFromDb, "id");
        
        return messageRepo.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messageRepo.delete(message);
    }
}














































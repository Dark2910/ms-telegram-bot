package com.eespindola.telegram.controller;

import com.eespindola.telegram.model.MessageRequest;
import com.eespindola.telegram.model.dto.Result;
import com.eespindola.telegram.service.BotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telegram/bot")
public class BotController {

  private final BotService botService;

  @Autowired
  BotController(
          BotService service
  ){
    this.botService = service;
  }

  @PostMapping("/send-message")
  public ResponseEntity<Result<Void>> sendMessageController(
          @Valid @RequestBody MessageRequest request
  ){
    Result<Void> result = botService.sendMessage(request);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}

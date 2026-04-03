package com.eespindola.telegram.bot.controller;

import com.eespindola.telegram.bot.model.MessageRequest;
import com.eespindola.telegram.bot.model.dto.Result;
import com.eespindola.telegram.bot.service.BotService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  private static final Logger LOG = LoggerFactory.getLogger(BotController.class);

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
    LOG.info("Procesando mensaje para el usuario");
    Result<Void> result = botService.sendMessage(request);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}

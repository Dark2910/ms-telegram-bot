package com.eespindola.telegram.service.impl;

import com.eespindola.telegram.client.TelegramClient;
import com.eespindola.telegram.configuration.TelegramConfig;
import com.eespindola.telegram.model.MessageRequest;
import com.eespindola.telegram.model.dto.Result;
import com.eespindola.telegram.service.BotService;
import com.eespindola.telegram.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BotServiceImpl implements BotService {

  private final TelegramConfig telegram;
  private final TelegramClient telegramClient;

  @Autowired
  BotServiceImpl(
          TelegramClient client,
          TelegramConfig config
  ){
    this.telegramClient = client;
    this.telegram = config;
  }

  @Override
  public Result<Void> sendMessage(MessageRequest request) {

    Map<String, Object> map = new HashMap<>();
    map.put("chat_id", telegram.getChatId());
    map.put("text", request.getMessage());

    telegramClient.sendMessage(telegram.getToken(), map);

    return Result.<Void>builder()
            .success(true)
            .message(Constantes.MESSAGE_OK)
            .build();
  }

}

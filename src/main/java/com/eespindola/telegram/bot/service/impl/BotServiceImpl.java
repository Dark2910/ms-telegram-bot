package com.eespindola.telegram.bot.service.impl;

import com.eespindola.telegram.bot.client.TelegramClient;
import com.eespindola.telegram.bot.configuration.TelegramConfig;
import com.eespindola.telegram.bot.model.MessageRequest;
import com.eespindola.telegram.bot.model.dto.Result;
import com.eespindola.telegram.bot.service.BotService;
import com.eespindola.telegram.bot.util.ResultFactory;
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

    return ResultFactory.success("Mensaje enviado.");
  }

}

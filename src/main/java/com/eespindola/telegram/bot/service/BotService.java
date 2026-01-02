package com.eespindola.telegram.bot.service;

import com.eespindola.telegram.bot.model.MessageRequest;
import com.eespindola.telegram.bot.model.dto.Result;

public interface BotService {

  Result<Void> sendMessage(MessageRequest request);

}

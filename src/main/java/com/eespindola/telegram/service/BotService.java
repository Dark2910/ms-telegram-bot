package com.eespindola.telegram.service;

import com.eespindola.telegram.model.MessageRequest;
import com.eespindola.telegram.model.dto.Result;

public interface BotService {

  Result<Void> sendMessage(MessageRequest request);

}

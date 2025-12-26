package com.eespindola.telegram.client;

import com.eespindola.telegram.util.Constantes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(
        name = "telegramClient",
        url = "${telegram.basePath}"
)
public interface TelegramClient {

  @PostMapping(Constantes.ENDPOINT_SEND_MESSAGE)
  void sendMessage(
          @PathVariable String token,
          @RequestBody Map<String, Object> map
  );

}

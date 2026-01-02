package com.eespindola.telegram.bot.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "telegram")
public class TelegramConfig {

  private String token;
  private String chatId;
  private String basePath;

}

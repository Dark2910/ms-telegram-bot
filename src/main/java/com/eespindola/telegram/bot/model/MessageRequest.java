package com.eespindola.telegram.bot.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {

  @NotBlank(message = "Mensaje vacio")
  private String message;

}

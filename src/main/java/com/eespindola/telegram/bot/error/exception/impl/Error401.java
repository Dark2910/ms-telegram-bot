package com.eespindola.telegram.bot.error.exception.impl;

import com.eespindola.telegram.bot.error.enums.ErrorEnum;

import java.util.List;

public class Error401 extends GenericRuntimeException {
  // Unauthorized
  public Error401(List<String> description) {
    super(description, ErrorEnum.ERROR_401);
  }

}

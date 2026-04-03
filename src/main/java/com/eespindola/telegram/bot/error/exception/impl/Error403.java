package com.eespindola.telegram.bot.error.exception.impl;

import com.eespindola.telegram.bot.error.enums.ErrorEnum;

import java.util.List;

public class Error403 extends GenericRuntimeException {
  // Forbidden
  public Error403(List<String> description) {
    super(description, ErrorEnum.ERROR_403);
  }

}

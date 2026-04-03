package com.eespindola.telegram.bot.error.exception.impl;

import com.eespindola.telegram.bot.error.enums.ErrorEnum;

import java.util.List;

public class Error400 extends GenericRuntimeException {
  // Bad Request
  public Error400(List<String> description) {
    super(description, ErrorEnum.ERROR_400);
  }

}

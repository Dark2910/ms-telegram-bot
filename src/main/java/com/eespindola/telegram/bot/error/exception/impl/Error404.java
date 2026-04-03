package com.eespindola.telegram.bot.error.exception.impl;

import com.eespindola.telegram.bot.error.enums.ErrorEnum;

import java.util.List;

public class Error404 extends GenericRuntimeException {
  // Not Found
  public Error404(List<String> description) {
    super(description, ErrorEnum.ERROR_404);
  }

}

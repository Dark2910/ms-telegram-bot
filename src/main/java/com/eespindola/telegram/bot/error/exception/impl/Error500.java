package com.eespindola.telegram.bot.error.exception.impl;

import com.eespindola.telegram.bot.error.enums.ErrorEnum;

import java.util.List;

public class Error500 extends GenericRuntimeException {
  // Internal Server Error
  public Error500(List<String> description) {
    super(description, ErrorEnum.ERROR_500);
  }

  public Error500(List<String> description, Throwable e) {
    super(description, ErrorEnum.ERROR_500, e);
  }

}

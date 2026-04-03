package com.eespindola.telegram.bot.error.exception.impl;

import com.eespindola.telegram.bot.error.enums.ErrorEnum;
import com.eespindola.telegram.bot.error.exception.ErrorData;

import java.util.List;

public class GenericRuntimeException extends RuntimeException implements ErrorData {

  private final List<String> description;
  private final ErrorEnum errorEnum;

  public GenericRuntimeException(List<String> description, ErrorEnum errorEnum) {
    super();
    this.description = description;
    this.errorEnum = errorEnum;
  }

  public GenericRuntimeException(List<String> description, ErrorEnum errorEnum, Throwable e) {
    super(e);
    this.description = description;
    this.errorEnum = errorEnum;
  }

  @Override
  public List<String> getDescription() {
    return this.description;
  }

  @Override
  public ErrorEnum getErrorEnum() {
    return this.errorEnum;
  }

}

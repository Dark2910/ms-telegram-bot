package com.eespindola.telegram.bot.error.exception.impl;

import com.eespindola.telegram.bot.error.exception.GenericErrorData;

import java.util.List;

public class Error500 extends RuntimeException implements GenericErrorData {
  // Internal Server Error
  private List<String> description;

  public Error500(List<String> description) {
    super();
    this.description = description;
  }

  @Override
  public List<String> getDescription() {
    return description;
  }

}

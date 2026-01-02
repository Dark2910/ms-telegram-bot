package com.eespindola.telegram.bot.error.exception.impl;

import com.eespindola.telegram.bot.error.exception.GenericErrorData;

import java.util.List;

public class Error503 extends RuntimeException implements GenericErrorData {
  // Service Unavailable
  private List<String> description;

  public Error503(List<String> description) {
    super();
    this.description = description;
  }

  @Override
  public List<String> getDescription() {
    return description;
  }

}

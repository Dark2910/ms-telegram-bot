package com.eespindola.telegram.bot.error.exception.impl;

import com.eespindola.telegram.bot.error.exception.GenericErrorData;

import java.util.List;

public class Error400 extends RuntimeException implements GenericErrorData {
  // Bad Request
  private final List<String> description;

  public Error400(List<String> description) {
    super();
    this.description = description;
  }

  @Override
  public List<String> getDescription() {
    return description;
  }

}

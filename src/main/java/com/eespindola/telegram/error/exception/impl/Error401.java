package com.eespindola.telegram.error.exception.impl;

import com.eespindola.telegram.error.exception.GenericErrorData;

import java.util.List;

public class Error401 extends RuntimeException implements GenericErrorData {
  // Unauthorized
  private final List<String> description;

  public Error401(List<String> description) {
    super();
    this.description = description;
  }

  @Override
  public List<String> getDescription() {
    return description;
  }

}

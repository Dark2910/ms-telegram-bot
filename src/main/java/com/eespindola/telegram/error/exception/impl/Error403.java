package com.eespindola.telegram.error.exception.impl;

import com.eespindola.telegram.error.exception.GenericErrorData;

import java.util.List;

public class Error403 extends RuntimeException implements GenericErrorData {
  // Forbidden
  private List<String> description;

  public Error403(List<String> description) {
    super();
    this.description = description;
  }

  @Override
  public List<String> getDescription() {
    return description;
  }

}

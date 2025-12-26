package com.eespindola.telegram.error.exception.impl;

import com.eespindola.telegram.error.exception.GenericErrorData;

import java.util.List;

public class Error404 extends RuntimeException implements GenericErrorData {
  // Not Found
  private List<String> description;

  public Error404(List<String> description) {
    super();
    this.description = description;
  }

  @Override
  public List<String> getDescription() {
    return description;
  }

}

package com.eespindola.telegram.error.enums;

import lombok.Getter;

@Getter
public enum ErrorEnum {

  ERROR_400("Bad Request", 400),
  ERROR_401("Unauthorized", 401),
  ERROR_403("Forbidden", 403),
  ERROR_404("Not Found", 404),
  ERROR_500("Internal Server Error", 500),
  ERROR_503("Service Unavailable", 503);

  private final String description;
  private final int errorCode;

  ErrorEnum(String description, int errorCode){
    this.description = description;
    this.errorCode = errorCode;
  }

}

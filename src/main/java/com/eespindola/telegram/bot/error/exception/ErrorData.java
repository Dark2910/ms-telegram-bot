package com.eespindola.telegram.bot.error.exception;

import com.eespindola.telegram.bot.error.enums.ErrorEnum;

import java.util.List;

public interface ErrorData {

  List<String> getDescription();

  ErrorEnum getErrorEnum();

}

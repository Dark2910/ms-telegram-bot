package com.eespindola.telegram.bot.error.controller;

import com.eespindola.telegram.bot.error.enums.ErrorEnum;
import com.eespindola.telegram.bot.error.exception.impl.*;
import com.eespindola.telegram.bot.model.dto.Result;
import com.eespindola.telegram.bot.util.ResultFactory;
import feign.FeignException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionController {

  @ExceptionHandler(GenericRuntimeException.class)
  private ResponseEntity<Result<String>> genericExceptionController(GenericRuntimeException e) {
    Result<String> result =
            ResultFactory.error(e.getErrorEnum().getMessage(), e.getErrorEnum().getErrorCode(), e.getDescription());
    return ResponseEntity.status(e.getErrorEnum().getStatus()).body(result);
  }

  // Validation
  @ExceptionHandler(MethodArgumentNotValidException.class)
  private ResponseEntity<Result<String>> errorRequestController(MethodArgumentNotValidException e) {

    List<String> errorList = e.getBindingResult().getFieldErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .toList();

    Result<String> result = ResultFactory.error(ErrorEnum.ERROR_400.getMessage(),
                                                ErrorEnum.ERROR_400.getErrorCode(), errorList);

    return ResponseEntity.status(ErrorEnum.ERROR_400.getStatus()).body(result);
  }

  // Feign
  @ExceptionHandler(FeignException.class)
  private ResponseEntity<Result<String>> feignExceptionController(FeignException e) {

    HttpStatus status = HttpStatus.resolve(e.status());
    if (status == null) {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    Result<String> result =
            ResultFactory.error(status.getReasonPhrase(), status.value(), List.of("Error feignClient"));

    return ResponseEntity.status(status).body(result);
  }

}

package com.eespindola.telegram.error.controller;

import com.eespindola.telegram.error.enums.ErrorEnum;
import com.eespindola.telegram.error.exception.impl.*;
import com.eespindola.telegram.model.dto.Result;
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

  @ExceptionHandler(Error400.class)
  private ResponseEntity<Result<String>> error400Controller(Error400 error400){
    Result<String> result = builResult(ErrorEnum.ERROR_400, error400.getDescription());
    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Error401.class)
  private ResponseEntity<Result<String>> error401Controller(Error401 error401){
    Result<String> result = builResult(ErrorEnum.ERROR_401, error401.getDescription());
    return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(Error403.class)
  private ResponseEntity<Result<String>> error403Controller(Error403 error403){
    Result<String> result = builResult(ErrorEnum.ERROR_403, error403.getDescription());
    return new ResponseEntity<>(result, HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(Error404.class)
  private ResponseEntity<Result<String>> error404Controller(Error404 error404){
    Result<String> result = builResult(ErrorEnum.ERROR_404, error404.getDescription());
    return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Error500.class)
  private ResponseEntity<Result<String>> error500Controller(Error500 error500){
    Result<String> result = builResult(ErrorEnum.ERROR_500, error500.getDescription());
    return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(Error503.class)
  private ResponseEntity<Result<String>> error503Controller(Error503 error503){
    Result<String> result = builResult(ErrorEnum.ERROR_503, error503.getDescription());
    return new ResponseEntity<>(result, HttpStatus.SERVICE_UNAVAILABLE);
  }

  // Validation
  @ExceptionHandler(MethodArgumentNotValidException.class)
  private ResponseEntity<Result<String>> errorRequestController(MethodArgumentNotValidException e) {

    List<String> errorList = e.getBindingResult().getFieldErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .toList();

    Result<String> result = builResult(ErrorEnum.ERROR_400, errorList);
    return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
  }

  // Feign
  @ExceptionHandler(FeignException.class)
  private ResponseEntity<Result<String>> feignExceptionController(FeignException e){

    HttpStatus status = HttpStatus.resolve(e.status());
    if(status == null){
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    Result<String> result = Result.<String>builder()
            .success(false)
            .message(status.getReasonPhrase())
            .errorCode(status.value())
            .errorDescription(List.of("Error feignClient"))
            .build();

    return new ResponseEntity<>(result, status);
  }

  private static Result<String> builResult(ErrorEnum errorEnum, List<String> errorList) {
    return Result.<String>builder()
            .success(false)
            .message(errorEnum.getDescription())
            .errorCode(errorEnum.getErrorCode())
            .errorDescription(errorList)
            .build();
  }

}

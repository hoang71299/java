package com.learnjava.identity_service.exception;

public class ApiException extends RuntimeException {

  public ApiException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  private ErrorCode errorCode;

  public ErrorCode getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(ErrorCode errorCode) {
    this.errorCode = errorCode;
  }

}
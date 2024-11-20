package com.learnjava.identity_service.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
  UNCATEGORIZED_EXCEPTION(999, "uncategorized exception"),
  INVALID_KEY(1001, "invalid message key"),
  USER_EXISTED(1002, "User existed"),
  USERNAME_INVALID(1003, "Username must be at least 3 character"),
  INVALID_PASSWORD(1004, "Password must be at least 8 character");

  private Integer code;
  private String message;

  // Constructor cho enum
  ErrorCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  // Getter để truy xuất giá trị
  public Integer getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

}
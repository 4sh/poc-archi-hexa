package com.izivia.mobility.core.tokens.domain.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DomainException extends RuntimeException {

  private ErrorType errorType;
  private String message;
}

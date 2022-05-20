package com.izivia.mobility.core.organizations.infra.grpc.advice;

import com.izivia.mobility.core.organizations.domain.error.DomainException;
import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GrpcExceptionAdvice {

  @GrpcExceptionHandler
  public Status handleDomainException(DomainException e) {
    return Status.NOT_FOUND.withDescription(e.getMessage()).withCause(e);
  }
  @GrpcExceptionHandler
  public Status handleGlobalException(Exception e) {
    return Status.INTERNAL.withDescription(e.getMessage()).withCause(e);
  }
}

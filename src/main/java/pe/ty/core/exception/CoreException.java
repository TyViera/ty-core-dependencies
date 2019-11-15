package pe.ty.core.exception;

import lombok.Builder;

@Builder
public class CoreException extends RuntimeException {

  private static final long serialVersionUID = -7409418995529940304L;

  private String code;
  private String component;
  private CoreExceptionType type;
  private Throwable cause;


}

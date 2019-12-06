package pe.ty.core.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;
import java.util.Optional;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, value = "suppressed")
public final class CoreException extends RuntimeException {

  private static final long serialVersionUID = -7409418995529940304L;

  private String code;
  private String message;
  private String component;
  private CoreExceptionType errorType;

  @JsonIgnore
  private Map<String, String> headers;

  @JsonIgnore
  private CoreExceptionStatus status;

  @JsonIgnore
  private Throwable cause;

  @JsonIgnore
  private boolean resolved;

  @JsonIgnore
  private Integer httpStatusCode;

  @Builder(toBuilder = true)
  CoreException(Throwable cause, String message, String code, String component,
      CoreExceptionType errorType, Map<String, String> headers, CoreExceptionStatus status,
      Integer httpStatusCode, boolean resolved) {
    super(message, cause);
    this.errorType = Optional.ofNullable(errorType).orElse(CoreExceptionType.TECHNICAL);
    this.status = Optional.ofNullable(status).orElse(CoreExceptionStatus.UNEXPECTED);
    this.component = component;
    this.code = code;
    this.message = message;
    this.cause = cause;
    this.headers = headers;
    this.httpStatusCode = httpStatusCode;
    this.resolved = resolved;
  }

  @Override
  public String getMessage() {
    return this.message;
  }

  @Override
  @JsonIgnore
  public String getLocalizedMessage() {
    return super.getLocalizedMessage();
  }

  @Override
  @JsonIgnore
  public synchronized Throwable getCause() {
    return this.cause;
  }

  @Override
  @JsonIgnore
  public StackTraceElement[] getStackTrace() {
    return super.getStackTrace();
  }

  public CoreException markAsResolved() {
    this.resolved = true;
    return this;
  }

}

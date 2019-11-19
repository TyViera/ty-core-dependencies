package pe.ty.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CoreExceptionStatus {

  BAD_REQUEST(400, ".bad-request"),
  NOT_AUTHORIZED(401, ".not-authorized"),
  FORBIDDEN(403, ".forbidden"),
  NOT_FOUND(404, ".not-found"),
  CONFLICT(409, ".conflict"),
  TIMEOUT(504, ".timeout"),
  EXTERNAL_ERROR(500, ".external-error"),
  UNEXPECTED(500, ".unexpected");

  private final Integer httpStatus;
  private final String code;

}

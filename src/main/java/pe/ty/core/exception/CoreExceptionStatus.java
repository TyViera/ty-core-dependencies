package pe.ty.core.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CoreExceptionStatus {

  BAD_REQUEST(400, ".bad-request"),
  NOT_AUTHORIZED(401, ".not-authorized"),
  FORBIDDEN(403, ".forbidden"),
  NOT_FOUND(404, ".not-found"),
  CONFLICT(409, ".conflict"),
  PRECONDITION_FAILED(412, ".precondition-failed"),
  TIMEOUT(503, ".timeout"),
  EXTERNAL_ERROR(503, ".external-error"),
  INVALID_EXTERNAL_DATA(500, ".invalid-external-data"),
  UNEXPECTED(500, ".unexpected"),
  CUSTOM(-1, "");

  private final Integer httpStatus;
  private final String propertyName;

}

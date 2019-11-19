package pe.ty.core.jackson;

import pe.ty.core.model.BaseTyModel;

public class NonEmptyModelFilter {

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return true;
    }
    if (obj instanceof BaseTyModel) {
      return ((BaseTyModel) obj).isEmpty();
    }
    return false;
  }
}

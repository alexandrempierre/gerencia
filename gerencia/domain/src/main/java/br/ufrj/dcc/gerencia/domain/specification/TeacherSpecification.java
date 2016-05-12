package br.ufrj.dcc.gerencia.domain.specification;

import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.LikeFilter;
/**
 * Created by fausto on 4/17/16.
 */
public class TeacherSpecification extends UserBaseSpecification {

  @Override
  protected void makeFilter(AndFilter filter) {}

  @Override
  public String toString() {
    return "TeacherSpecification{" +
      ",super: " + super.toString() +
      "}";
  }
}

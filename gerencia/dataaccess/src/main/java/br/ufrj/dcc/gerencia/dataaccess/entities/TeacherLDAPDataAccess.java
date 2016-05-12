package br.ufrj.dcc.gerencia.dataaccess.entities;

import br.ufrj.dcc.gerencia.dataaccess.base.CrudLdapDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.TeacherLdapMapper;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.entities.Teacher;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fausto on 4/17/16.
 */

@Component
public class TeacherLDAPDataAccess extends CrudLdapDataAccess<Teacher, TeacherLdapMapper> {

  @Override
  protected LdapNameBuilder getBaseDN(LdapNameBuilder instance) {
    return instance
      .add("ou","usuarios")
      .add("ou","academicos")
      .add("ou","professores");
  }
}

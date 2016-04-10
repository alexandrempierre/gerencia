package br.ufrj.dcc.gerencia.dataaccess.entities;

import br.ufrj.dcc.gerencia.dataaccess.base.CrudLdapDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.StudentLdapMapper;
import br.ufrj.dcc.gerencia.domain.entities.Student;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Component;


/**
 * Created by fausto on 4/10/16.
 */

@Component
public class StudentLDAPDataAccess extends CrudLdapDataAccess<Student,StudentLdapMapper> {

  @Override
  protected LdapNameBuilder getBaseDN(LdapNameBuilder instance) {
    return instance
      .add("ou","usuario")
      .add("ou","academico")
      .add("ou","aluno");
  }
}

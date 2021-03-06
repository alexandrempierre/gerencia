package br.ufrj.dcc.gerencia.dataaccess.entities;

import br.ufrj.dcc.gerencia.dataaccess.base.CrudLdapDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.ExampleLdapMapperUser;
import br.ufrj.dcc.gerencia.domain.entities.Example;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/5/16.
 */

@Component
public class ExampleLDAPDataAccessBase extends CrudLdapDataAccess<Example, ExampleLdapMapperUser> {

  @Override
  protected LdapNameBuilder getBaseDN(LdapNameBuilder instance) {
    return instance
      .add("ou","usuario")
      .add("ou","academico")
      .add("ou","aluno");
  }
}

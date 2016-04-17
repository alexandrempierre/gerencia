package br.ufrj.dcc.gerencia.dataaccess.entities;

import br.ufrj.dcc.gerencia.dataaccess.base.CrudLdapDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.UserLdapMapper;
import br.ufrj.dcc.gerencia.domain.entities.User;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/16/16.
 */

@Component
public class UserLDAPDataAccess extends CrudLdapDataAccess<User, UserLdapMapper> {

  @Override
  public void update(User register) {
    super.update(register, register.getDn());
  }

  @Override
  protected LdapNameBuilder getBaseDN(LdapNameBuilder instance) {
    return instance.add("ou","usuarios");
  }
}

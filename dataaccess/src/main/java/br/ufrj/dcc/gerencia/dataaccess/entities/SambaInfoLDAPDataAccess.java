package br.ufrj.dcc.gerencia.dataaccess.entities;

import br.ufrj.dcc.gerencia.dataaccess.base.CrudLdapDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.SambaInfoLdapMapper;
import br.ufrj.dcc.gerencia.domain.entities.SambaInfo;
import org.springframework.ldap.support.LdapNameBuilder;

/**
 * Created by fausto on 4/14/16.
 */
public class SambaInfoLDAPDataAccess extends CrudLdapDataAccess<SambaInfo, SambaInfoLdapMapper> {

  @Override
  protected LdapNameBuilder getBaseDN(LdapNameBuilder instance) {
    return instance
      .add("sambaDomainName","DCC");
  }

  public SambaInfo get() {
    return findByKey(getBaseDN());
  }
}

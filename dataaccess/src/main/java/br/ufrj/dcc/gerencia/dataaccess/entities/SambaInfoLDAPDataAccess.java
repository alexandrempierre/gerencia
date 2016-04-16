package br.ufrj.dcc.gerencia.dataaccess.entities;

import br.ufrj.dcc.gerencia.dataaccess.base.CrudLdapDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.SambaInfoLdapMapper;
import br.ufrj.dcc.gerencia.domain.entities.SambaInfo;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/14/16.
 */

@Component
public class SambaInfoLDAPDataAccess extends CrudLdapDataAccess<SambaInfo, SambaInfoLdapMapper> {

  @Override
  protected LdapNameBuilder getBaseDN(LdapNameBuilder instance) {
    return instance
      .add("sambaDomainName=DCC");
  }

  @Override
  public void update(SambaInfo register) {
    update(register, getBaseDN());
  }

  @Override
  public SambaInfo findByKey(String key) {
    if (key == null){
      return super.findByKey(getBaseDN());
    }else{
      return super.findByKey(key);
    }
  }
}

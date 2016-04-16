package br.ufrj.dcc.gerencia.dataaccess.mapper;

import br.ufrj.dcc.gerencia.dataaccess.base.LCIUserAbstractContextMapper;
import br.ufrj.dcc.gerencia.domain.entities.SambaInfo;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/14/16.
 */

@Component
public class SambaInfoLdapMapperUser extends LCIUserAbstractContextMapper<SambaInfo> {

  @Override
  protected void mapperResult(SambaInfo register, DirContextOperations ctx) {
    register.setUidNumber(new Integer(ctx.getStringAttribute("uidNumber")));
    register.setSambaNextRid(new Integer(ctx.getStringAttribute("sambaNextRid")));
    register.setSambaSID(ctx.getStringAttribute("sambaSID"));
  }

  @Override
  public void mapToContext(SambaInfo register, DirContextOperations ctx) {
    ctx.setAttributeValue("uidNumber", register.getUidNumber());
    ctx.setAttributeValue("sambaNextRid", register.getSambaNextRid());
    ctx.setAttributeValue("sambaSID", register.getSambaSID());
  }
}

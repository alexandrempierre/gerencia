package br.ufrj.dcc.gerencia.dataaccess.mapper;

import br.ufrj.dcc.gerencia.dataaccess.base.LCIAbstractContextMapper;
import br.ufrj.dcc.gerencia.domain.entities.SambaInfo;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.stereotype.Component;

import static br.ufrj.dcc.gerencia.domain.auxiliar.ObjectClassLdap.SAMBA_INFO_OBJECT_CLASS;

/**
 * Created by fausto on 4/14/16.
 */

@Component
public class SambaInfoLdapMapper extends LCIAbstractContextMapper<SambaInfo> {

  @Override
  protected void mapperResult(SambaInfo register, DirContextOperations ctx) {
    register.setUidNumber(new Integer(ctx.getStringAttribute("uidNumber")));
    register.setSambaNextRid(new Integer(ctx.getStringAttribute("sambaNextRid")));
    register.setSambaSID(ctx.getStringAttribute("sambaSID"));
  }

  @Override
  public void mapToContext(SambaInfo register, DirContextOperations ctx) {
    ctx.setAttributeValues("objectclass", SAMBA_INFO_OBJECT_CLASS);

    ctx.setAttributeValue("uidNumber", Integer.toString(register.getUidNumber()));
    ctx.setAttributeValue("sambaNextRid", Integer.toString(register.getSambaNextRid()));
    ctx.setAttributeValue("sambaSID", register.getSambaSID());
  }
}

package br.ufrj.dcc.gerencia.dataaccess.mapper;

import br.ufrj.dcc.gerencia.dataaccess.base.LCIUserAbstractContextMapper;
import br.ufrj.dcc.gerencia.domain.auxiliar.GerenciaDefaultConstraint;
import br.ufrj.dcc.gerencia.domain.entities.User;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/16/16.
 */

@Component
public class UserLdapMapper extends LCIUserAbstractContextMapper<User> {

  @Override
  protected void mapperResult(User register, DirContextOperations ctx) {
    register.setDn(ctx.getDn().toString());
    register.setLimitHDSpace(new Integer(ctx.getStringAttribute("cota")));
    register.setLogin(ctx.getStringAttribute("uid"));
  }

  @Override
  public void mapToContext(User register, DirContextOperations ctx) {
    ctx.setAttributeValue("cota", Integer.toString(register.getLimitHDSpace()));
    ctx.setAttributeValue("uid", register.getLogin());
    ctx.setAttributeValue("userPassword", register.getPassword());
    ctx.setAttributeValue("sambaLMPassword", register.getSambaLMPassword());
    ctx.setAttributeValue("sambaNTPassword", register.getSambaNTPassword());
    ctx.setAttributeValue("sambaPwdMustChange", Long.toString(register.getUpdatedAt() + GerenciaDefaultConstraint.SAMBA_PWD_MUST_CHANGE));
    ctx.setAttributeValue("shadowLastChange", Long.toString(GerenciaDefaultConstraint.ShadowLastChange(register.getUpdatedAt())));
  }
}

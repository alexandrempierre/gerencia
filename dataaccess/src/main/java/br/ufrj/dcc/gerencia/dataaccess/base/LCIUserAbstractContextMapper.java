package br.ufrj.dcc.gerencia.dataaccess.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import org.springframework.ldap.core.DirContextOperations;


/**
 * Created by fausto on 4/10/16.
 */
public abstract class LCIUserAbstractContextMapper<M extends LCIModel> extends LCIAbstractContextMapper<M> {

  public void mapBaseToContext(M register, DirContextOperations context) {
    context.setAttributeValue("dataCriacao", Long.toString(register.getCreatedAt()));
    context.setAttributeValue("dataRenovacao", Long.toString(register.getUpdatedAt()));
  }

  @Override
  public void mapInsertToContext(M register, DirContextOperations context) {
    mapBaseToContext(register,context);
    super.mapInsertToContext(register, context);
  }

  @Override
  public void mapEditToContext(M register, DirContextOperations context) {
    mapBaseToContext(register, context);
    super.mapEditToContext(register, context);
  }

  @Override
  public M doMapFromContext(DirContextOperations ctx) {
    M register = super.doMapFromContext(ctx);
    register.setCreatedAt(new Long(ctx.getStringAttribute("dataCriacao")));
    register.setUpdatedAt(new Long(ctx.getStringAttribute("dataRenovacao")));
    return register;
  }
}

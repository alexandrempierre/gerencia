package br.ufrj.dcc.gerencia.dataaccess.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.support.AbstractContextMapper;

import java.lang.reflect.ParameterizedType;

/**
 * Created by fausto on 4/10/16.
 */
public abstract class LCIUserAbstractContextMapper<M extends LCIModel> extends LCIAbstractContextMapper<M> {

  @Override
  public M doMapFromContext(DirContextOperations ctx) {
    M register = super.doMapFromContext(ctx);
    register.setCreatedAt(new Long(ctx.getStringAttribute("dataCriacao")));
    register.setUpdatedAt(new Long(ctx.getStringAttribute("dataRenovacao")));
    return register;
  }
}

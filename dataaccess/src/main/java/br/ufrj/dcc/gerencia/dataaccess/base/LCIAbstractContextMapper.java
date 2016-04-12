package br.ufrj.dcc.gerencia.dataaccess.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.support.AbstractContextMapper;

import java.lang.reflect.ParameterizedType;

/**
 * Created by fausto on 4/10/16.
 */
public abstract class LCIAbstractContextMapper<M extends LCIModel> extends AbstractContextMapper<M> {

  private Class<M> getLciModelClass(){
    return (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }

  public void mapInsertToContext(M register, DirContextOperations context){ mapToContext(register,context); }
  public void mapEditToContext(M register, DirContextOperations context){ mapToContext(register,context); }
  public void mapToContext(M register, DirContextOperations context){}

  public M doMapFromContext(DirContextOperations ctx) {
    M register = null;
    try {
      register = getLciModelClass().newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    register.setCreatedAt(new Long(ctx.getStringAttribute("dataCriacao")));
    register.setUpdatedAt(new Long(ctx.getStringAttribute("dataRenovacao")));

    mapperResult(register,ctx);
    return register;
  }

  protected abstract void mapperResult(M register, DirContextOperations ctx);
}

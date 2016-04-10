package br.ufrj.dcc.gerencia.dataaccess.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.support.AbstractContextMapper;

/**
 * Created by fausto on 4/10/16.
 */
public abstract class LCIAbstractContextMapper<M extends LCIModel> extends AbstractContextMapper<M> {

  public void mapInsertToContext(M register, DirContextOperations context){ mapToContext(register,context); }
  public void mapEditToContext(M register, DirContextOperations context){ mapToContext(register,context); }
  public void mapToContext(M register, DirContextOperations context){}
}

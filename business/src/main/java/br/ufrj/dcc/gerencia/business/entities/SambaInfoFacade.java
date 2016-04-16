package br.ufrj.dcc.gerencia.business.entities;

import br.ufrj.dcc.gerencia.business.base.CrudFacade;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.entities.SambaInfo;
import br.ufrj.dcc.gerencia.repository.contract.SambaInfoRepository;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/14/16.
 */

@Component
public class SambaInfoFacade extends CrudFacade<SambaInfo, LciLdapSpecification, SambaInfoRepository> {

  public SambaInfo get() {
    return super.get(null);
  }

  public SambaInfo getStats(){
    SambaInfo result, register = get();
    try {
      register.incrementSambaNextRid();
      result = register.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }

    register.incrementUidNumber();
    save(register);

    return result;
  }

}

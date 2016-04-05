package br.ufrj.dcc.gerencia.service.base;

import br.ufrj.dcc.gerencia.business.base.CrudFacade;
import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.repository.base.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by fausto on 4/3/16.
 */

@Component
public abstract class CrudRestAPI
  <M extends LCIModel,
   B extends CrudFacade<M,R>,
   R extends Repository<M>>
  implements CrudRestAPIContract<M>{

  @Autowired
  private B facade;

  protected B getFacade() {
    return facade;
  }

  public int save(M register) {
    return getFacade().save(register);
  }

  public M get(@PathVariable("id") int id) {
    return getFacade().get(id);
  }
}

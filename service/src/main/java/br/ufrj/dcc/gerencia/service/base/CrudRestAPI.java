package br.ufrj.dcc.gerencia.service.base;

import br.ufrj.dcc.gerencia.business.base.CrudFacade;
import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.irepository.base.Repository;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/3/16.
 */

@Component
public abstract class CrudRestAPI
  <M extends LCIModel,
   B, //extends CrudFacade<M,R>,
   R extends Repository<M>>
  implements CrudRestAPIContract<M>{

  private B facade;

  protected CrudRestAPI(B facade) {
    this.facade = facade;
  }

  protected B getFacade() {
    return facade;
  }

  public int save(M register) {
    //return getFacade().save(register);
    return 40;
  }

  public M get(int id) {
    //return getFacade().get(id);
    return null;
  }
}

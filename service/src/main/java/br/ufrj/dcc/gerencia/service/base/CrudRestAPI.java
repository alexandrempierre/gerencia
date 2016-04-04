package br.ufrj.dcc.gerencia.service.base;

import br.ufrj.dcc.gerencia.business.base.CrudFacade;
import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.irepository.base.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fausto on 4/3/16.
 */
public class CrudRestAPI
  <M extends LCIModel,
   B extends CrudFacade<M,R>,
   R extends IRepository<M>>
  implements CrudRestAPIContract<M>{

  private B busy;

  @Autowired
  public CrudRestAPI(B busy) {
    this.busy = busy;
  }

  protected B getBusy() {
    return busy;
  }

  public int save(M register) {
    return getBusy().save(register);
  }

  public M get(int id) {
    return getBusy().get(id);
  }
}

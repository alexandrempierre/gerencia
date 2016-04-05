package br.ufrj.dcc.gerencia.business.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.repository.base.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/3/16.
 */

@Component
public class CrudFacade
  <M extends LCIModel, R extends Repository<M>>
{

  private R repository;

  protected R getRepository() {
    return repository;
  }

  @Autowired
  protected void setRepository(R repository) {
    this.repository = repository;
  }

  public int save(M register){
    return getRepository().save(register);
  }

  public M get(int id){
    return getRepository().get(id);
  }

}

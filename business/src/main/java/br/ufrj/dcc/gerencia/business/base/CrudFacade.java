package br.ufrj.dcc.gerencia.business.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.irepository.base.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fausto on 4/3/16.
 */
public class CrudFacade
  <M extends LCIModel, R extends IRepository<M>>
{

  private R repository;

  protected R getRepository() {
    return repository;
  }

  @Autowired
  public CrudFacade(R repository){
    this.repository = repository;
  }

  int save(M register){
    return getRepository().save(register);
  }

  M get(int id){
    return getRepository().get(id);
  }

}

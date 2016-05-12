package br.ufrj.dcc.gerencia.business.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciSpecification;
import br.ufrj.dcc.gerencia.repository.base.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fausto on 4/3/16.
 */

public class CrudFacade
  <M extends LCIModel,S extends LciSpecification, R extends Repository<M,S>>
{
  @Autowired
  private R repository;

  protected R getRepository() {
    return repository;
  }

  public M save(M register){
    return getRepository().save(register);
  }
  public List<M> query(S specification){
    return getRepository().query(specification);
  }
  public M get(String uid){
    return getRepository().get(uid);
  }
  public M delete(String uid){
    return getRepository().delete(uid);
  }
}

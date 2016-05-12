package br.ufrj.dcc.gerencia.service.base;

import br.ufrj.dcc.gerencia.business.base.CrudFacade;
import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciSpecification;
import br.ufrj.dcc.gerencia.repository.base.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fausto on 4/3/16.
 */

@RequestMapping("/api")
public abstract class CrudRestAPI
  <M extends LCIModel,
   S extends LciSpecification,
   B extends CrudFacade<M,S,R>,
   R extends Repository<M,S>>
  implements CrudRestAPIContract<M,S>{

  @Autowired
  private B facade;

  protected B getFacade() {
    return facade;
  }

  public M save(@RequestBody M register){
    return getFacade().save(register);
  }

  public List<M> query(S specification){
    return getFacade().query(specification);
  }
  public M get(String uid){
    return getFacade().get(uid);
  }
  public M delete(String uid){
    return getFacade().delete(uid);
  }
}

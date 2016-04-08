package br.ufrj.dcc.gerencia.service.base;

import br.ufrj.dcc.gerencia.business.base.CrudFacade;
import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciModelVO;
import br.ufrj.dcc.gerencia.domain.base.LciSpecification;
import br.ufrj.dcc.gerencia.repository.base.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fausto on 4/3/16.
 */

@Component
public abstract class CrudRestAPI
  <M extends LCIModel,
   V extends LciModelVO<M>,
   S extends LciSpecification,
   B extends CrudFacade<M,S,R>,
   R extends Repository<M,S>>
  implements CrudRestAPIContract<V,S>{

  @Autowired
  private B facade;

  protected B getFacade() {
    return facade;
  }

  public V save(V registerVO){
    M register = getFacade().save(registerVO.toModel());
    return register.toVO();
  }
  public List<V> query(S specification){
    List<M> registers = getFacade().query(specification);
    List<V> result = new ArrayList<>(registers.size());
    for (M model: registers) {
      result.add(model.toVO());
    }
    return result;
  }
  public V get(@RequestParam("uid") String uid){
    M register = getFacade().get(uid);
    return register.toVO();
  }
  public V delete(@RequestParam("uid") String uid){
    M register = getFacade().delete(uid);
    return register.toVO();
  }
}

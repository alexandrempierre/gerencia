package br.ufrj.dcc.gerencia.contract.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fausto on 4/3/16.
 */

//TODO: Fazer o mapping da variavel
public interface CrudRestAPIContract<M extends LCIModel> {

  @RequestMapping("/save")
  int save(M register);

  //TODO: Fazer @PathVariable
  @RequestMapping("/get")
  M get(int id);

}

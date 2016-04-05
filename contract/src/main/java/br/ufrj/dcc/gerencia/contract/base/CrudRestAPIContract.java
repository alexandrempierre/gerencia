package br.ufrj.dcc.gerencia.contract.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fausto on 4/3/16.
 */

public interface CrudRestAPIContract<M extends LCIModel> {

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  int save(M register);

  @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
  M get(@PathVariable("id") int id);

}

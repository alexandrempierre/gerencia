package br.ufrj.dcc.gerencia.contract.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciSpecification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by fausto on 4/3/16.
 */

public interface CrudRestAPIContract<M extends LCIModel, S extends LciSpecification> {

  @RequestMapping(value="/saves", method=RequestMethod.POST)
  M save(M register);

  @RequestMapping(value="/list", method=RequestMethod.GET)
  List<M> query(S specification);

  @RequestMapping(value="/get", method=RequestMethod.GET)
  M get(String uid);

  @RequestMapping(value="/delete", method=RequestMethod.DELETE)
  M delete(String uid);
}

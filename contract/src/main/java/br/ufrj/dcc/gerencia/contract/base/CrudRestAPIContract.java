package br.ufrj.dcc.gerencia.contract.base;

import br.ufrj.dcc.gerencia.domain.base.LciModelVO;
import br.ufrj.dcc.gerencia.domain.base.LciSpecification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by fausto on 4/3/16.
 */

public interface CrudRestAPIContract<V extends LciModelVO, S extends LciSpecification> {

  @RequestMapping(value="/save", method=RequestMethod.POST)
  V save(V register);

  @RequestMapping(value="/list", method=RequestMethod.GET)
  List<V> query(S specification);

  @RequestMapping(value="/get", method=RequestMethod.GET)
  V get(String uid);

  @RequestMapping(value="/delete", method=RequestMethod.DELETE)
  V delete(String uid);
}

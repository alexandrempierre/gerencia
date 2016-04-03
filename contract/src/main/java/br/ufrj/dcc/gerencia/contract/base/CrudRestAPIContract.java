package br.ufrj.dcc.gerencia.contract.base;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fausto on 4/3/16.
 */

public interface CrudRestAPIContract {

  @RequestMapping("/teste")
  String teste();
}

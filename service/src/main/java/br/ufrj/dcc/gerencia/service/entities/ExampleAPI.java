package br.ufrj.dcc.gerencia.service.entities;

import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fausto on 4/2/16.
 */

@RestController
@RequestMapping("/teste")
public class ExampleAPI {

  public String teste() {
    return "Oi mundo";
  }
}

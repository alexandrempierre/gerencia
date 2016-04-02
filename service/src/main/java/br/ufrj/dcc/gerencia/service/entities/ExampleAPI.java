package br.ufrj.dcc.gerencia.service.entities;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fausto on 4/2/16.
 */

@RestController
@RequestMapping("/example")
public class ExampleAPI {

  @RequestMapping("/get")
  public String get(){
    return "get";
  }
}

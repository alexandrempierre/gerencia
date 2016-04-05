package br.ufrj.dcc.gerencia.service.entities;

import br.ufrj.dcc.gerencia.business.entities.ExampleFacade;
import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import br.ufrj.dcc.gerencia.contract.entities.ExampleContract;
import br.ufrj.dcc.gerencia.domain.entities.Example;
import br.ufrj.dcc.gerencia.irepository.entities.ExampleRepository;
import br.ufrj.dcc.gerencia.service.base.CrudRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fausto on 4/2/16.
 */

@RestController
@RequestMapping("/example")
public class ExampleAPI extends CrudRestAPI<Example,ExampleFacade,ExampleRepository> implements ExampleContract{

  @Autowired
  public ExampleAPI(ExampleFacade facade) {
    super(facade);
  }

  @Override
  public Example get(@PathVariable("id") int id) {
    return new Example("oi mundo");
  }
}

//TODO: fazer isso: http://stackoverflow.com/questions/21106094/right-way-to-use-componentscan-in-multi-module-java-config-spring-mvc-app
//TODO: Re-habilitar o ExampleFacade
//TODO: Terminar o resto

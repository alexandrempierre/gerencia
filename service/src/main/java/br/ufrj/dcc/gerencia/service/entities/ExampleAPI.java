package br.ufrj.dcc.gerencia.service.entities;

import br.ufrj.dcc.gerencia.business.entities.ExampleFacade;
import br.ufrj.dcc.gerencia.contract.entities.ExampleContract;
import br.ufrj.dcc.gerencia.domain.entities.Example;
import br.ufrj.dcc.gerencia.repository.contract.ExampleRepository;
import br.ufrj.dcc.gerencia.service.base.CrudRestAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fausto on 4/2/16.
 */

/*
 * Reme
 * http://stackoverflow.com/questions/21106094/right-way-to-use-componentscan-in-multi-module-java-config-spring-mvc-app
 */

@RestController
@RequestMapping("/example")
public class ExampleAPI
  extends CrudRestAPI<Example,ExampleFacade,ExampleRepository> implements ExampleContract{

}

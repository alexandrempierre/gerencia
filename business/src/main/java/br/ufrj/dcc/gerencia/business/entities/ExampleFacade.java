package br.ufrj.dcc.gerencia.business.entities;

import br.ufrj.dcc.gerencia.business.base.CrudFacade;
import br.ufrj.dcc.gerencia.repository.contract.ExampleRepository;

import br.ufrj.dcc.gerencia.domain.entities.Example;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/4/16.
 */
@Component
public class ExampleFacade extends CrudFacade<Example, ExampleRepository> {

}

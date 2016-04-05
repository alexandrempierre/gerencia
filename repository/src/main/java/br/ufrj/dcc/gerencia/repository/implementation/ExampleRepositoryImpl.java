package br.ufrj.dcc.gerencia.repository.implementation;

import br.ufrj.dcc.gerencia.domain.entities.Example;
import br.ufrj.dcc.gerencia.repository.base.RepositoryImpl;
import br.ufrj.dcc.gerencia.repository.contract.ExampleRepository;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/4/16.
 */

@Component
public class ExampleRepositoryImpl extends RepositoryImpl<Example> implements ExampleRepository {

  @Override
  public Example get(int id) {
    Example example = new Example("Eu sou um exemplo");
    example.setId(id);
    return example;
  }
}

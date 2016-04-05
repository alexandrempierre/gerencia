package br.ufrj.dcc.gerencia.repository.entities;

import br.ufrj.dcc.gerencia.domain.entities.Example;
import br.ufrj.dcc.gerencia.irepository.entities.ExampleRepository;
import br.ufrj.dcc.gerencia.repository.base.RepositoryImpl;

/**
 * Created by fausto on 4/4/16.
 */
public class ExampleRepositoryImpl extends RepositoryImpl<Example> implements ExampleRepository {

  @Override
  public Example get(int id) {
    System.out.println(String.format("Id recebido %d\n", id));
    return new Example("Eu sou um exemplo");
  }
}

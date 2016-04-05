package br.ufrj.dcc.gerencia.domain.entities;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;

/**
 * Created by fausto on 4/4/16.
 */
public class Example extends LCIModel{
  private String name;

  public Example(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

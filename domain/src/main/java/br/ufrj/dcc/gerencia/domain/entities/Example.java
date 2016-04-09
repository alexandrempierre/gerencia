package br.ufrj.dcc.gerencia.domain.entities;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.po.ExamplePO;

/**
 * Created by fausto on 4/4/16.
 */


public class Example extends LCIModel{

  private String name;

  public Example() {
  }

  public Example(ExamplePO po){
    this.setName(po.getName());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public ExamplePO toPO() {
    return new ExamplePO(this);
  }
}

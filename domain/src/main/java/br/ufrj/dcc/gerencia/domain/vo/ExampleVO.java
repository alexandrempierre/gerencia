package br.ufrj.dcc.gerencia.domain.vo;

import br.ufrj.dcc.gerencia.domain.base.LciModelVO;
import br.ufrj.dcc.gerencia.domain.entities.Example;

/**
 * Created by fausto on 4/7/16.
 */
public class ExampleVO implements LciModelVO<Example>{

  public ExampleVO() {}

  public ExampleVO(Example model) {
    this.setName(model.getName());
  }

  public ExampleVO(String name) {
    this.name = name;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public Example toModel() {
    return new Example(this);
  }
}

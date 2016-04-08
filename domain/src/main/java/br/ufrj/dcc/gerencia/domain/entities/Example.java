package br.ufrj.dcc.gerencia.domain.entities;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciModelPO;
import br.ufrj.dcc.gerencia.domain.po.ExamplePO;
import br.ufrj.dcc.gerencia.domain.vo.ExampleVO;
import org.springframework.ldap.odm.annotations.Entry;

/**
 * Created by fausto on 4/4/16.
 */

@SuppressWarnings("ALL")
public class Example extends LCIModel{

  private String name;

  public Example() {
  }

  public Example(ExampleVO vo){
    this.setName(vo.getName());
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
  public ExampleVO toVO() {
    return new ExampleVO(this);
  }

  @Override
  public ExamplePO toPO() {
    return new ExamplePO(this);
  }
}

package br.ufrj.dcc.gerencia.domain.po;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciModelPO;
import br.ufrj.dcc.gerencia.domain.entities.Example;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

/**
 * Created by fausto on 4/7/16.
 */

@Entry(objectClasses = { "inetOrgPerson"}, base = "ou=aluno,ou=academico,ou=usuario,dc=dcc,dc=ufrj,dc=br")
public class ExamplePO extends LciModelPO<Example>{

  public ExamplePO() {}

  public ExamplePO(Example model) {
    this.setName(model.getName());
  }

  public ExamplePO(String name) {
    this.name = name;
  }

  @Id
  public Name dn;

  @Attribute(name="uid")
  @DnAttribute("uid")
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

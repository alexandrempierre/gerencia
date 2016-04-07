package br.ufrj.dcc.gerencia.domain.entities;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.stereotype.Component;

import javax.naming.Name;

/**
 * Created by fausto on 4/4/16.
 */

@Entry(objectClasses = { "inetOrgPerson"}, base = "ou=aluno,ou=academico,ou=usuario,dc=dcc,dc=ufrj,dc=br")
public class Example extends LCIModel{

  public Example() {
  }

  public Example(Name dn, String login, String name) {
    this.dn = dn;
    this.login = login;
    this.name = name;
  }

  @Id
  public Name dn;

  @Attribute(name = "uid")
  @DnAttribute("uid")
  private String login;

  @Attribute(name = "cn")
  private String name;

  public Name getDn() {
    return dn;
  }

  public void setDn(Name dn) {
    this.dn = dn;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUid(){
    return getLogin();
  }

  @Override
  public String getIdentify() {
    return getLogin();
  }
}

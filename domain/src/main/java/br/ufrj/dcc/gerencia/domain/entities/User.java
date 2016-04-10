package br.ufrj.dcc.gerencia.domain.entities;

import org.springframework.ldap.odm.annotations.Attribute;

/**
 * Created by fausto on 4/10/16.
 */
public class User {

  @Attribute(name = "cota")
  private Integer limitHDSpace;
  private String login;
  private String password;
  private String mail;


  public Integer getLimitHDSpace() {
    return limitHDSpace;
  }

  public void setLimitHDSpace(Integer limitHDSpace) {
    this.limitHDSpace = limitHDSpace;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }
}

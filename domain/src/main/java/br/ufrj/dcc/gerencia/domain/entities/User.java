package br.ufrj.dcc.gerencia.domain.entities;

import br.ufrj.dcc.gerencia.domain.auxiliar.GerenciaDefaultConstraint;
import br.ufrj.dcc.gerencia.domain.base.LCIModel;

/**
 * Created by fausto on 4/10/16.
 */
public class User extends LCIModel{

  private Integer limitHDSpace;
  private String login;
  private String password;

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
    return String.format(GerenciaDefaultConstraint.MAIL_TEMPLATE, getLogin());
  }

}

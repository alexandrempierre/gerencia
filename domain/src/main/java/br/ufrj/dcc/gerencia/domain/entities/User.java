package br.ufrj.dcc.gerencia.domain.entities;

import br.ufrj.dcc.gerencia.domain.auxiliar.GerenciaDefaultConstraint;
import br.ufrj.dcc.gerencia.domain.base.LCIModel;

/**
 * Created by fausto on 4/10/16.
 */
public class User extends LCIModel{
  private String dn;
  private Integer limitHDSpace;
  private String login;
  private String password;
  private String SambaLMPassword;
  private String SambaNTPassword;

  public String getSambaLMPassword() {
    return SambaLMPassword;
  }

  public void setSambaLMPassword(String sambaLMPassword) {
    SambaLMPassword = sambaLMPassword;
  }

  public String getSambaNTPassword() {
    return SambaNTPassword;
  }

  public void setSambaNTPassword(String sambaNTPassword) {
    SambaNTPassword = sambaNTPassword;
  }

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
    setId(login);
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

  public String getDn() {
    return dn;
  }

  public void setDn(String dn) {
    this.dn = dn;
  }

  @Override
  public String toString() {
    return "User{" +
      "limitHDSpace=" + limitHDSpace +
      ", login='" + login + '\'' +
      ", password='" + password + '\'' +
      ", lci='" + super.toString() + '\'' +
      '}';
  }
}

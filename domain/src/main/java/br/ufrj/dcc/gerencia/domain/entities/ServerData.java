package br.ufrj.dcc.gerencia.domain.entities;

/**
 * Created by fausto on 4/10/16.
 */
public class ServerData {
  private String homeDirectory;
  private String loginShellApplication;
  private Integer gidNumber;
  private Integer uidNumber;
  private String gecos;

  public ServerData(String homeDirectory, String loginShellApplication, Integer gidNumber, Integer uidNumber, String gecos) {
    this.homeDirectory = homeDirectory;
    this.loginShellApplication = loginShellApplication;
    this.gidNumber = gidNumber;
    this.uidNumber = uidNumber;
    this.gecos = gecos;
  }

  public ServerData() {
  }

  public String getHomeDirectory() {
    return homeDirectory;
  }

  public void setHomeDirectory(String homeDirectory) {
    this.homeDirectory = homeDirectory;
  }

  public String getLoginShellApplication() {
    return loginShellApplication;
  }

  public void setLoginShellApplication(String loginShellApplication) {
    this.loginShellApplication = loginShellApplication;
  }

  public Integer getGidNumber() {
    return gidNumber;
  }

  public void setGidNumber(Integer gidNumber) {
    this.gidNumber = gidNumber;
  }

  public Integer getUidNumber() {
    return uidNumber;
  }

  public void setUidNumber(Integer uidNumber) {
    this.uidNumber = uidNumber;
  }

  public String getGecos() {
    return gecos;
  }

  public void setGecos(String gecos) {
    this.gecos = gecos;
  }
}

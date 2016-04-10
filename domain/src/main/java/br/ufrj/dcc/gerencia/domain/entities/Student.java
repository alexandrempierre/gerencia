package br.ufrj.dcc.gerencia.domain.entities;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;

/**
 * Created by fausto on 4/10/16.
 */

public class Student extends LCIModel {

  private User user;
  private Person person;
  private ServerData serverData;
  private SambaObj samba;
  private ShadowObj shadow;

  private String DRE;
  private boolean operator;

  public Student() {
    user = new User();
    person = new Person();
    serverData = new ServerData();
    samba = new SambaObj();
    shadow = new ShadowObj();
  }

  public Student(User user, Person person, ServerData serverData, SambaObj samba, ShadowObj shadow, String DRE) {
    this.user = user;
    this.person = person;
    this.serverData = serverData;
    this.samba = samba;
    this.shadow = shadow;
    this.DRE = DRE;
    setId(user.getLogin());
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
    this.setId(user.getLogin());
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public ServerData getServerData() {
    return serverData;
  }

  public void setServerData(ServerData serverData) {
    this.serverData = serverData;
  }

  public SambaObj getSamba() {
    return samba;
  }

  public void setSamba(SambaObj samba) {
    this.samba = samba;
  }

  public ShadowObj getShadow() {
    return shadow;
  }

  public void setShadow(ShadowObj shadow) {
    this.shadow = shadow;
  }

  public String getDRE() {
    return DRE;
  }

  public void setDRE(String DRE) {
    this.DRE = DRE;
  }

  public boolean isOperator() {
    return operator;
  }

  public void setOperator(boolean operator) {
    this.operator = operator;
  }
}

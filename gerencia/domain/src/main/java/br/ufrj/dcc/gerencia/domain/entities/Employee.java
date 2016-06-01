package br.ufrj.dcc.gerencia.domain.entities;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;

/**
 * Created by fausto on 5/24/16.
 */
public class Employee  extends LCIModel {
  private User user;
  private Person person;
  private ServerData serverData;
  private SambaObj samba;
  private ShadowObj shadow;

  public Employee() {
    user = new User();
    person = new Person();
    serverData = new ServerData();
    samba = new SambaObj();
    shadow = new ShadowObj();
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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

  @Override
  public String toString() {
    return "Employee{" +
      "user=" + user +
      ", person=" + person +
      ", serverData=" + serverData +
      ", samba=" + samba +
      ", shadow=" + shadow +
      '}';
  }
}

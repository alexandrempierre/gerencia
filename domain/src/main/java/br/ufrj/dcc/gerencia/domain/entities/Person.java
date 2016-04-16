package br.ufrj.dcc.gerencia.domain.entities;

/**
 * Created by fausto on 4/10/16.
 */
public class Person {
  private String name;
  private String surname;
  private String externMail;
  private String phoneNumber;
  private String displayName;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getExternMail() {
    return externMail;
  }

  public void setExternMail(String externMail) {
    this.externMail = externMail;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @Override
  public String toString() {
    return "Person{" +
      "name='" + name + '\'' +
      ", surname='" + surname + '\'' +
      ", externMail='" + externMail + '\'' +
      ", phoneNumber='" + phoneNumber + '\'' +
      ", displayName='" + displayName + '\'' +
      '}';
  }
}

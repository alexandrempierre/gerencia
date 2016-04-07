package br.ufrj.dcc.gerencia.domain.base;

import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.ldap.odm.annotations.Transient;

import javax.naming.Name;

/**
 * Created by fausto on 4/3/16.
 */


public class LCIModel {

  @Transient
  private boolean saved;

  @Id
  private Name dn;

  @DnAttribute(value = "uid", index = 1)
  private String uid;

  public boolean isSaved() {
    return saved;
  }

  public void setSaved(boolean saved) {
    this.saved = saved;
  }

  public Name getDn() {
    return dn;
  }

  public void setDn(Name dn) {
    this.dn = dn;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }
}

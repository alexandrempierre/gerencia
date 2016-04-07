package br.ufrj.dcc.gerencia.domain.base;

/**
 * Created by fausto on 4/3/16.
 */
public class LCIModel {

  private String uid;

  private boolean saved;

  public boolean isSaved() {
    return saved;
  }

  public void setSaved(boolean saved) {
    this.saved = saved;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }
}

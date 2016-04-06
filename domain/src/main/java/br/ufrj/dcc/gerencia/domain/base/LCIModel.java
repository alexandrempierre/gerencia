package br.ufrj.dcc.gerencia.domain.base;

/**
 * Created by fausto on 4/3/16.
 */
public class LCIModel {

  private int id;

  private boolean saved;

  public boolean isSaved() {
    return saved;
  }

  public void setSaved(boolean saved) {
    this.saved = saved;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}

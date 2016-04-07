package br.ufrj.dcc.gerencia.domain.base;

import javax.naming.Name;

/**
 * Created by fausto on 4/3/16.
 */

public abstract class LCIModel {

  public LCIModel() {}

  private boolean saved;

  public boolean isSaved() {
    return saved;
  }
  public void setSaved(boolean saved) {
    this.saved = saved;
  }

  public abstract String getIdentify();

}

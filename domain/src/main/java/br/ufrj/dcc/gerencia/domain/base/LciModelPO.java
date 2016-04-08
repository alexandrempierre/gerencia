package br.ufrj.dcc.gerencia.domain.base;

/**
 * Created by fausto on 4/7/16.
 */
public abstract class LciModelPO<M extends LCIModel> {

  private boolean saved;

  public boolean isSaved() {
    return saved;
  }

  public void setSaved(boolean saved) {
    this.saved = saved;
  }

  public abstract M toModel();

}
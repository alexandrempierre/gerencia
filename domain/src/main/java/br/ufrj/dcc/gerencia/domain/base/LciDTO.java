package br.ufrj.dcc.gerencia.domain.base;

/**
 * Created by fausto on 4/7/16.
 */
public abstract class LciDTO<M extends LCIModel> {

  public abstract void populate(M register);

}

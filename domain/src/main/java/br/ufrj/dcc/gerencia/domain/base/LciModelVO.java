package br.ufrj.dcc.gerencia.domain.base;

/**
 * Created by fausto on 4/7/16.
 */

public interface LciModelVO<M extends LCIModel> {
  M toModel();
}

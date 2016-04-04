package br.ufrj.dcc.irepository.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;

/**
 * Created by fausto on 4/3/16.
 */
public interface IRepository<M extends LCIModel>{
  int save(M register);
  //query(specification)
  M get(int id);
}

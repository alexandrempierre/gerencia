package br.ufrj.dcc.gerencia.repository.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.irepository.base.IRepository;

/**
 * Created by fausto on 4/3/16.
 */
public class Repository<M extends LCIModel> implements IRepository<M>{

  public int save(M register) {
    return 0;
  }

  public M get(int id) {
    return null;
  }
}

package br.ufrj.dcc.gerencia.repository.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/3/16.
 */

@Component
public abstract class RepositoryImpl<M extends LCIModel> implements Repository<M> {

  public int save(M register) {
    return 42;
  }

  public M get(int id) {
    return null;
  }
}

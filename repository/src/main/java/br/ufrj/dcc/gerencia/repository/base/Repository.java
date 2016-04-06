package br.ufrj.dcc.gerencia.repository.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciSpecification;

import java.util.List;

/**
 * Created by fausto on 4/3/16.
 */
public interface Repository<M extends LCIModel, Spec extends LciSpecification>{
  M save(M register);
  List<M> query(Spec specification);
  M get(String uid);
  M delete(String uid);
}

package br.ufrj.dcc.gerencia.business.interfaces;

import br.ufrj.dcc.gerencia.domain.entities.User;

/**
 * Created by fausto on 4/14/16.
 */
public interface IUserOperation {
  boolean existsLogin(User user);
  void alterPassword(User user);
}

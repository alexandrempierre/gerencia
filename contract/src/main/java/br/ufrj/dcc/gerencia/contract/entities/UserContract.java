package br.ufrj.dcc.gerencia.contract.entities;

import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.entities.User;

/**
 * Created by fausto on 4/16/16.
 */
public interface UserContract extends CrudRestAPIContract<User,LciLdapSpecification> {

  void authenticate(String login, String password);
}
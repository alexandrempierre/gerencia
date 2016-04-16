package br.ufrj.dcc.gerencia.repository.contract;

import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.entities.User;
import br.ufrj.dcc.gerencia.repository.base.Repository;

/**
 * Created by fausto on 4/16/16.
 */

public interface UserRepository extends Repository<User,LciLdapSpecification>{
}

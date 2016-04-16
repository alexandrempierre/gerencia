package br.ufrj.dcc.gerencia.service.entities;

import br.ufrj.dcc.gerencia.business.entities.UserFacade;
import br.ufrj.dcc.gerencia.contract.entities.UserContract;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.entities.User;
import br.ufrj.dcc.gerencia.repository.contract.UserRepository;
import br.ufrj.dcc.gerencia.service.base.CrudRestAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fausto on 4/16/16.
 */

@RestController
@RequestMapping("/api/user")
public class UserAPI extends CrudRestAPI<User, LciLdapSpecification, UserFacade, UserRepository> implements UserContract{

}

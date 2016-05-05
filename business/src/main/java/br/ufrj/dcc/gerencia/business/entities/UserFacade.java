package br.ufrj.dcc.gerencia.business.entities;

import br.ufrj.dcc.gerencia.business.base.CrudFacade;
import br.ufrj.dcc.gerencia.business.util.PasswordUtil;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.entities.User;
import br.ufrj.dcc.gerencia.repository.contract.UserRepository;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/10/16.
 */

@Component
public class UserFacade extends CrudFacade<User,LciLdapSpecification,UserRepository> {

  @Override
  public User save(User register) {
    populate(register);
    return super.save(register);
  }

  public void populate(User register){
    hashSambaPassword(register);
    hashPassword(register);
  }

  public void hashSambaPassword(User register){
    register.setSambaNTPassword(PasswordUtil.ntPasswordHash(register.getPassword()));
    register.setSambaLMPassword(PasswordUtil.lmPasswordHash(register.getPassword()));
  }

  public void hashPassword(User register){
    register.setPassword(PasswordUtil.passowordHash(register.getPassword()));
  }

  public void authenticate(String login, String password){
    getRepository().authenticate(login,password);
  }
}

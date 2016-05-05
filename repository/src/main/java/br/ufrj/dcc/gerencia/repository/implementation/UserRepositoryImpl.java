package br.ufrj.dcc.gerencia.repository.implementation;

import br.ufrj.dcc.gerencia.dataaccess.entities.UserLDAPDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.UserLdapMapper;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.entities.User;
import br.ufrj.dcc.gerencia.domain.specification.AuthenticateSpecification;
import br.ufrj.dcc.gerencia.domain.specification.UserGetSpecification;
import br.ufrj.dcc.gerencia.repository.base.RepositoryImpl;
import br.ufrj.dcc.gerencia.repository.contract.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ldap.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fausto on 4/16/16.
 */

@Component
public class UserRepositoryImpl extends
  RepositoryImpl<User, UserLdapMapper,UserLDAPDataAccess,LciLdapSpecification> implements UserRepository {

  @Override
  public User get(String uid) {
    LciLdapSpecification userGetSpecification = new UserGetSpecification(uid);
    List<User> resultQuery = query(userGetSpecification);
    if(resultQuery.size() > 0){
      return resultQuery.get(0);
    }else{
      return null;
    }
  }

  public void authenticate(String login, String password){
    LciLdapSpecification userGetSpecification = new AuthenticateSpecification(login);
    try {
      getDataAccess().authenticate(userGetSpecification, password);
    }catch (EmptyResultDataAccessException e){ //empty result
      throw new AuthenticationException();
    }
  }

}

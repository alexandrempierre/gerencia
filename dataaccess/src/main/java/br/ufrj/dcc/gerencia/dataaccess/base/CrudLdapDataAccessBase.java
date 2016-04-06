package br.ufrj.dcc.gerencia.dataaccess.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by fausto on 4/5/16.
 */

@Component
public abstract class CrudLdapDataAccessBase<M extends LCIModel> {

  @Autowired
  private LdapTemplate ldapTemplate;

  public M insert(M register) {
    ldapTemplate.create(register);
    return register;
  }

  public M get(LciLdapSpecification specification) {
    return ldapTemplate.findOne(specification.toQuery(), getModelTypeClass());
  }

  public M get(LdapQuery query) {
    return ldapTemplate.findOne(query, getModelTypeClass());
  }

  public void update(M M) {
    ldapTemplate.update(M);
  }

  public void delete(M M) {
    ldapTemplate.delete(M);
  }

  public List<M> list(LciLdapSpecification specification) {
    return ldapTemplate.find(specification.toQuery(), getModelTypeClass());
  }

  private Class<M> getModelTypeClass(){
    ParameterizedType parameterizedType = (ParameterizedType) getClass()
      .getGenericSuperclass();
    @SuppressWarnings("unchecked")
    Class<M> ret = (Class<M>) parameterizedType.getActualTypeArguments()[0];
    return ret;
  }

}

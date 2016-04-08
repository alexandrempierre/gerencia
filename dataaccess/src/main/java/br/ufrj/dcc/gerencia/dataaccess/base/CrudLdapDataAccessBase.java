package br.ufrj.dcc.gerencia.dataaccess.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.base.LciModelPO;
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
public abstract class CrudLdapDataAccessBase<PO extends LciModelPO> {

  @Autowired
  private LdapTemplate ldapTemplate;

  public PO insert(PO register) {
    ldapTemplate.create(register);
    return register;
  }

  public PO get(LciLdapSpecification specification) {
    return ldapTemplate.findOne(specification.toQuery(), getModelTypeClass());
  }

  public PO get(LdapQuery query) {
    return ldapTemplate.findOne(query, getModelTypeClass());
  }

  public void update(PO M) {
    ldapTemplate.update(M);
  }

  public void delete(PO M) {
    ldapTemplate.delete(M);
  }

  public List<PO> list(LciLdapSpecification specification) {
    return ldapTemplate.find(specification.toQuery(), getModelTypeClass());
  }

  private Class<PO> getModelTypeClass(){
    ParameterizedType parameterizedType = (ParameterizedType) getClass()
      .getGenericSuperclass();
    @SuppressWarnings("unchecked")
    Class<PO> ret = (Class<PO>) parameterizedType.getActualTypeArguments()[0];
    return ret;
  }

}

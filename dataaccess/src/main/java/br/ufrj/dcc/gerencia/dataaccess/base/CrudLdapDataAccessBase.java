package br.ufrj.dcc.gerencia.dataaccess.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.base.LciModelPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

  protected LdapTemplate getLdapTemplate() {
    return ldapTemplate;
  }

  protected void setLdapTemplate(LdapTemplate ldapTemplate) {
    this.ldapTemplate = ldapTemplate;
  }

  protected Class<PO> getModelTypeClass(){
    ParameterizedType parameterizedType = (ParameterizedType) getClass()
      .getGenericSuperclass();
    @SuppressWarnings("unchecked")
    Class<PO> ret = (Class<PO>) parameterizedType.getActualTypeArguments()[0];
    return ret;
  }

  protected List<PO> find(LdapQuery query){
    try {
      return getLdapTemplate().find(query, getModelTypeClass());
    }catch (EmptyResultDataAccessException e){
      return null;
    }
  }

  protected List<PO> find(LciLdapSpecification specification){
    try {
      return getLdapTemplate().find(specification.toQuery(), getModelTypeClass());
    }catch (EmptyResultDataAccessException e){
      return null;
    }
  }

  protected PO findOne(LdapQuery query){
    try {
      return getLdapTemplate().findOne(query, getModelTypeClass());
    }catch (EmptyResultDataAccessException e){
      return null;
    }
  }

  protected PO findOne(LciLdapSpecification specification){
    try {
      return getLdapTemplate().findOne(specification.toQuery(), getModelTypeClass());
    }catch (EmptyResultDataAccessException e){
      return null;
    }
  }

}

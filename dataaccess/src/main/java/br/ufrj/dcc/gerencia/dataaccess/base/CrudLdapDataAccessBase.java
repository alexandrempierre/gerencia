package br.ufrj.dcc.gerencia.dataaccess.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Component;

import javax.naming.Name;
import java.util.List;

/**
 * Created by fausto on 4/15/16.
 */

@Component
public abstract class CrudLdapDataAccessBase<M extends LCIModel, Mapper extends LCIAbstractContextMapper<M>>{

  @Autowired
  protected LdapTemplate ldapTemplate;

  @Autowired
  protected Mapper mapper;

  public void create(M register, Name dn) {
    DirContextAdapter context = new DirContextAdapter(dn);
    mapper.mapInsertToContext(register, context);
    ldapTemplate.bind(context);
  }

  public void update(M register, Name dn) {
    DirContextOperations context = ldapTemplate.lookupContext(dn);
    mapper.mapEditToContext(register, context);
    ldapTemplate.modifyAttributes(context);
  }

  public void update(M register, String dn) {
    DirContextOperations context = ldapTemplate.lookupContext(dn);
    mapper.mapEditToContext(register, context);
    ldapTemplate.modifyAttributes(context);
  }

  public M findByKey(Name dn){
    return ldapTemplate.lookup(dn, mapper);
  }

  public List<M> find(LciLdapSpecification specification, Name dnBase){
    return ldapTemplate.search(specification.toQuery(dnBase), mapper);
  }

}


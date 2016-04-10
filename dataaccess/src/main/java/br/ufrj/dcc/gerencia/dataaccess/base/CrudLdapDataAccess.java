/**
 * Created by fausto on 4/5/16.
 */
package br.ufrj.dcc.gerencia.dataaccess.base;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;

import javax.naming.Name;
import java.util.List;

@Component
public abstract class CrudLdapDataAccess<M extends LCIModel, Mapper extends LCIAbstractContextMapper<M>>{

  protected final String DEFAULT_PRIMARY_KEY = "uid";

  @Autowired
  protected LdapTemplate ldapTemplate;

  @Autowired
  protected Mapper mapper;

  protected Name buildDnByKey(String key){
    return getBaseDN(LdapNameBuilder.newInstance()).add(DEFAULT_PRIMARY_KEY, key).build();
  }

  protected Name getBaseName(){
    return getBaseDN(LdapNameBuilder.newInstance()).build();
  }

  public void delete(String key) {
    ldapTemplate.unbind(buildDnByKey(key));
  }

  public void create(M register) {
    DirContextAdapter context = new DirContextAdapter(buildDnByKey(register.getId()));
    mapper.mapInsertToContext(register, context);
    ldapTemplate.bind(context);
  }

  public void update(M register) {
    Name dn = buildDnByKey(register.getId());
    DirContextOperations context = ldapTemplate.lookupContext(dn);
    mapper.mapEditToContext(register, context);
    ldapTemplate.modifyAttributes(context);
  }

  public M findByKey(String key) {
    Name dn = buildDnByKey(key);
    return ldapTemplate.lookup(dn, mapper);
  }

  public List<M> find(LciLdapSpecification specification){
    return ldapTemplate.search(specification.toQuery(getBaseName()), mapper);
  }

  protected abstract LdapNameBuilder getBaseDN(LdapNameBuilder instance);
}

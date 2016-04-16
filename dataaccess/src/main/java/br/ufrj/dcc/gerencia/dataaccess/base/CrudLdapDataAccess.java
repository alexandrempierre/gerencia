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
public abstract class CrudLdapDataAccess<M extends LCIModel, Mapper extends LCIAbstractContextMapper<M>> extends CrudLdapDataAccessBase<M,Mapper>{

  protected final String DEFAULT_PRIMARY_KEY = "uid";

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
    create(register, buildDnByKey(register.getId()));
  }

  public void update(M register) {
    Name dn = buildDnByKey(register.getId());
    update(register, dn);
  }

  public M findByKey(String key) {
    Name dn = buildDnByKey(key);
    return findByKey(dn);
  }

  public List<M> find(LciLdapSpecification specification){
    return find(specification, getBaseName());
  }

  protected abstract LdapNameBuilder getBaseDN(LdapNameBuilder instance);
}

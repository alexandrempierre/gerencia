package br.ufrj.dcc.gerencia.dataaccess.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.base.LciModelPO;
import org.springframework.ldap.query.LdapQuery;

import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created by fausto on 4/6/16.
 */
public class CrudLdapDataAccess<PO extends LciModelPO> extends CrudLdapDataAccessBase<PO> {

  public PO getByUid(String uid) {
    return get(query().where("uid").is(uid));
  }

  public PO insert(PO register) {
    getLdapTemplate().create(register);
    return register;
  }

  public PO get(LciLdapSpecification specification) {
    return findOne(specification);
  }

  public PO get(LdapQuery query) {
    return findOne(query);
  }

  public void update(PO M) {
    getLdapTemplate().update(M);
  }

  public void delete(PO M) {
    getLdapTemplate().delete(M);
  }

  public List<PO> list(LciLdapSpecification specification) {
    return find(specification);
  }

  public List<PO> list(LdapQuery query){
    return find(query);
  }

}

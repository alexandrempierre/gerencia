package br.ufrj.dcc.gerencia.dataaccess.base;

import br.ufrj.dcc.gerencia.domain.base.LCIModel;
import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import br.ufrj.dcc.gerencia.domain.base.LciModelPO;

import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created by fausto on 4/6/16.
 */
public class CrudLdapDataAccess<PO extends LciModelPO> extends CrudLdapDataAccessBase<PO> {

  public PO getByUid(String uid) {
    return super.get(query().where("uid").is(uid));
  }

}

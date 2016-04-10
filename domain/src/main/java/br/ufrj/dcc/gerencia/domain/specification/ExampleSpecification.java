package br.ufrj.dcc.gerencia.domain.specification;

import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import org.springframework.ldap.query.LdapQuery;

import javax.naming.Name;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created by fausto on 4/7/16.
 */
public class ExampleSpecification extends LciLdapSpecification {

  private String uid;

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  @Override
  public LdapQuery toQuery(Name base) {
    return query().base(base).where("uid").is(uid);
  }
}

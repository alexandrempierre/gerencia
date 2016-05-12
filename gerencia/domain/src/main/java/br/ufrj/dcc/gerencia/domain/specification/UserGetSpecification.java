package br.ufrj.dcc.gerencia.domain.specification;

import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import org.springframework.ldap.query.LdapQuery;

import javax.naming.Name;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created by fausto on 4/16/16.
 */
public class UserGetSpecification extends LciLdapSpecification{

  private String uid;

  public UserGetSpecification(String uid) {
    this.uid = uid;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public UserGetSpecification() {

  }

  @Override
  public LdapQuery toQuery(Name baseName) {
    return query().base(baseName).where("uid").is(uid);
  }
}

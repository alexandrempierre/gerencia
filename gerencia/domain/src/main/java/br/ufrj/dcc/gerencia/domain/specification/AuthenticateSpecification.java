package br.ufrj.dcc.gerencia.domain.specification;

import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.LikeFilter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;

import javax.naming.Name;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created by fausto on 5/5/16.
 */
public class AuthenticateSpecification extends LciLdapSpecification {

  private String uid;

  public AuthenticateSpecification(String uid) {
    this.uid = uid;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public LdapQuery toQuery(Name baseName) {
    LdapQueryBuilder queryBuilder = query().base(baseName);
    AndFilter andFilter = new AndFilter();
    andFilter.and(new LikeFilter("uid", "*"+uid+"*"));
    andFilter.and(new EqualsFilter("monitor", "1"));
    return queryBuilder.filter(andFilter);
  }
}

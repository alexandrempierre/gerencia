package br.ufrj.dcc.gerencia.domain.specification;

import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.GreaterThanOrEqualsFilter;
import org.springframework.ldap.filter.LessThanOrEqualsFilter;
import org.springframework.ldap.filter.LikeFilter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;

import javax.naming.Name;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created by fausto on 4/10/16.
 */
public class StudentSpecification extends UserBaseSpecification{
  private String dre;

  public String getDre() {
    return dre;
  }

  public void setDre(String dre) {
    this.dre = dre;
  }

  @Override
  protected void makeFilter(AndFilter filter) {
    if(dre != null && dre.length() > 0){
      filter.and(new LikeFilter("dre", "*"+dre+"*"));
    }
  }

}

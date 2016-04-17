package br.ufrj.dcc.gerencia.domain.specification;

import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.LikeFilter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;

import javax.naming.Name;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created by fausto on 4/17/16.
 */
public abstract class UserBaseSpecification extends LciLdapSpecification {
  private String uid;
  private String name;
  private String surname;

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Override
  public LdapQuery toQuery(Name base) {
    LdapQueryBuilder queryBuilder = query().base(base);
    AndFilter andFilter = new AndFilter();

    //Para garantir que todos os usuario apareçam
    andFilter.and(new LikeFilter("uid", "*"));

    if(uid != null && uid.length() > 0){
      andFilter.and(new LikeFilter("uid", "*"+uid+"*"));
    }

    if(name != null && name.length() > 0){
      andFilter.and(new LikeFilter("cn", "*"+name+"*"));
    }

    if(surname != null && surname.length() > 0){
      andFilter.and(new LikeFilter("sn", "*"+surname+"*"));
    }

    makeFilter(andFilter);

    return queryBuilder.filter(andFilter);
  }

  protected abstract void makeFilter(AndFilter filter);
}

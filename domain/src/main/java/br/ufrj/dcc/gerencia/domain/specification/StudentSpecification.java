package br.ufrj.dcc.gerencia.domain.specification;

import br.ufrj.dcc.gerencia.domain.base.LciLdapSpecification;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.LikeFilter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;

import javax.naming.Name;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Created by fausto on 4/10/16.
 */
public class StudentSpecification extends LciLdapSpecification{
  private String uid;
  private String name;
  private String surname;
  private String dre;
  private Long from;
  private Long to;
  private Boolean expired; //TODO: add this filter

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

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getDre() {
    return dre;
  }

  public void setDre(String dre) {
    this.dre = dre;
  }

  public Long getFrom() {
    return from;
  }

  public void setFrom(Long from) {
    this.from = from;
  }

  public Long getTo() {
    return to;
  }

  public void setTo(Long to) {
    this.to = to;
  }

  public Boolean getExpired() {
    return expired;
  }

  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  @Override
  public LdapQuery toQuery(Name base) {
    LdapQueryBuilder queryBuilder = query().base(base);
    AndFilter andFilter = new AndFilter();

    //Para garantir que todos os usuario apareçam
    andFilter.and(new LikeFilter("uid", "*"));

    if(uid != null && uid.length() > 0){
      System.out.println("uid("+uid.length()+"): "+uid);
      andFilter.and(new LikeFilter("uid", "*"+uid+"*"));
    }

    if(name != null && name.length() > 0){
      System.out.println("cn("+name.length()+"): "+name);
      andFilter.and(new LikeFilter("cn", "*"+name+"*"));
    }

    if(surname != null && surname.length() > 0){
      System.out.println("sn("+surname.length()+"): "+surname);
      andFilter.and(new LikeFilter("sn", "*"+surname+"*"));
    }

    if(dre != null && dre.length() > 0){
      System.out.println("dre("+dre.length()+"): "+dre);
      andFilter.and(new LikeFilter("dre", "*"+dre+"*"));
    }

    if(to != null && to > 0){
      //TODO: fazer o filtro aqui
    }

    if(from != null && from > 0){
      //TODO: fazer o filtro aqui
    }

    return queryBuilder.filter(andFilter);
  }
}

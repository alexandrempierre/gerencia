package br.ufrj.dcc.gerencia.domain.specification;

import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.LikeFilter;

/**
 * Created by fausto on 5/31/16.
 */
public class EmployeeSpecification extends UserBaseSpecification{
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
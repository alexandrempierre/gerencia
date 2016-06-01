package br.ufrj.dcc.gerencia.dataaccess.entities;

import br.ufrj.dcc.gerencia.dataaccess.base.CrudLdapDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.EmployeeLdapMapper;
import br.ufrj.dcc.gerencia.domain.entities.Employee;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 5/31/16.
 */

@Component
public class EmployeeLDAPDataAccess  extends CrudLdapDataAccess<Employee, EmployeeLdapMapper> {

  @Override
  protected LdapNameBuilder getBaseDN(LdapNameBuilder instance) {
    return instance
      .add("ou","usuarios")
      .add("ou","funcionarios");
  }
}
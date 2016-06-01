package br.ufrj.dcc.gerencia.repository.implementation;

import br.ufrj.dcc.gerencia.dataaccess.entities.EmployeeLDAPDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.EmployeeLdapMapper;
import br.ufrj.dcc.gerencia.domain.entities.Employee;
import br.ufrj.dcc.gerencia.domain.specification.EmployeeSpecification;
import br.ufrj.dcc.gerencia.repository.base.RepositoryImpl;
import br.ufrj.dcc.gerencia.repository.contract.EmployeeRepository;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 5/31/16.
 */

@Component
public class EmployeeRepositoryImpl  extends
  RepositoryImpl<Employee, EmployeeLdapMapper,EmployeeLDAPDataAccess,EmployeeSpecification> implements EmployeeRepository {
}

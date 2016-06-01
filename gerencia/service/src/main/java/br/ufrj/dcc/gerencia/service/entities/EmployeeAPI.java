package br.ufrj.dcc.gerencia.service.entities;

import br.ufrj.dcc.gerencia.business.entities.EmployeeFacade;
import br.ufrj.dcc.gerencia.contract.entities.EmployeeContract;
import br.ufrj.dcc.gerencia.domain.entities.Employee;
import br.ufrj.dcc.gerencia.domain.specification.EmployeeSpecification;
import br.ufrj.dcc.gerencia.repository.contract.EmployeeRepository;
import br.ufrj.dcc.gerencia.service.base.CrudRestAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fausto on 5/31/16.
 */

@RestController
@RequestMapping("/api/employee")
public class EmployeeAPI extends
  CrudRestAPI<Employee, EmployeeSpecification, EmployeeFacade, EmployeeRepository> implements EmployeeContract {
}

package br.ufrj.dcc.gerencia.contract.entities;

import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import br.ufrj.dcc.gerencia.domain.entities.Employee;
import br.ufrj.dcc.gerencia.domain.specification.EmployeeSpecification;

/**
 * Created by fausto on 5/31/16.
 */

public interface EmployeeContract extends CrudRestAPIContract<Employee,EmployeeSpecification> {}

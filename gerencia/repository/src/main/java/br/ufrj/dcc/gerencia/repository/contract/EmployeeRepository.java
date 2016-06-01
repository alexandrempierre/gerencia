package br.ufrj.dcc.gerencia.repository.contract;

import br.ufrj.dcc.gerencia.domain.entities.Employee;
import br.ufrj.dcc.gerencia.domain.specification.EmployeeSpecification;
import br.ufrj.dcc.gerencia.repository.base.Repository;

/**
 * Created by fausto on 5/31/16.
 */
public interface EmployeeRepository extends Repository<Employee,EmployeeSpecification>{}

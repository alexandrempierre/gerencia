package br.ufrj.dcc.gerencia.contract.entities;

import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import br.ufrj.dcc.gerencia.domain.entities.Student;
import br.ufrj.dcc.gerencia.domain.specification.StudentSpecification;

/**
 * Created by fausto on 4/10/16.
 */
public interface StudentContract extends CrudRestAPIContract<Student,StudentSpecification> {}
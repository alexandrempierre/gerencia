package br.ufrj.dcc.gerencia.contract.entities;

import br.ufrj.dcc.gerencia.contract.base.CrudRestAPIContract;
import br.ufrj.dcc.gerencia.domain.entities.Teacher;
import br.ufrj.dcc.gerencia.domain.specification.TeacherSpecification;

/**
 * Created by fausto on 4/17/16.
 */
public interface TeacherContract extends CrudRestAPIContract<Teacher,TeacherSpecification> {
}

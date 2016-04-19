package br.ufrj.dcc.gerencia.repository.contract;

import br.ufrj.dcc.gerencia.domain.entities.Teacher;
import br.ufrj.dcc.gerencia.domain.specification.TeacherSpecification;
import br.ufrj.dcc.gerencia.repository.base.Repository;

/**
 * Created by fausto on 4/17/16.
 */
public interface TeacherRepository extends Repository<Teacher, TeacherSpecification> {
}

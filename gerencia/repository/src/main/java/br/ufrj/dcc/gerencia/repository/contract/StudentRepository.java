package br.ufrj.dcc.gerencia.repository.contract;

import br.ufrj.dcc.gerencia.domain.entities.Student;
import br.ufrj.dcc.gerencia.domain.specification.StudentSpecification;
import br.ufrj.dcc.gerencia.repository.base.Repository;

/**
 * Created by fausto on 4/10/16.
 */
public interface StudentRepository extends Repository<Student, StudentSpecification> {

}

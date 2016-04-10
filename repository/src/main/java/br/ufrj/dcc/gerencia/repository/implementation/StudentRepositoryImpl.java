package br.ufrj.dcc.gerencia.repository.implementation;

import br.ufrj.dcc.gerencia.dataaccess.entities.StudentLDAPDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.StudentLdapMapper;
import br.ufrj.dcc.gerencia.domain.entities.Student;
import br.ufrj.dcc.gerencia.domain.specification.StudentSpecification;
import br.ufrj.dcc.gerencia.repository.base.RepositoryImpl;
import br.ufrj.dcc.gerencia.repository.contract.StudentRepository;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/10/16.
 */

@Component
public class StudentRepositoryImpl extends
  RepositoryImpl<Student,StudentLdapMapper,StudentLDAPDataAccess,StudentSpecification> implements StudentRepository {
}

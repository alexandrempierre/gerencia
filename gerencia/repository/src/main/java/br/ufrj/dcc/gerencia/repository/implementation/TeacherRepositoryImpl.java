package br.ufrj.dcc.gerencia.repository.implementation;

import br.ufrj.dcc.gerencia.dataaccess.entities.TeacherLDAPDataAccess;
import br.ufrj.dcc.gerencia.dataaccess.mapper.TeacherLdapMapper;
import br.ufrj.dcc.gerencia.domain.entities.Teacher;
import br.ufrj.dcc.gerencia.domain.specification.TeacherSpecification;
import br.ufrj.dcc.gerencia.repository.base.RepositoryImpl;
import br.ufrj.dcc.gerencia.repository.contract.TeacherRepository;
import org.springframework.stereotype.Component;


/**
 * Created by fausto on 4/17/16.
 */

@Component
public class TeacherRepositoryImpl extends RepositoryImpl<Teacher, TeacherLdapMapper, TeacherLDAPDataAccess, TeacherSpecification> implements TeacherRepository{

}

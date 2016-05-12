package br.ufrj.dcc.gerencia.service.entities;

import br.ufrj.dcc.gerencia.business.entities.TeacherFacade;
import br.ufrj.dcc.gerencia.contract.entities.TeacherContract;
import br.ufrj.dcc.gerencia.domain.entities.Teacher;
import br.ufrj.dcc.gerencia.domain.specification.TeacherSpecification;
import br.ufrj.dcc.gerencia.repository.contract.TeacherRepository;
import br.ufrj.dcc.gerencia.service.base.CrudRestAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fausto on 4/17/16.
 */

@RestController
@RequestMapping("/api/teacher")
public class TeacherAPI extends CrudRestAPI<Teacher,TeacherSpecification,TeacherFacade,TeacherRepository> implements TeacherContract{
}

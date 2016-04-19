package br.ufrj.dcc.gerencia.business.businessObjects;

import br.ufrj.dcc.gerencia.business.util.StringUtil;
import br.ufrj.dcc.gerencia.domain.entities.*;
import org.springframework.stereotype.Component;
import br.ufrj.dcc.gerencia.domain.auxiliar.GerenciaDefaultConstraint;

/**
 * Created by fausto on 4/10/16.
 */

@Component
public class ServerDataBO {

  private static void create(ServerData serverData, User user, Person person, Integer uidNumber){
    serverData.setHomeDirectory(String.format(GerenciaDefaultConstraint.HOME_DIRECTORY_STUDENT_TEMPLATE, user.getLogin()));
    serverData.setGecos(StringUtil.removeAccent(person.getName() + " " + person.getSurname()));
    serverData.setLoginShellApplication(GerenciaDefaultConstraint.LOGIN_SHELL);
    serverData.setGidNumber(GerenciaDefaultConstraint.GID_NUMBER);
    serverData.setUidNumber(uidNumber);
  }

  public static ServerData createTeacher(Teacher teacher, Integer uidNumber){
    ServerData serverData = new ServerData();
    create(serverData, teacher.getUser(), teacher.getPerson(), uidNumber);
    return serverData;
  }

  public static ServerData createStudent(Student student, Integer uidNumber) {
    ServerData serverData = new ServerData();
    create(serverData, student.getUser(), student.getPerson(), uidNumber);
    return serverData;
  }

}

package br.ufrj.dcc.gerencia.domain.auxiliar;

/**
 * Created by fausto on 4/14/16.
 */
public class ObjectClassLdap {
  public static final String[] STUDENT_OBJECT_CLASS = new String[] {"dcc","aluno","inetOrgPerson","posixAccount","shadowAccount","sambaSamAccount","person","organizationalPerson","top"};
  public static final String[] SAMBA_INFO_OBJECT_CLASS = new String[] {"top","sambaDomain","sambaUnixIdPool"};
}

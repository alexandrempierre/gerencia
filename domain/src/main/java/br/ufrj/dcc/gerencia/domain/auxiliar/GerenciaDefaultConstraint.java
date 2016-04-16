package br.ufrj.dcc.gerencia.domain.auxiliar;

/**
 * Created by fausto on 4/10/16.
 */
public class GerenciaDefaultConstraint {

  //region ServerData
  public static final Integer GID_NUMBER = 100;
  public static final String LOGIN_SHELL = "/bin/bash";
  public static final String HOME_DIRECTORY_TEMPLATE = "/usuarios/%s";
  public static final String HOME_DIRECTORY_STUDENT_TEMPLATE = String.format(HOME_DIRECTORY_TEMPLATE,"alunos") + "/%s";
  //endregion

  //region Shadow
  public static final Integer SHADOW_FLAG = -1;
  public static final Integer SHADOW_INACTIVE  = -1;
  public static final Integer SHADOW_MAX = 180;
  public static final Integer SHADOW_MIN = 0;
  public static final Integer SHADOW_WARNING = 7;
  public static final Integer SHADOW_NUMBERS_DAY_TO_EXPIRE = 365*6; // quatro anos
  public static final Long ShadowLastChange(Long time){
    return time /  ( 60 * 60 * 24 );
  }
  //endregion

  //region Samba
  public static final String SAMBA_ACCT_FLAGS = "[U          ]";
  public static final String SAMBA_PRIMARY_GROUP_SID_TEMPLATE = "%s-513"; //Gerencia Antigo, concatena -513
  public static final Integer SAMBA_PWD_MUST_CHANGE = (180*60*60*24);
  //endregion

  //region Mail
  public static final String MAIL_TEMPLATE = "%s@dcc.ufrj.br";
  //endregion
}

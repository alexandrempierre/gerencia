package br.ufrj.dcc.gerencia.dataaccess.mapper;

import br.ufrj.dcc.gerencia.dataaccess.base.LCIUserAbstractContextMapper;
import br.ufrj.dcc.gerencia.domain.entities.Example;
import br.ufrj.dcc.gerencia.domain.entities.Teacher;
import org.springframework.ldap.core.DirContextOperations;
import static br.ufrj.dcc.gerencia.domain.auxiliar.ObjectClassLdap.*;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/17/16.
 */

@Component
public class TeacherLdapMapper extends LCIUserAbstractContextMapper<Teacher>{
  @Override
  public void mapperResult(Teacher teacher, DirContextOperations ctx) {
    try {
      teacher.getUser().setLimitHDSpace(new Integer(ctx.getStringAttribute("cota")));
      teacher.getUser().setLogin(ctx.getStringAttribute("uid"));
      teacher.getPerson().setName(ctx.getStringAttribute("cn"));
      teacher.getPerson().setSurname(ctx.getStringAttribute("sn"));
      teacher.getPerson().setExternMail(ctx.getStringAttribute("emailExterno"));
      teacher.getPerson().setPhoneNumber(ctx.getStringAttribute("telephoneNumber"));
      teacher.getPerson().setDisplayName(ctx.getStringAttribute("displayName"));
      teacher.getServerData().setHomeDirectory(ctx.getStringAttribute("homeDirectory"));
      teacher.getServerData().setLoginShellApplication(ctx.getStringAttribute("loginShell"));
      teacher.getServerData().setGidNumber(new Integer(ctx.getStringAttribute("gidNumber")));
      teacher.getServerData().setUidNumber(new Integer(ctx.getStringAttribute("uidNumber")));
      teacher.getServerData().setGecos(ctx.getStringAttribute("gecos"));
      teacher.getSamba().setSambaSID(ctx.getStringAttribute("sambaSID"));
      teacher.getSamba().setSambaAcctFlags(ctx.getStringAttribute("sambaAcctFlags"));
      teacher.getSamba().setSambaKickoffTime(new Long(ctx.getStringAttribute("sambaKickoffTime")));
      teacher.getSamba().setSambaLMPassword(ctx.getStringAttribute("sambaLMPassword"));
      teacher.getSamba().setSambaNTPassword(ctx.getStringAttribute("sambaNTPassword"));
      teacher.getSamba().setSambaPrimaryGroupSID(ctx.getStringAttribute("sambaPrimaryGroupSID"));
      teacher.getSamba().setSambaPwdCanChange(new Long(ctx.getStringAttribute("sambaPwdCanChange")));
      teacher.getSamba().setSambaPwdLastSet(new Long(ctx.getStringAttribute("sambaPwdLastSet")));
      teacher.getSamba().setSambaPwdMustChange(new Long(ctx.getStringAttribute("sambaPwdMustChange")));
      teacher.getShadow().setShadowExpire(new Long(ctx.getStringAttribute("shadowExpire")));
      teacher.getShadow().setShadowFlag(new Integer(ctx.getStringAttribute("shadowFlag")));
      teacher.getShadow().setShadowInactive(new Integer(ctx.getStringAttribute("shadowInactive")));
      teacher.getShadow().setShadowLastChange(new Long(ctx.getStringAttribute("shadowLastChange")));
      teacher.getShadow().setShadowMax(new Integer(ctx.getStringAttribute("shadowMax")));
      teacher.getShadow().setShadowMin(new Integer(ctx.getStringAttribute("shadowMin")));
      teacher.getShadow().setShadowWarning(new Integer(ctx.getStringAttribute("shadowWarning")));
      teacher.setId(teacher.getUser().getLogin());
      teacher.setOperator(ctx.getStringAttribute("monitor").equals("1"));
    }catch (NullPointerException e){
      e.printStackTrace();
    }
  }

  @Override
  public void mapToContext(Teacher register, DirContextOperations ctx) {
    ctx.setAttributeValues("objectclass", TEACHER_OBJECT_CLASS);

    //TODO: fazer departamento
    ctx.setAttributeValue("departamento", "nothing");

    ctx.setAttributeValue("cota", Integer.toString(register.getUser().getLimitHDSpace()));
    ctx.setAttributeValue("uid", register.getUser().getLogin());
    ctx.setAttributeValue("cn", register.getPerson().getName());
    ctx.setAttributeValue("sn", register.getPerson().getSurname());
    ctx.setAttributeValue("emailExterno", register.getPerson().getExternMail());
    ctx.setAttributeValue("telephoneNumber", register.getPerson().getPhoneNumber());
    ctx.setAttributeValue("displayName", register.getPerson().getDisplayName());
    ctx.setAttributeValue("homeDirectory", register.getServerData().getHomeDirectory());
    ctx.setAttributeValue("loginShell", register.getServerData().getLoginShellApplication());
    ctx.setAttributeValue("gidNumber", Integer.toString(register.getServerData().getGidNumber()));
    ctx.setAttributeValue("uidNumber", Integer.toString(register.getServerData().getUidNumber()));
    ctx.setAttributeValue("gecos", register.getServerData().getGecos());
    ctx.setAttributeValue("sambaSID", register.getSamba().getSambaSID());
    ctx.setAttributeValue("sambaAcctFlags", register.getSamba().getSambaAcctFlags());
    ctx.setAttributeValue("sambaKickoffTime", Long.toString(register.getSamba().getSambaKickoffTime()));
    ctx.setAttributeValue("sambaLMPassword", register.getSamba().getSambaLMPassword());
    ctx.setAttributeValue("sambaNTPassword", register.getSamba().getSambaNTPassword());
    ctx.setAttributeValue("sambaPrimaryGroupSID", register.getSamba().getSambaPrimaryGroupSID());
    ctx.setAttributeValue("sambaPwdCanChange", Long.toString(register.getSamba().getSambaPwdCanChange()));
    ctx.setAttributeValue("sambaPwdLastSet", Long.toString(register.getSamba().getSambaPwdLastSet()));
    ctx.setAttributeValue("sambaPwdMustChange", Long.toString(register.getSamba().getSambaPwdMustChange()));
    ctx.setAttributeValue("shadowExpire", Long.toString(register.getShadow().getShadowExpire()));
    ctx.setAttributeValue("shadowFlag", Integer.toString(register.getShadow().getShadowFlag()));
    ctx.setAttributeValue("shadowInactive", Integer.toString(register.getShadow().getShadowInactive()));
    ctx.setAttributeValue("shadowLastChange", Long.toString(register.getShadow().getShadowLastChange()));
    ctx.setAttributeValue("shadowMax", Integer.toString(register.getShadow().getShadowMax()));
    ctx.setAttributeValue("shadowMin", Integer.toString(register.getShadow().getShadowMin()));
    ctx.setAttributeValue("shadowWarning", Integer.toString(register.getShadow().getShadowWarning()));
    ctx.setAttributeValue("userPassword", register.getUser().getPassword());
    ctx.setAttributeValue("monitor", register.isOperator() ? "1" : "0");
  }
}

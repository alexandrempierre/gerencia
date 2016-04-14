package br.ufrj.dcc.gerencia.dataaccess.mapper;

import br.ufrj.dcc.gerencia.dataaccess.base.LCIAbstractContextMapper;
import br.ufrj.dcc.gerencia.domain.entities.Student;
import static br.ufrj.dcc.gerencia.domain.auxiliar.ObjectClassLdap.*;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.stereotype.Component;

/**
 * Created by fausto on 4/10/16.
 */

@Component
public class StudentLdapMapper extends LCIAbstractContextMapper<Student> {

  @Override
  public void mapperResult(Student student,DirContextOperations ctx) {
    student.getUser().setLimitHDSpace(new Integer(ctx.getStringAttribute("cota")));
    student.getUser().setLogin(ctx.getStringAttribute("uid"));
    student.getPerson().setName(ctx.getStringAttribute("cn"));
    student.getPerson().setSurname(ctx.getStringAttribute("sn"));
    student.getPerson().setExternMail(ctx.getStringAttribute("emailExterno"));
    student.getPerson().setPhoneNumber(ctx.getStringAttribute("telephoneNumber"));
    student.getPerson().setDisplayName(ctx.getStringAttribute("displayName"));
    student.getServerData().setHomeDirectory(ctx.getStringAttribute("homeDirectory"));
    student.getServerData().setLoginShellApplication(ctx.getStringAttribute("loginShell"));
    student.getServerData().setGidNumber(new Integer(ctx.getStringAttribute("gidNumber")));
    student.getServerData().setUidNumber(new Integer(ctx.getStringAttribute("uidNumber")));
    student.getServerData().setGecos(ctx.getStringAttribute("gecos"));
    student.getSamba().setSambaSID(ctx.getStringAttribute("sambaSID"));
    student.getSamba().setSambaAcctFlags(ctx.getStringAttribute("sambaAcctFlags"));
    student.getSamba().setSambaKickoffTime(new Long(ctx.getStringAttribute("sambaKickoffTime")));
    student.getSamba().setSambaLMPassword(ctx.getStringAttribute("sambaLMPassword"));
    student.getSamba().setSambaNTPassword(ctx.getStringAttribute("sambaNTPassword"));
    student.getSamba().setSambaPrimaryGroupSID(ctx.getStringAttribute("sambaPrimaryGroupSID"));
    student.getSamba().setSambaPwdCanChange(new Long(ctx.getStringAttribute("sambaPwdCanChange")));
    student.getSamba().setSambaPwdLastSet(new Long(ctx.getStringAttribute("sambaPwdLastSet")));
    student.getSamba().setSambaPwdMustChange(ctx.getStringAttribute("sambaPwdMustChange"));
    student.getShadow().setShadowExpire(new Long(ctx.getStringAttribute("shadowExpire")));
    student.getShadow().setShadowFlag(new Integer(ctx.getStringAttribute("shadowFlag")));
    student.getShadow().setShadowInactive(new Integer(ctx.getStringAttribute("shadowInactive")));
    student.getShadow().setShadowLastChange(new Long(ctx.getStringAttribute("shadowLastChange")));
    student.getShadow().setShadowMax(new Integer(ctx.getStringAttribute("shadowMax")));
    student.getShadow().setShadowMin(new Integer(ctx.getStringAttribute("shadowMin")));
    student.getShadow().setShadowWarning(new Integer(ctx.getStringAttribute("shadowWarning")));

    student.setId(student.getUser().getLogin());
    student.setDRE(ctx.getStringAttribute("DRE"));
    student.setOperator(ctx.getStringAttribute("monitor").equals("1"));
  }

  @Override
  public void mapToContext(Student register, DirContextOperations ctx) {
    ctx.setAttributeValues("objectclass", STUDENT_OBJECT_CLASS);

    ctx.setAttributeValue("cota", register.getUser().getLimitHDSpace());
    ctx.setAttributeValue("uid", register.getUser().getLogin());
    ctx.setAttributeValue("cn", register.getPerson().getName());
    ctx.setAttributeValue("sn", register.getPerson().getSurname());
    ctx.setAttributeValue("emailExterno", register.getPerson().getExternMail());
    ctx.setAttributeValue("telephoneNumber", register.getPerson().getPhoneNumber());
    ctx.setAttributeValue("displayName", register.getPerson().getDisplayName());
    ctx.setAttributeValue("homeDirectory", register.getServerData().getHomeDirectory());
    ctx.setAttributeValue("loginShell", register.getServerData().getLoginShellApplication());
    ctx.setAttributeValue("gidNumber", register.getServerData().getGidNumber());
    ctx.setAttributeValue("uidNumber", register.getServerData().getUidNumber());
    ctx.setAttributeValue("gecos", register.getServerData().getGecos());
    ctx.setAttributeValue("sambaSID", register.getSamba().getSambaSID());
    ctx.setAttributeValue("sambaAcctFlags", register.getSamba().getSambaAcctFlags());
    ctx.setAttributeValue("sambaKickoffTime", register.getSamba().getSambaKickoffTime());
    ctx.setAttributeValue("sambaLMPassword", register.getSamba().getSambaLMPassword());
    ctx.setAttributeValue("sambaNTPassword", register.getSamba().getSambaNTPassword());
    ctx.setAttributeValue("sambaPrimaryGroupSID", register.getSamba().getSambaPrimaryGroupSID());
    ctx.setAttributeValue("sambaPwdCanChange", register.getSamba().getSambaPwdCanChange());
    ctx.setAttributeValue("sambaPwdLastSet", register.getSamba().getSambaPwdLastSet());
    ctx.setAttributeValue("sambaPwdMustChange", register.getSamba().getSambaPwdMustChange());
    ctx.setAttributeValue("shadowExpire", register.getShadow().getShadowExpire());
    ctx.setAttributeValue("shadowFlag", register.getShadow().getShadowFlag());
    ctx.setAttributeValue("shadowInactive", register.getShadow().getShadowInactive());
    ctx.setAttributeValue("shadowLastChange", register.getShadow().getShadowLastChange());
    ctx.setAttributeValue("shadowMax", register.getShadow().getShadowMax());
    ctx.setAttributeValue("shadowMin", register.getShadow().getShadowMin());
    ctx.setAttributeValue("shadowWarning", register.getShadow().getShadowWarning());

    ctx.setAttributeValue("DRE", register.getDRE());
    ctx.setAttributeValue("monitor", register.isOperator() ? 1 : 0);
  }
}
